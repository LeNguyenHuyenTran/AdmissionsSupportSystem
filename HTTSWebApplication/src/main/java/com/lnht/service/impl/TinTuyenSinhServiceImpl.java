/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.TinTuyenSinh;
import com.lnht.repository.TinTuyenSinhRepository;
import com.lnht.service.TinTuyenSinhService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class TinTuyenSinhServiceImpl implements TinTuyenSinhService{
    @Autowired
    private TinTuyenSinhRepository tinTSRepo;

    @Override
    public List<TinTuyenSinh> getTinTuyenSinh(Map<String, String> params) {
        return this.tinTSRepo.getTinTuyenSinh(params);
    }

    @Override
    public TinTuyenSinh getTinTuyenSinhById(int id) {
        return this.tinTSRepo.getTinTuyenSinhById(id);
    }
    
}
