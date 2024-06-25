/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.Chuongtrinhdaotao;
import com.lnht.pojo.Diemtrungtuyen;
import com.lnht.pojo.Khoa;
import com.lnht.pojo.Nganh;
import com.lnht.pojo.Thongtin;
import com.lnht.repository.FacultyRepository;
import com.lnht.repository.InformationRepository;
import com.lnht.service.FacultyService;
import com.lnht.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author minh-nguyen
 */
@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepo;

    @Autowired
    private InformationRepository informationRepo;
    
    @Override
    public Khoa getFacultyById(int id) {
        return facultyRepo.getFacultyById(id);
    }

    @Override
    public Nganh getMajorById(int id) {
        return facultyRepo.getMajorById(id);
    }

    @Override
    public Chuongtrinhdaotao getEducationProgramById(int id) {
        return facultyRepo.getEducationProgramById(id);
    }

    @Override
    public void postOrEditFaculty(Khoa f, Map<String, Object> params, HttpServletRequest request) {
        HttpSession session = request.getSession();

        Thongtin t = new Thongtin();
        t.setId(Integer.valueOf((String) params.get("id")));
        t.setNoidung((String) params.get("noidung"));
        t.setTieude((String) params.get("tenkhoa"));
        informationRepo.addOrUpdate(t);

        Khoa k = f;
        
        k.setId(t.getId());
        k.setVideo((String) params.get("video"));
        k.setTenkhoa((String) params.get("tenkhoa"));
        k.setThongtin(t);
       
        facultyRepo.postOrEditFaculty(k);
        
//        MultipartFile avatar = (MultipartFile) params.get("file");
//
//        // user.getFile()
//        if ("".equals(avatar.getOriginalFilename()) == false) {
//            try {
//                MultipartFile file = avatar;
//                String fileName = file.getOriginalFilename();
////                /home/minh-nguyen/projects/hotrotuyensinh_project/AdmissionSupportSystem/admissionsupport_backend_v1/src/main/webapp
//                String rootDir = request.getSession()
//                        .getServletContext().getRealPath("/resources/videos/");
//                rootDir = rootDir.replaceAll("^[A-Za-z]{1}:{1}", "");
//                file.transferTo(new File(rootDir + fileName));
//
//                session.setAttribute("video-file", file.getOriginalFilename());
//
//                student.setAvatar(FileUtils.findRelativePath(file.getOriginalFilename()));
//            } catch (IOException | IllegalStateException ex) {
//                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            if (user.getId() != null) {
//                String fileName = (String) session.getAttribute("video-file");
//
//                student.setAvatar(FileUtils.findRelativePath(fileName));
//            }
//        }

    }

    @Override
    public void postOrEditMajor(Nganh w, Map<String, Object> params, HttpServletRequest request) {
        HttpSession session = request.getSession();
        
        Nganh k = w;
        
        k.setId(Integer.parseInt((String) params.get("id")));
        k.setTen((String) params.get("ten"));
        k.setKhoa(facultyRepo.getFacultyById(Integer.parseInt((String) params.get("khoaid"))));
        
        facultyRepo.postOrEditMajor(k);
    }

    @Override
    public void postOrEditEducationProgram(Chuongtrinhdaotao e ,Map<String, Object> params, HttpServletRequest request) {
    HttpSession session = request.getSession();
        
        
        Chuongtrinhdaotao k = e;
        
        k.setId(Integer.parseInt((String) params.get("id")));
        k.setTen((String) params.get("ten"));
        k.setMota((String) params.get("mota"));
        
        facultyRepo.postOrEditEducationProgram(k);
    }

    @Override
    public void deleteFaculty(int id) {
        facultyRepo.deleteFaculty(id);
    }

    @Override
    public void deleteMajor(int id) {
        facultyRepo.deleteMajor(id);

    }

    @Override
    public void deleteEducationProgram(int id) {
        facultyRepo.deleteEducationProgram(id);
    }

    @Override
    public List<Khoa> getAll(Map<String, Object> params) {
        return facultyRepo.getAll(params);
    }
    @Override
    public List<Khoa> getAllFaculty() {
        return facultyRepo.getAllFaculty();
    }
    @Override
    public List<Nganh> getAllMajor() {
        return facultyRepo.getAllMajor();
    }
    @Override
    public List<Chuongtrinhdaotao> getAllEducationProgram() {
        return facultyRepo.getAllEducationProgram();
    }
    
    @Override
    public List<Nganh> getAllMajor(Map<String, Object> params) {
        return facultyRepo.getAllMajor(params);
    }

    @Override
    public List<Chuongtrinhdaotao> getAllEducationProgram(Map<String, Object> params) {
        return facultyRepo.getAllEducationProgram(params);
    }

    @Override
    public int countFaculty() {
        return facultyRepo.countFaculty();
    }

    @Override
    public int countMajor() {
        return facultyRepo.countMajor();
    }

    @Override
    public int countEducationProgram() {
        return facultyRepo.countEducationProgram();
    }

    @Override
    public void postOrEditAdmissionScore(Diemtrungtuyen d, Map<String, Object> params, HttpServletRequest request) {
            Diemtrungtuyen w = d;
        w.setChuongtrinhdaotao(this.getEducationProgramById(Integer.parseInt((String)  params.get("chuongtrinhdaotaoid"))));
        w.setKhoa(this.getFacultyById(Integer.parseInt((String) params.get("khoaid"))));
        w.setNganh(this.getMajorById(Integer.parseInt((String) params.get("nganhid"))));
        w.setDiem(d.getDiem());
        w.setNamhoc(d.getNamhoc());
        w.setId(d.getId());
        
        
        facultyRepo.postOrEditAdmissionScore(w);
    }

    @Override
    public void deleteAdmisisonScore(int id) {
        facultyRepo.deleteAdmissionScore(id);
    }

    @Override
    public Diemtrungtuyen getAdmissionScoreById(int id){
        return facultyRepo.getAdmissionScoreById(id);
    }
    @Override
    public int countAdmissionScore() {
        return facultyRepo.countAdmissionScore();
    }

    @Override
    public List<Diemtrungtuyen> getAllAdmissionScore(Map<String, Object> params) {
        return facultyRepo.getAdmissionScore(params);
    }

}
