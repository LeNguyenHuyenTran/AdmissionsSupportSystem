/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository.impl;

import com.lnht.pojo.Binhluan;
import com.lnht.pojo.Chuongtrinhdaotao;
import com.lnht.pojo.Khoa;
import com.lnht.pojo.Nganh;
import com.lnht.pojo.Thongtin;
import com.lnht.pojo.Tintuyensinh;
import com.lnht.repository.FacultyRepository;
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
public class FacultyRepositoryImpl implements FacultyRepository {

    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Khoa getFacultyById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Khoa.class, id);
    }

    @Override
    public Nganh getMajorById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Nganh.class, id);
    }

    @Override
    public Chuongtrinhdaotao getEducationProgramById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Chuongtrinhdaotao.class, id);
    }

    @Override
    public void postOrEditFaculty(Khoa t) {
        Session session = this.factory.getObject().getCurrentSession();
        Khoa T = session.get(Khoa.class, t.getId());
        if (T != null) {
            session.clear();
            session.update(t);
        } else {
            session.save(t);
        }
    }

    @Override
    public void postOrEditMajor(Nganh t) {
        Session session = this.factory.getObject().getCurrentSession();
        Nganh T = session.get(Nganh.class, t.getId());
        if (T != null) {
            session.clear();
            session.update(t);
        } else {
            session.save(t);
        }
    }

    @Override
    public void postOrEditEducationProgram(Chuongtrinhdaotao t) {
        Session session = this.factory.getObject().getCurrentSession();
        Chuongtrinhdaotao T = session.get(Chuongtrinhdaotao.class, t.getId());
        if (T != null) {
            session.clear();
            session.update(t);
        } else {
            session.save(t);
        }
    }

    @Override
    public void deleteFaculty(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Khoa t = session.get(Khoa.class, id);
        Thongtin q = session.get(Thongtin.class, id);
        session.delete(t);
        session.delete(q);
    }

    @Override
    public void deleteMajor(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Nganh t = session.get(Nganh.class, id);
        Thongtin w = session.get(Thongtin.class, t.getId());
        session.delete(t);
    }

    @Override
    public void deleteEducationProgram(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Chuongtrinhdaotao t = session.get(Chuongtrinhdaotao.class, id);
        session.delete(t);
    }

    @Override
    public List<Khoa> getAll(Map<String, String> params) {
        if (params != null) {

            String page = params.getOrDefault("faculty-page", String.valueOf(1));

            Session session = this.factory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaQuery<Khoa> q = b.createQuery(Khoa.class);
            Root root = q.from(Khoa.class);
            q.select(root);

            String kw = params.get("facultyKeyword");
            if (kw != null && !kw.isEmpty()) {
                kw = String.format("%%%s%%", kw);
//                        Predicate p1 = b.like(root.get("id"), kw);
                Predicate p2 = b.like(root.get("tenkhoa"), kw);
                        Predicate p3 = b.like(root.get("video"), kw);

                q = q.where(b.or(p2,p3));
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
            return null;
        }
    }
    @Override
    public List<Khoa> getAll() {


            Session session = this.factory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaQuery<Khoa> q = b.createQuery(Khoa.class);
            Root root = q.from(Khoa.class);
            q.select(root);

            
            Query query = session.createQuery(q);
            

            return query.getResultList();
        
    }
    @Override
    public List<Nganh> getAllMajor(Map<String, String> params) {
        if (params != null) {

            String page = params.getOrDefault("major-page", String.valueOf(1));

            Session session = this.factory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaQuery<Nganh> q = b.createQuery(Nganh.class);
            Root root = q.from(Nganh.class);
            q.select(root);

            String kw = params.get("majorKeyword");
            if (kw != null && !kw.isEmpty()) {
                kw = String.format("%%%s%%", kw);
                        
                Predicate p2 = b.like(root.get("ten"), kw);
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
        } else {
            return null;
        }
    }

    @Override
    public List<Chuongtrinhdaotao> getAllEducationProgram(Map<String, String> params) {
        if (params != null) {

            String page = params.getOrDefault("education-program-page", String.valueOf(1));

            Session session = this.factory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();

            CriteriaQuery<Chuongtrinhdaotao> q = b.createQuery(Chuongtrinhdaotao.class);
            Root root = q.from(Chuongtrinhdaotao.class);
            q.select(root);

            String kw = params.get("educationProgramKeyword");
            if (kw != null && !kw.isEmpty()) {
                kw = String.format("%%%s%%", kw);
                        
                Predicate p2 = b.like(root.get("ten"), kw);
                        Predicate p3 = b.like(root.get("mota"), kw);

                q = q.where(b.or(p2,p3));
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
            return null;
        }
    }

    @Override
    public int countFaculty() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT Count(*) FROM Khoa");

        return Integer.parseInt(query.getSingleResult().toString());
    }

    @Override
    public int countMajor() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT Count(*) FROM Nganh");

        return Integer.parseInt(query.getSingleResult().toString());
    }

    @Override
    public int countEducationProgram() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT Count(*) FROM Chuongtrinhdaotao");

        return Integer.parseInt(query.getSingleResult().toString());
    }

}
