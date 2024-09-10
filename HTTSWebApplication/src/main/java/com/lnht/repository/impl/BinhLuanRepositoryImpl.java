/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository.impl;

import com.lnht.pojo.BinhLuan;
import com.lnht.repository.BinhLuanRepository;
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
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class BinhLuanRepositoryImpl implements BinhLuanRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<BinhLuan> getBinhLuan(int newId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From BinhLuan Where tinTuyenSinhId.id=:id");
        q.setParameter("id", newId);
        
        return q.getResultList();
    }

    @Override
    public BinhLuan addBinhLuan(BinhLuan c) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(c);
            return c;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
