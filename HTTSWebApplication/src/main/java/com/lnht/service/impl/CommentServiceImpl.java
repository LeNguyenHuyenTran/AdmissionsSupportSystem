/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.Binhluan;
import com.lnht.pojo.Tintuyensinh;
import com.lnht.pojo.User;
import com.lnht.repository.AdmissionNewsRepository;
import com.lnht.repository.CommentRepository;
import com.lnht.repository.LivestreamNotifyRepository;
import com.lnht.repository.UserRepository;
import com.lnht.service.CommentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnht.repository.AdmissionNewsRepository;
import com.lnht.repository.VideoLivestreamRepository;

/**
 *
 * @author minh-nguyen
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AdmissionNewsRepository admissionNewsRepo;

    @Override
    public void postOrEdit(Binhluan t) {
        commentRepo.postOrEdit(t);
    }

    public void add(Map<String, String> params) {
        Binhluan b = new Binhluan();
        b.setId(Integer.parseInt(params.get("id")));
        b.setBinhluan(params.get("binhluan"));
        b.setTintuyensinh(admissionNewsRepo.getById(Integer.parseInt(params.get("admissionnewsid"))));
        b.setNguoibinhluan(userRepo.getUserById(Integer.parseInt(params.get("userid"))));
        
        this.postOrEdit(b);
//        admissionNewsRepo.getById(Integer.parseInt(params.get("admissionnewsid"))).setBinhluanSet(commentRepo.getAll());
Tintuyensinh t = admissionNewsRepo.getById(Integer.parseInt(params.get("admissionnewsid")));
t.setBinhluanSet(commentRepo.getAll());
        admissionNewsRepo.postOrEdit(t);
        
//        userRepo.getUserById(Integer.parseInt(params.get("userid")))).setBinhluanSet(commentRepo.getAll();
User q = userRepo.getUserById(Integer.parseInt(params.get("userid")));
q.setBinhluanSet(commentRepo.getAll());  
userRepo.addOrUpdateUser(q);
        
    
    }

    @Override
    public Binhluan getById(int id) {
        return commentRepo.getById(id);
    }

    @Override
    public List<Binhluan> getAll(Map<String, String> params) {
        return commentRepo.getAll(params);
    }

    @Override
    public void delete(int id) {
        commentRepo.delete(id);
    }

    @Override
    public int count() {
        return commentRepo.count();
    }
}
