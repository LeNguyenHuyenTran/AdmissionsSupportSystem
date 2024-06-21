/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.Thongbaolivestream;
import com.lnht.repository.LivestreamNotifyRepository;
import com.lnht.service.LivestreamNotifyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnht.repository.VideoLivestreamRepository;

/**
 *
 * @author minh-nguyen
 */
@Service
public class LivestreamNotifyServiceImpl implements LivestreamNotifyService{

    @Autowired
    private LivestreamNotifyRepository livestreamNotifyRepo;
    
    @Override
    public List<Thongbaolivestream> getAll() {
        return livestreamNotifyRepo.getAll();
    }

    @Override
    public Thongbaolivestream getById(int id) {
        return livestreamNotifyRepo.getById(id);
    }
    
}
