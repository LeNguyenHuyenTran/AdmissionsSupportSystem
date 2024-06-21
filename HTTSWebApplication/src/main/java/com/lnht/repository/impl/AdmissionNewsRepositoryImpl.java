/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository.impl;

import com.lnht.pojo.Thongtin;
import com.lnht.pojo.Tintuyensinh;
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
import com.lnht.repository.AdmissionNewsRepository;

/**
 *
 * @author minh-nguyen
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class AdmissionNewsRepositoryImpl implements AdmissionNewsRepository {

    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public void postOrEdit(Tintuyensinh t) {
        Session session = this.factory.getObject().getCurrentSession();
        Tintuyensinh T = session.get(Tintuyensinh.class, t.getId());
        if (T != null) {
            session.clear();
            session.update(t);
        } else {
            session.save(t);
        }
    }

    @Override
    public Tintuyensinh getById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Tintuyensinh.class, id);
    }

    @Override
    public void delete(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Tintuyensinh t = session.get(Tintuyensinh.class, id);
        
        Thongtin q = session.get(Thongtin.class, id);
        
        session.delete(t);
        session.delete(q);

        

    }

    @Override
    public int count() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT Count(*) FROM Tintuyensinh");

        return Integer.parseInt(query.getSingleResult().toString());
    }

    @Override
    public List<Tintuyensinh> getAll() {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery q = b.createQuery(Tintuyensinh.class);;
        Root root = q.from(Tintuyensinh.class);;

        q.select(root);
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Tintuyensinh> getAll(Map<String, String> params, String type) {

        if (params != null) {
            String tintucType = params.get("tintuc");
            String page =  params.getOrDefault("page", String.valueOf(1));
            Session session = this.factory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery q = null;
            Root root = null;

            if (tintucType == null) {
                q = b.createQuery(Tintuyensinh.class);
                root = q.from(Tintuyensinh.class);
                q.select(root);

                String kw = params.get("keyword");

                if (kw != null && !kw.isEmpty()) {
                    kw = String.format("%%%s%%", kw);
//                    Predicate p2 = b.like(root.get("tieude"), kw);
//                    q = q.where(b.or(p2));
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
            } else {
                if (tintucType.equals("tintuyensinh") || tintucType.equals("tatca")) {
                    q = b.createQuery(Tintuyensinh.class);
                    root = q.from(Tintuyensinh.class);
                    q.select(root);

                    String kw = params.get("keyword");

                    if (kw != null && !kw.isEmpty()) {
                        kw = String.format("%%%s%%", kw);

//                        Predicate p2 = b.like(root.get("tieude"), kw);
//                        q = q.where(b.or(p2));

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
                }
            }

        }

        return null;
    }
}
