/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.Userrole;
import com.lnht.repository.UserRoleRepository;
import com.lnht.service.UserroleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author minh-nguyen
 */
@Service
public class UserroleServiceImpl implements UserroleService{

    @Autowired
    private UserRoleRepository userRoleRepo;
    
    @Override
    public List<Userrole> getAll() {
        return userRoleRepo.getAll();
    }

    @Override
    public Userrole getById(int id){
        return userRoleRepo.getById(id);
    }
    
}
