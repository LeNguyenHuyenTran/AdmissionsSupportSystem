/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.ThongBaoLivestream;
import com.lnht.repository.ThongBaoLiveStreamRepository;
import com.lnht.service.ThongBaoLivestreamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ThongBaoLivestreamServiceImpl implements ThongBaoLivestreamService{
    @Autowired
    private ThongBaoLiveStreamRepository thongBaoRepo;

    @Override
    public List<ThongBaoLivestream> getThongBaoLivestreams() {
        return this.thongBaoRepo.getThongBaoLivestreams();
    }

    @Override
    public ThongBaoLivestream getThongBaoLivestreamById(int id) {
        return this.thongBaoRepo.getThongBaoLivestreamById(id);
    }
    
}
