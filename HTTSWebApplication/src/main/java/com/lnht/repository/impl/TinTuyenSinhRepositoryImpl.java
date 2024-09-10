/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository.impl;

import com.lnht.pojo.TinTuyenSinh;
import com.lnht.repository.TinTuyenSinhRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class TinTuyenSinhRepositoryImpl implements TinTuyenSinhRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Autowired
    private Environment env;
    
    @Override
    public List<TinTuyenSinh> getTinTuyenSinh(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<TinTuyenSinh> q = b.createQuery(TinTuyenSinh.class);
        Root root = q.from(TinTuyenSinh.class);
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
                int pageSize = Integer.parseInt(this.env.getProperty("news.pageSize").toString());
                int start = (Integer.parseInt(p) - 1) * pageSize;
                query.setFirstResult(start);
                query.setMaxResults(pageSize);
            }
        }
        return query.getResultList();
    }

    @Override
    public TinTuyenSinh getTinTuyenSinhById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(TinTuyenSinh.class, id);
    }
    
}
