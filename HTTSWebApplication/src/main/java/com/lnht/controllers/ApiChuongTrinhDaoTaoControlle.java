/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.ChuongTrinhDaoTao;
import com.lnht.service.ChuongTrinhDaoTaoService;
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
public class ApiChuongTrinhDaoTaoControlle {
    @Autowired
    private ChuongTrinhDaoTaoService ctdtService;
    
    @GetMapping("/educationprogram/")
    @CrossOrigin
    public ResponseEntity<List<ChuongTrinhDaoTao>> list() {
        return new ResponseEntity<>(this.ctdtService.getChuongTrinhDaoTaos(), HttpStatus.OK);
    }
    
}
