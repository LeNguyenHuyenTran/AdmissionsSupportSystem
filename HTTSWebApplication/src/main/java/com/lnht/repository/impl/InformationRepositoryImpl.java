/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository.impl;

import com.lnht.pojo.Thongtin;
import com.lnht.repository.InformationRepository;
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
public class InformationRepositoryImpl implements InformationRepository{

    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public void addOrUpdate(Thongtin t) {
        Session session = this.factory.getObject().getCurrentSession();
        Thongtin T = session.get(Thongtin.class, t.getId());
        if (T != null) {
            session.clear();
            session.update(t);
        } else {
            session.save(t);
        }
    }
    
}
