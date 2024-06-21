/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository.impl;

import com.lnht.pojo.Anh;
import com.lnht.pojo.Banner;
import com.lnht.repository.ImageRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
public class ImageRepositoryImpl implements ImageRepository {

        @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public void postOrEdit(Anh t) {
            Session session = this.factory.getObject().getCurrentSession();
        Anh T = session.get(Anh.class, t.getId());
        if (T != null) {
            session.clear();
            session.update(t);
        } else {
            session.save(t);
        }
    }

    @Override
    public void postOrEdit(Banner t) {
            Session session = this.factory.getObject().getCurrentSession();
        Banner T = session.get(Banner.class, t.getId());
        if (T != null) {
            session.clear();
            session.update(t);
        } else {
            session.save(t);
        }

    }

    @Override
    public Anh getImageById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Anh.class, id);
    }

    @Override
    public Banner getBannerById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Banner.class, id);
    }

    @Override
    public Set<Anh> getAllImageWithSetType(){
        Session session = this.factory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Anh> q = b.createQuery(Anh.class);
                Root root = q.from(Anh.class);
                q.select(root);
                Query query = session.createQuery(q);
                return new HashSet<>(query.getResultList());
    }
    @Override
    public Set<Banner> getAllBannerWithSetType(){
                Session session = this.factory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Banner> q = b.createQuery(Banner.class);
                Root root = q.from(Banner.class);
                q.select(root);
                Query query = session.createQuery(q);
                return new HashSet<>(query.getResultList());
    }
    
    @Override
    public List<Object> getAll(Map<String, Object> params) {
        if (params != null) {
            String imageType = (String) params.get("image");
            String page = (String) params.getOrDefault("page", String.valueOf(1));
            Session session = this.factory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();
            if (imageType != null && "image".equals(imageType)) {
                CriteriaQuery<Anh> q = b.createQuery(Anh.class);
                Root root = q.from(Anh.class);
                q.select(root);

                Query query = session.createQuery(q);
                String p = page;
                if (p != null && !p.isEmpty()) {
                    int Int_page = Integer.parseInt(p);
                    int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                    query.setMaxResults(pageSize);
                    query.setFirstResult((Int_page - 1) * pageSize);
                }

                return query.getResultList();
            } else if (imageType != null && "banner".equals(imageType)) {
                CriteriaQuery<Banner> q = b.createQuery(Banner.class);
                Root root = q.from(Banner.class);
                q.select(root);
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
            return null;
    }

    @Override
    public void delete(int id, String type) {
        type = type.toLowerCase().replaceAll("\\s+", "");
        ArrayList<String> types = new ArrayList<String>();
        // value not name attribute
        types.add("image");
        types.add("banner");

        if (types.contains(type)) {
            Session session = this.factory.getObject().getCurrentSession();
            if (type.equals(types.get(0))) {
                Anh image = session.get(Anh.class, id);
                session.delete(image);
            } else if (type.equals(types.get(1))) {
                Banner banner = session.get(Banner.class, id);
                session.delete(banner);
            }
        }
    }

    @Override
    public int count(String type) {
        type = type.toLowerCase().replaceAll("\\s+", "");
        ArrayList<String> types = new ArrayList<String>();
        // value not name attribute
        types.add("image");
        types.add("banner");

        if (types.contains(type)) {
            Session session = this.factory.getObject().getCurrentSession();
            if (type.equals(types.get(0))) {
                Query query = session.createQuery("SELECT Count(*) FROM Anh");

                return Integer.parseInt(query.getSingleResult().toString());
            } else if (type.equals(types.get(1))) {
                Query query = session.createQuery("SELECT Count(*) FROM Banner");

                return Integer.parseInt(query.getSingleResult().toString());
            }
        } else {
            return 0;
        }
        return 0;
    }
    
}
