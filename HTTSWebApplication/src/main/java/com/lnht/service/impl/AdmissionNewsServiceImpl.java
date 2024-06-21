/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.Loaituyensinh;
import com.lnht.pojo.Thongtin;
import com.lnht.pojo.Tintuyensinh;
import com.lnht.repository.InformationRepository;
import com.lnht.repository.TypeOfAdmissionRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnht.utils.OTPNumber;
import com.lnht.service.AdmissionNewsService;
import com.lnht.repository.AdmissionNewsRepository;
import com.lnht.repository.CommentRepository;
/**
 *
 * @author minh-nguyen
 */
@Service
public class AdmissionNewsServiceImpl implements AdmissionNewsService {

    @Autowired
    private AdmissionNewsRepository newsRepo;
    
    @Autowired
    private CommentRepository commentRepo;
    
    @Autowired
    private InformationRepository informationRepo;
    
    @Autowired
    private TypeOfAdmissionRepository typeOfAdmissionRepo;

    @Override
    public void postOrEdit(Tintuyensinh t) {

        newsRepo.postOrEdit(t);
    }
    @Override
    public void add(Map<String, Object> params, Tintuyensinh w) {
        if (params != null) {
            Tintuyensinh b = w;
            b.setBinhluanSet(commentRepo.getAll());
            Thongtin t = new Thongtin();
            t.setId(Integer.parseInt((String)params.get("id")));
            t.setNoidung((String)params.get("noidung"));
            t.setTieude((String)params.get("tieude"));
                        informationRepo.addOrUpdate(t);

            b.setId(Integer.parseInt((String)params.get("id")));
            Loaituyensinh x = typeOfAdmissionRepo.getById(Integer.parseInt((String)params.get("loaituyensinhid")));
            b.setLoaituyensinh(x);
            
            b.setThongtin(t);
            b.setBinhluanSet(commentRepo.getAll());
            newsRepo.postOrEdit(b);
        }
    }

    @Override
    public List<Tintuyensinh> getAll(){
        return newsRepo.getAll();
    }

    
    @Override
    public Tintuyensinh getById(int id) {
        return newsRepo.getById(id);
    }

    @Override
    public List<Tintuyensinh> getAll(Map<String, String> params, String type) {
        return newsRepo.getAll(params, type);
    }

    @Override
    public void delete(int id) {
        newsRepo.delete(id);
    }

    @Override
    public int count() {
        return newsRepo.count();
    }
}
