/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.lnht.pojo.Admin;
import com.lnht.pojo.Nguoituvan;
import com.lnht.pojo.Thisinh;
import com.lnht.pojo.User;
import com.lnht.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
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
    private LocalSessionFactoryBean factory;

    @Override
    public List<User> getUsersByRole(String roleType){
        Session session = this.factory.getObject().getCurrentSession();
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<User> q = b.createQuery(User.class);
//        Root root = q.from(User.class);
//        q.select(root);
//        roleType = String.format("%%%s%%", roleType);
//        Predicate p = b.like(root.get("role").get("id"), roleType);
//        q.where(p);
        return null;
    }

    
    @Override
    public List<User> getUsers(Map<String, Object> params) {
        
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);
        
        if(params!=null){
//            String userRoleType = (String) params.get("userrole");
            Predicate p1 = null;
            Predicate p2 = null;
            Predicate p3 = null;
            
            
//            userRoleType = String.format("%%%s%%", userRoleType);
//            if (userRoleType!=null && !userRoleType.isEmpty())
//                p5 = b.like(root.get("role").get("id"), userRoleType);
            String kw = (String) params.get("keyword");
            if (kw != null && !kw.isEmpty()) {  
                kw = String.format("%%%s%%", kw);
                p1 = b.like(root.get("hoten"), kw);
                p2 = b.like(root.get("username"), kw);
                p3 = b.like(root.get("password"), kw);
//                p4 = b.like(root.get("role").get("id"), kw);
                q = q.where(b.or(p1, p2, p3));
            }
            
//            if(kw==null){
//                q = q.where(p5);
//            }else{
//                q = q.where(b.or(p1, p2, p3, p4), p5);
//            }
        }
        
        Query query = session.createQuery(q);
        if (params != null) {
            String p = (String) params.get("page");
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
    public List<User> getUsers() {
        
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);
        
        Query query = session.createQuery(q);

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
    public void addOrUpdateStudent(Thisinh student){
        Session session = this.factory.getObject().getCurrentSession();
        Thisinh isStudent = session.get(Thisinh.class, student.getId());
        if (isStudent!=null){
            session.clear();
            session.update(student);
        }
        else
            session.save(student);
    }

    @Override
    public void addOrUpdateInstructor(Nguoituvan instructor){
                Session session = this.factory.getObject().getCurrentSession();
        Nguoituvan isInstructor = session.get(Nguoituvan.class, instructor.getId());
        if (isInstructor!=null){
            session.clear();
            session.update(instructor);
        }
        else
            session.save(instructor);
    }
    @Override
    public void addOrUpdateAdmin(Admin admin){
        Session session = this.factory.getObject().getCurrentSession();
        Admin isAdmin = session.get(Admin.class, admin.getId());
        if (isAdmin!=null){
            session.clear();
            session.update(admin);
        }
        else
            session.save(admin);
    }
    
    
    @Override
    public User getUserById(int id){
         Session session = this.factory.getObject().getCurrentSession();
        return session.get(User.class, id);
    }
    
    @Override
    public Admin getAdminById(int id){
         Session session = this.factory.getObject().getCurrentSession();
        return session.get(Admin.class, id);
    }    
    
    @Override
    public Nguoituvan getInstructorById(int id){
         Session session = this.factory.getObject().getCurrentSession();
        return session.get(Nguoituvan.class, id);
    }
    
    @Override
    public Thisinh getStudentById(int id){
         Session session = this.factory.getObject().getCurrentSession();
        return session.get(Thisinh.class, id);
    }
    
     @Override
    public void deleteUser(int id) {
//        type = type.toLowerCase().replaceAll("\\s+", "");
//        ArrayList<String> types = new ArrayList<String>();
//        // value not name attribute
//        types.add("1"); // admin
//        types.add("2"); // instructor
//        types.add("3"); // student
        Session session = this.factory.getObject().getCurrentSession();
        User user = session.get(User.class, id);
        
            if(user.getRole().getId().equals(1)){
            Admin admin = session.get(Admin.class, id);
            session.delete(admin);

        }else if(user.getRole().getId().equals(2)){
            Nguoituvan instructor = session.get(Nguoituvan.class, id);
            session.delete(instructor);
            
        }else if(user.getRole().getId().equals(3)){
            Thisinh student = session.get(Thisinh.class, id);
            session.delete(student);

        }
                    session.delete(user);

//        if (types.contains(type)) {
//            Session session = this.factory.getObject().getCurrentSession();
//            if (type.equals(types.get(0))) {
//                Admin admin = session.get(Admin.class, id);
//                session.delete(admin);
//            } else if (type.equals(types.get(1))) {
//                Nguoituvan instructor = session.get(Nguoituvan.class, id);
//                session.delete(instructor);
//            } else if (type.equals(types.get(2))){
//                Thisinh student = session.get(Thisinh.class, id);
//                session.delete(student);
//            }
//        }
    }

    @Override
    public int countUser() {
//        type = type.toLowerCase().replaceAll("\\s+", "");
//        ArrayList<String> types = new ArrayList<String>();
//        // value not name attribute
//        types.add("1"); // admin
//        types.add("2"); // instructor
//        types.add("3"); // student            
Session session = this.factory.getObject().getCurrentSession();

                Query query = session.createQuery("SELECT Count(*) FROM User");

                return Integer.parseInt(query.getSingleResult().toString());

//        if (types.contains(type)) {
//            Session session = this.factory.getObject().getCurrentSession();
//            if (type.equals(types.get(0))) {
//                Query query = session.createQuery("SELECT Count(*) FROM Admin");
//
//                return Integer.parseInt(query.getSingleResult().toString());
//            } else if (type.equals(types.get(1))) {
//                Query query = session.createQuery("SELECT Count(*) FROM Nguoituvan");
//
//                return Integer.parseInt(query.getSingleResult().toString());
//            } else if (type.equals(types.get(2))){
//                Query query = session.createQuery("SELECT Count(*) FROM Thisinh");
//
//                return Integer.parseInt(query.getSingleResult().toString());
//                
//            }
//        } else {
//            return 0;
//        }
//        return 0;
    }
    
    

}
