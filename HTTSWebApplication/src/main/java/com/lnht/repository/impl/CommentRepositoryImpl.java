/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository.impl;

import com.lnht.pojo.Binhluan;
import com.lnht.repository.CommentRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
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
public class CommentRepositoryImpl implements CommentRepository {

    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public void postOrEdit(Binhluan t) {
        Session session = this.factory.getObject().getCurrentSession();
        Binhluan T = session.get(Binhluan.class, t.getId());
        if (T != null) {
            session.clear();
            session.update(t);
        } else {
            session.save(t);
        }
    }

    @Override
    public void delete(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Binhluan t = session.get(Binhluan.class, id);
        session.delete(t);

    }

    @Override
    public Set<Binhluan> getAll(){
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Binhluan> q = b.createQuery(Binhluan.class);
        Root root = q.from(Binhluan.class);
        q.select(root);
        
        Query query = session.createQuery(q);
        
        return new HashSet<>(query.getResultList());
    }

    
    @Override
    public List<Binhluan> getAll(Map<String, String> params) {
        if (params != null) {

            String page = params.getOrDefault("page", String.valueOf(1));

            Session session = this.factory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaQuery<Binhluan> q = b.createQuery(Binhluan.class);
            Root root = q.from(Binhluan.class);
            q.select(root);

            String kw = params.get("keyword");
            if (kw != null && !kw.isEmpty()) {
                kw = String.format("%%%s%%", kw);
//                        
                Predicate p2 = b.like(root.get("binhluan"), kw);
//                        Predicate p3 = b.like(root.get("tintuyensinhId").get("id"), kw);

                q = q.where(b.or(p2));
            }
            Query query = session.createQuery(q);
            String p = page;
            if (p != null && !p.isEmpty()) {
                int Int_page = Integer.parseInt(p);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                query.setMaxResults(pageSize);
                query.setFirstResult((Int_page - 1) * pageSize);
            }

            return query.getResultList();
        }else
            return null;
    }

    @Override
    public Binhluan getById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Binhluan.class, id);
    }

    @Override
    public int count() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT Count(*) FROM Binhluan");

        return Integer.parseInt(query.getSingleResult().toString());
    }

}
