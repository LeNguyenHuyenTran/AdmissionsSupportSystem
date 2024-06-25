/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.Tintuyensinh;
import com.lnht.service.AdmissionNewsService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author minh-nguyen
 */
@RestController
@RequestMapping("api/")
public class ApiAdmissionNews {
    @Autowired
    private AdmissionNewsService admisisonService;
    
    @GetMapping(path="/admission-news", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<List<Tintuyensinh>> get(@RequestParam Map<String,Object> params){
        
        return new ResponseEntity<>(admisisonService.getAll(params, "tintuyensinh"),HttpStatus.OK);
    }
}
