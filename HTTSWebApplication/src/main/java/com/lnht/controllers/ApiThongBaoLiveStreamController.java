/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.ThongBaoLivestream;
import com.lnht.service.ThongBaoLivestreamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiThongBaoLiveStreamController {
    @Autowired
    private ThongBaoLivestreamService thongBaoService;
    
    @GetMapping("/notify/")
    @CrossOrigin
    public ResponseEntity<List<ThongBaoLivestream>> list() {
        return new ResponseEntity<>(this.thongBaoService.getThongBaoLivestreams(), HttpStatus.OK);
    }
    
}
