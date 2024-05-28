/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.utils.FileUtils;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.lnht.pojo.User;
import com.lnht.repository.UserRepository;
import com.lnht.service.UserService;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author minh-nguyen
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> getUsers(Map<String, String> params) {
        return userRepo.getUsers(params);
    }

    @Override
    public void addOrUpdateUser(User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        
        // user.getFile()
        if ("".equals(user.getFile().getOriginalFilename()) == false) {
            try {
                MultipartFile file = user.getFile();
                String fileName = file.getOriginalFilename();
                String rootDir = request.getSession()
                        .getServletContext().getRealPath("/resources/images/");
                rootDir = rootDir.replaceAll("^[A-Za-z]{1}:{1}", "");
                file.transferTo(new File(rootDir + fileName));
                session.setAttribute("image-file", file.getOriginalFilename());
                
                user.setAvatar(FileUtils.findRelativePath(file.getOriginalFilename()));
            } catch (IOException | IllegalStateException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            if(user.getId()!=null){
                String fileName = (String) session.getAttribute("image-file");
                
                user.setAvatar(FileUtils.findRelativePath(fileName));
            }
        }

        userRepo.addOrUpdateUser(user);

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
    public void deleteUser(int id) {
        this.userRepo.deleteUser(id);
    }

    @Override
    public List<User> getUser(String username) {
        return this.userRepo.getUser(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUser(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Username does not exist!!!");
        }
        User user = users.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getRole()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);
    }

}
