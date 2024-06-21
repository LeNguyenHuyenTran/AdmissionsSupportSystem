/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.Cauhoi;
import com.lnht.pojo.Thisinh;
import com.lnht.pojo.User;

import com.lnht.repository.AdmissionNewsRepository;
import com.lnht.repository.CommentRepository;
import com.lnht.repository.LivestreamNotifyRepository;
import com.lnht.repository.QuestionRepository;
import com.lnht.repository.UserRepository;
import com.lnht.service.QuestionService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnht.repository.VideoLivestreamRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh-nguyen
 */
@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AdmissionNewsRepository admissionNewsRepo;

    @Autowired
    private LivestreamNotifyRepository livestreamNotifyRepo;
    
    @Autowired
    private VideoLivestreamRepository videoLivestreamRepo;
    
    
    @Override
    public void postOrEdit(Cauhoi t) {
        questionRepo.postOrEdit(t);
    }

    @Override
    public void add(Cauhoi e, Map<String, Object> params) {
        Cauhoi b = e;
        
        b.setId(Integer.parseInt((String) params.get("id")));
        b.setNoidung((String) params.get("noidung"));
//        b.setTintuyensinh(admissionNewsRepo.getById(Integer.parseInt((String) params.get("admissionnewsid"))));
        b.setThisinh(userRepo.getStudentById(Integer.parseInt((String) params.get("userid"))));
        String dateTimeString = (String) params.get("thoidiemdate");
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

// Parse the string into a LocalDateTime
LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);

// Convert LocalDateTime to Date
Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        b.setThoidiem(date);
        b.setThongbaolivestream(livestreamNotifyRepo.getById(Integer.parseInt((String) params.get("livestreamnotifyid"))));
        b.setVideo(videoLivestreamRepo.getById(Integer.parseInt((String) params.get("videolivestreamid"))));
        
        this.postOrEdit(b);
//        userRepo.getStudentById(Integer.parseInt((String) params.get("userid"))));
        Thisinh q = userRepo.getStudentById(Integer.parseInt((String) params.get("userid")));
        q.setCauhoiSet(questionRepo.getAll());
        userRepo.addOrUpdateStudent(q);
    }

    @Override
    public Cauhoi getById(int id) {
        return questionRepo.getById(id);
    }

    @Override
    public List<Cauhoi> getAll(Map<String, Object> params) {
        return questionRepo.getAll(params);
    }

    @Override
    public void delete(int id) {
        questionRepo.delete(id);
    }

    @Override
    public int count() {
        return questionRepo.count();
    }
}
