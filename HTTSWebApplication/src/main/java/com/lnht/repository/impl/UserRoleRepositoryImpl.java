/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository.impl;

import com.lnht.pojo.Userrole;
import com.lnht.repository.UserRepository;
import com.lnht.repository.UserRoleRepository;
import java.util.List;
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
public class UserRoleRepositoryImpl implements UserRoleRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Userrole> getAll() {
        Session session = this.factory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Userrole> q = b.createQuery(Userrole.class);
        Root root = q.from(Userrole.class);
        q.select(root);
        Query query = session.createQuery(q);
        return query.getResultList();

    }
    
    @Override
    public Userrole getById(int id){
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Userrole.class, id);
    }
}
