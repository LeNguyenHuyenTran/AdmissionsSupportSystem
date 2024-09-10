/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.Khoa;
import com.lnht.service.KhoaService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiKhoaController {
    @Autowired
    private KhoaService khoaService;
    
    @GetMapping("/faculties/")
    @CrossOrigin
    public ResponseEntity<List<Khoa>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.khoaService.getKhoa(params), HttpStatus.OK);
    }
}
