/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.Admin;
import com.lnht.pojo.Anh;
import com.lnht.pojo.Banner;
import com.lnht.pojo.User;
import com.lnht.repository.ImageRepository;
import com.lnht.repository.UserRepository;
import com.lnht.service.ImageService;
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
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepository imageRepo;

    @Autowired
    private UserRepository userRepo;
    
    @Override
    public List<Object> getAll(Map<String, Object> params) {
        return imageRepo.getAll(params);
    }

    @Override
    public void addOrUpdate(Banner b, HttpServletRequest request,Map<String,Object> params) {
        HttpSession session = request.getSession();
        
        User u = userRepo.getUserById(Integer.parseInt((String) params.get("userid")));
        b.setUserId(u);
        
        
        // user.getFile()
        if ("".equals(b.getFile().getOriginalFilename()) == false) {
            try {
                MultipartFile file = b.getFile();
                String fileName = file.getOriginalFilename();
//                /home/minh-nguyen/projects/hotrotuyensinh_project/AdmissionSupportSystem/admissionsupport_backend_v1/src/main/webapp
//                String rootDir = request.getSession()
//                        .getServletContext().getRealPath("/");
                String rootDir = request.getSession()
                        .getServletContext().getRealPath("/resources/images/");
                rootDir = rootDir.replaceAll("^[A-Za-z]{1}:{1}", "");
                file.transferTo(new File(rootDir + fileName));
                session.setAttribute("image-file", file.getOriginalFilename());
                
                b.setAnh(FileUtils.findRelativePath(file.getOriginalFilename()));
            } catch (IOException | IllegalStateException ex) {
                Logger.getLogger(ImageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            if(b.getId()!=null){
                String fileName = (String) session.getAttribute("image-file");
                if(fileName==null){
                   String anh = imageRepo.getBannerById(b.getId()).getAnh();
                   b.setAnh(anh);
                }else{
                    session.removeAttribute("image-file");
                    b.setAnh(FileUtils.findRelativePath(fileName));
                }
            }
        }

        imageRepo.postOrEdit(b);
        u.setBannerSet(imageRepo.getAllBannerWithSetType());
        userRepo.addOrUpdateUser(u);
    }
    
    @Override
    public void addOrUpdate(Anh b, HttpServletRequest request,Map<String,Object> params) {
        HttpSession session = request.getSession();
        
        User u = userRepo.getUserById(Integer.parseInt((String)params.get("userid")));
        b.setNguoidang(u.getAdmin());
        
        // user.getFile()
        if ("".equals(b.getFile().getOriginalFilename()) == false) {
            try {
                MultipartFile file = b.getFile();
                String fileName = file.getOriginalFilename();
//                /home/minh-nguyen/projects/hotrotuyensinh_project/AdmissionSupportSystem/admissionsupport_backend_v1/src/main/webapp
//                String rootDir = request.getSession()
//                        .getServletContext().getRealPath("/");
                String rootDir = request.getSession()
                        .getServletContext().getRealPath("/resources/images/");
                rootDir = rootDir.replaceAll("^[A-Za-z]{1}:{1}", "");
                file.transferTo(new File(rootDir + fileName));
                session.setAttribute("image-file", file.getOriginalFilename());
                
                b.setAnh(FileUtils.findRelativePath(file.getOriginalFilename()));
            } catch (IOException | IllegalStateException ex) {
                Logger.getLogger(ImageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            if(b.getId()!=null){
                String fileName = (String) session.getAttribute("image-file");
                if(fileName==null){
                   String anh = imageRepo.getImageById(b.getId()).getAnh();
                   b.setAnh(anh);
                }else{
                    session.removeAttribute("image-file");
                    b.setAnh(FileUtils.findRelativePath(fileName));
                }

            }
        }

        imageRepo.postOrEdit(b);
        Admin a = u.getAdmin();
        a.setAnhSet(imageRepo.getAllImageWithSetType());
        userRepo.addOrUpdateAdmin(a);

    }

    @Override
    public void add(Object o, Map<String,Object> params,HttpServletRequest request){
        if(params!=null){
            String imageType =(String) params.get("image");
            String bannerType =(String) params.get("banner");
            if(imageType!=null){
                Anh a = (Anh) o;
                a.setId(Integer.parseInt( (String) params.get("id")));
                this.addOrUpdate(a, request, params);
            }else if(bannerType!=null){
                Banner b = (Banner) o;
                b.setId(Integer.parseInt( (String) params.get("id")));
                this.addOrUpdate(b, request, params);
            }
        }
    }
    @Override
    public Anh getImageById(int id){
        return imageRepo.getImageById(id);
    }
    @Override
    public Banner getBannerById(int id){
        return imageRepo.getBannerById(id);
    }
    @Override
    public void delete(int id, String type){
        imageRepo.delete(id, type);
    }
    @Override
    public int count(String type){
        return imageRepo.count(type);
    }
}
