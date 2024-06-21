/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.Loaituyensinh;
import com.lnht.repository.TypeOfAdmissionRepository;
import com.lnht.service.TypeOfAdmissionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author minh-nguyen
 */
@Service
public class TypeOfAdmissionServiceImpl implements TypeOfAdmissionService{

    @Autowired
    private TypeOfAdmissionRepository typeOfAdmissionRepo;
    
    @Override
    public List<Loaituyensinh> getAll() {
        return typeOfAdmissionRepo.getAll();
    }

    @Override
    public Loaituyensinh getById(int id) {
        return typeOfAdmissionRepo.getById(id);
    }
    
}
