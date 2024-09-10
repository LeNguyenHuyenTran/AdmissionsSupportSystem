/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.Khoa;
import com.lnht.repository.KhoaRepository;
import com.lnht.service.KhoaService;
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
 * @author Admin
 */
@Service
public class KhoaServiceImpl implements KhoaService {
    
    @Autowired
    private KhoaRepository khoaRepo;

    @Override
    public List<Khoa> getKhoa(Map<String, String> params) {
        return this.khoaRepo.getKhoa(params);
    }

    @Override
    public void addOrUpdateKhoa(Khoa khoa, HttpServletRequest request) {
        HttpSession session = request.getSession();
        
//        MultipartFile file = khoa.getFile();
//        if (file != null && !file.isEmpty()) {
//            try {
//                String fileName = file.getOriginalFilename();
//                String rootDir = request.getSession().getServletContext().getRealPath("/resources/videos/");
//                File dir = new File(rootDir);
//                if (!dir.exists()) {
//                    dir.mkdirs();
//                }
//                file.transferTo(new File(dir + File.separator + fileName));
//                
//                session.setAttribute("video-file", fileName);
//                khoa.setVideo("/resources/videos/" + fileName);
//            } catch (IOException | IllegalStateException ex) {
//                Logger.getLogger(KhoaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            if (khoa.getId() != null) {
//                String fileName = (String) session.getAttribute("video-file");
//                khoa.setVideo("/resources/videos/" + fileName);
//            }
//        }
//
//        khoaRepo.addOrUpdateKhoa(khoa);
        
        if ("".equals(khoa.getFile().getOriginalFilename()) == false) {
            try {
                MultipartFile file = khoa.getFile();
                String fileName = file.getOriginalFilename();
                String rootDir = request.getSession()
                        .getServletContext().getRealPath("/resources/images/");
                rootDir = rootDir.replaceAll("^[A-Za-z]{1}:{1}", "");
                file.transferTo(new File(rootDir + fileName));
                session.setAttribute("image-file", file.getOriginalFilename());
                
                khoa.setVideo(FileUtils.findRelativePath(file.getOriginalFilename()));
            } catch (IOException | IllegalStateException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            if(khoa.getId()!=null){
                String fileName = (String) session.getAttribute("image-file");
                
                khoa.setVideo(FileUtils.findRelativePath(fileName));
            }
        }

        khoaRepo.addOrUpdateKhoa(khoa);
    }

    @Override
    public void deleteKhoa(int id) {
        khoaRepo.deleteKhoa(id);
    }

    @Override
    public Khoa getKhoaById(int id) {
        return khoaRepo.getKhoaById(id);
    }
}
