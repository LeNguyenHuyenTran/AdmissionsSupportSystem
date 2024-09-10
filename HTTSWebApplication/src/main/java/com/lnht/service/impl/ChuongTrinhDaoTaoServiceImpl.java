/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.ChuongTrinhDaoTao;
import com.lnht.repository.ChuongTrinhDaoTaoRepository;
import com.lnht.service.ChuongTrinhDaoTaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ChuongTrinhDaoTaoServiceImpl implements ChuongTrinhDaoTaoService{
    @Autowired
    private ChuongTrinhDaoTaoRepository ctdtRepo;

    @Override
    public List<ChuongTrinhDaoTao> getChuongTrinhDaoTaos() {
        return this.ctdtRepo.getChuongTrinhDaoTaos();
    }

    @Override
    public ChuongTrinhDaoTao getChuongTrinhDaoTaoById(int id) {
        return this.ctdtRepo.getChuongTrinhDaoTaoById(id);
    }
    
}
