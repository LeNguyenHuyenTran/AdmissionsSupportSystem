/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author minh-nguyen
 */
@RestController
@RequestMapping("api/")
public class ApiGetUid {
    @GetMapping(path = "/uid/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Map<String,String>> getUid(){
        Map<String,String> body = new HashMap<>();
        body.put("uid", com.lnht.utils.OTPNumber.generateOTP());
        return new ResponseEntity<>(body, HttpStatus.OK);  
    }
    
}
