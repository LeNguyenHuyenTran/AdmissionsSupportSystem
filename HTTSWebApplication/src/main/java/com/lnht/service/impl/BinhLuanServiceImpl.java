/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.BinhLuan;
import com.lnht.pojo.User;
import com.lnht.repository.BinhLuanRepository;
import com.lnht.repository.UserRepository;
import com.lnht.service.BinhLuanService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class BinhLuanServiceImpl implements BinhLuanService{
    @Autowired
    private BinhLuanRepository binhLuanRepo;

    @Autowired
    private UserRepository userRepo;
    
    @Override
    public List<BinhLuan> getBinhLuan(int newId) {
        return this.binhLuanRepo.getBinhLuan(newId);
    }

    @Override
    public BinhLuan addBinhLuan(BinhLuan c) {
        c.setCreatedDate(new Date());
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.userRepo.getUser(authentication.getName());
        c.setUserId(u);
        
        return this.binhLuanRepo.addBinhLuan(c);
    }
    
}
