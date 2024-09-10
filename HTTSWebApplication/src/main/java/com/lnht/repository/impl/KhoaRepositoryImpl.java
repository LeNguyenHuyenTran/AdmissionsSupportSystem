/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository.impl;

import com.lnht.pojo.Khoa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.lnht.repository.KhoaRepository;
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

/**
 *
 * @author Admin
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class KhoaRepositoryImpl implements KhoaRepository{
    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Khoa> getKhoa(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Khoa> q = b.createQuery(Khoa.class);
        Root root = q.from(Khoa.class);
        q.select(root);

        if (params != null) {
            String kw = params.get("keyword");
            if (kw != null && !kw.isEmpty()) {
                kw = String.format("%%%s%%", kw);
                Predicate p1 = b.like(root.get("tenKhoa"), kw);

                q = q.where(p1);
            }
        }
        Query query = session.createQuery(q);
        if (params != null) {
            String p = params.get("page");
            if (p != null && !p.isEmpty()) {
                int pageSize = Integer.parseInt(this.env.getProperty("faculties.pageSize").toString());
                int start = (Integer.parseInt(p) - 1) * pageSize;
                query.setFirstResult(start);
                query.setMaxResults(pageSize);
            }
        }
        return query.getResultList();
    }

    @Override
    public void addOrUpdateKhoa(Khoa khoa) {
        Session session = this.factory.getObject().getCurrentSession();
        Khoa k = session.get(Khoa.class, khoa.getId());
        if (k!=null)
        {
            session.clear();
            session.update(khoa);
        }
        session.save(khoa);
    }

    @Override
    public void deleteKhoa(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Khoa khoa = session.get(Khoa.class, id);
        
        session.delete(khoa);
    }

    @Override
    public Khoa getKhoaById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        
        return session.get(Khoa.class, id);
    }
}
