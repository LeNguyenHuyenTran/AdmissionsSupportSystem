/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.lnht.pojo.User;
import com.lnht.repository.UserRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author minh-nguyen
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private Environment env;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder; 

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public User getUser(String username) {
        Session session = this.factory.getObject().getCurrentSession(); 
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query.select(root);
        
        if(!username.isEmpty()) {
            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
            query = query.where(p);
        }
            
        Query q = session.createQuery(query);
        return (User) q.getSingleResult();
    }
    
    @Override
    public List<User> getUsers(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        if (params != null) {
            String kw = params.get("keyword");
            if (kw != null && !kw.isEmpty()) {
                kw = String.format("%%%s%%", kw);
                Predicate p1 = b.like(root.get("address"), kw);
                Predicate p2 = b.like(root.get("fullName"), kw);
                Predicate p3 = b.like(root.get("phone"), kw);
                Predicate p4 = b.like(root.get("role"), kw);

                q = q.where(b.or(p1, p2, p3, p4));
            }
        }
        Query query = session.createQuery(q);
        if (params != null) {
            String p = params.get("page");
            if (p != null && !p.isEmpty()) {
                int page = Integer.parseInt(p);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                query.setMaxResults(pageSize);
                query.setFirstResult((page - 1) * pageSize);
            }
        }

        return query.getResultList();

    }
    
    @Override
    public void addOrUpdateUser(User user) {
        Session session = this.factory.getObject().getCurrentSession();
            User isUser = session.get(User.class, user.getId());
        if (isUser!=null){
            session.clear();
            session.update(user);
        }
        else
            session.save(user);
    }
    

    @Override
    public int countUser() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT Count(*) FROM User");
        
        return Integer.parseInt(query.getSingleResult().toString());
    }

    @Override
    public User getUserById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        User user = session.get(User.class, id);
        session.delete(user);
    }

    @Override
    public boolean addUser(User user) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            session.save(user);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        
        return false;
    }

    @Override
    public boolean authUser(String username, String password) {
        User  u = this.getUser(username);
        
        return this.passwordEncoder.matches(password, u.getPassword());
    }
        
}
