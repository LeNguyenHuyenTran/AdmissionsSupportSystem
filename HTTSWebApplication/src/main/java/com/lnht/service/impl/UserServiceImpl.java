/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.utils.FileUtils;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.lnht.pojo.Admin;
import com.lnht.pojo.Nguoituvan;
import com.lnht.pojo.Thisinh;
import com.lnht.pojo.User;
import com.lnht.pojo.Userrole;
import com.lnht.repository.CommentRepository;
import com.lnht.repository.ImageRepository;
import com.lnht.repository.LivestreamNotifyRepository;
import com.lnht.repository.QuestionRepository;
import com.lnht.repository.UserRepository;
import com.lnht.repository.UserRoleRepository;
import com.lnht.service.UserService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author minh-nguyen
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private ImageRepository imageRepo;

    @Autowired
    private UserRoleRepository userRoleRepo;

    @Autowired
    private LivestreamNotifyRepository livestreamNotifyRepo;

    @Autowired
    private QuestionRepository questionRepo;

    @Override
    public List<User> getUsers(Map<String, Object> params) {
        return userRepo.getUsers(params);
    }

    @Override
    public void addOrUpdateUser(User user, HttpServletRequest request, Map<String, Object> params) {
        HttpSession session = request.getSession();

        user.setBinhluanSet(commentRepo.getAll());
        user.setBannerSet(imageRepo.getAllBannerWithSetType());

        int roleId = Integer.parseInt((String) params.get("roleid"));
        if (roleId > 0) {
            Userrole role = userRoleRepo.getById(roleId);
            user.setRole(role);
            switch (roleId) {
                case 3:
                    Thisinh student = new Thisinh();
                    student.setId(user.getId());
                    student.setCauhoiSet(questionRepo.getAll());
                    //+@#!|===========> set image for student
                    MultipartFile avatar = (MultipartFile) params.get("file");
                    // user.getFile()
                    if ("".equals(avatar.getOriginalFilename()) == false) {
                        try {
                            MultipartFile file = avatar;
                            String fileName = file.getOriginalFilename();
                            String rootDir = request.getSession()
                                    .getServletContext().getRealPath("/resources/images/");
                            rootDir = rootDir.replaceAll("^[A-Za-z]{1}:{1}", "");
                            file.transferTo(new File(rootDir + fileName));

                            session.setAttribute("image-file", file.getOriginalFilename());

                            student.setAvatar(FileUtils.findRelativePath(file.getOriginalFilename()));
                        } catch (IOException | IllegalStateException ex) {
                            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        if (user.getId() != null) {
                            String fileName = (String) session.getAttribute("image-file");

                            student.setAvatar(FileUtils.findRelativePath(fileName));
                        }
                    }   // |=====>set image is complete
                    user.setThisinh(student);
                    userRepo.addOrUpdateUser(user);
                    userRepo.addOrUpdateStudent(student);
                    
                    break;
                case 2:
                    Nguoituvan instructor = new Nguoituvan();
                    instructor.setId(user.getId());
                    instructor.setThongbaolivestreamSet(livestreamNotifyRepo.getAllWithSetType());
                    user.setNguoituvan(instructor);
                    userRepo.addOrUpdateUser(user);
                    userRepo.addOrUpdateInstructor(instructor);
                    
                    break;
                case 1:
                    Admin admin = new Admin();
                    admin.setId(user.getId());
                    admin.setAnhSet(imageRepo.getAllImageWithSetType());
                    user.setAdmin(admin);
                    userRepo.addOrUpdateUser(user);
                    userRepo.addOrUpdateAdmin(admin);
                    break;
                default:
                    break;
            }

        }

    }

    @Override
    public List<User> getUsers(){
        return this.userRepo.getUsers();
    }

    
    @Override
    public int countUser() {
        return this.userRepo.countUser();
    }

    @Override
    public User getUserById(int id) {
        return this.userRepo.getUserById(id);
    }

    @Override
    public Admin getAdminById(int id) {
        return this.userRepo.getAdminById(id);
    }

    @Override
    public Nguoituvan getInstructorById(int id) {
        return this.userRepo.getInstructorById(id);
    }

    @Override
    public Thisinh getStudentById(int id) {
        return this.userRepo.getStudentById(id);
    }

    @Override
    public void deleteUser(int id) {
        this.userRepo.deleteUser(id);
    }

}
