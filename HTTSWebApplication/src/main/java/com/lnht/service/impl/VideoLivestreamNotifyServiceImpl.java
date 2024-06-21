/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service.impl;

import com.lnht.pojo.Videolivestream;
import com.lnht.service.VideoLivestreamNotifyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnht.repository.VideoLivestreamRepository;

/**
 *
 * @author minh-nguyen
 */
@Service
public class VideoLivestreamNotifyServiceImpl implements VideoLivestreamNotifyService{
    @Autowired
    private VideoLivestreamRepository videoLivestreamNotifyRepo;

    @Override
    public List<Videolivestream> getAll() {
        return videoLivestreamNotifyRepo.getAll();
    }

    @Override
    public Videolivestream getById(int id) {
        return videoLivestreamNotifyRepo.getById(id);
    }
}
