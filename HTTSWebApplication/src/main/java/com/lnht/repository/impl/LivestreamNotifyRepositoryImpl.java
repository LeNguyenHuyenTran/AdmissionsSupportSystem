/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository.impl;

import com.lnht.pojo.Thongbaolivestream;
import com.lnht.repository.LivestreamNotifyRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
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
public class LivestreamNotifyRepositoryImpl implements LivestreamNotifyRepository{

        @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Thongbaolivestream> getAll() {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Thongbaolivestream> q = b.createQuery(Thongbaolivestream.class);
        Root root = q.from(Thongbaolivestream.class);
        q.select(root);
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Thongbaolivestream getById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Thongbaolivestream.class, id);
    }

    @Override
    public Set<Thongbaolivestream> getAllWithSetType(){
        return new HashSet<>(this.getAll());
    }

}
