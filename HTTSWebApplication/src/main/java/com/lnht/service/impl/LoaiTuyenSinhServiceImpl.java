/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.LoaiTuyenSinh;
import com.lnht.repository.LoaiTuyenSinhRepository;
import com.lnht.service.LoaiTuyenSinhService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class LoaiTuyenSinhServiceImpl implements LoaiTuyenSinhService{
    @Autowired
    private LoaiTuyenSinhRepository loaiTSRepo;

    @Override
    public List<LoaiTuyenSinh> getLoaiTuyenSinhs() {
        return this.loaiTSRepo.getLoaiTuyenSinhs();
    }

    @Override
    public LoaiTuyenSinh getLoaiTuyenSinhById(int id) {
        return this.loaiTSRepo.getLoaiTuyenSinhById(id);
    }
    
}
