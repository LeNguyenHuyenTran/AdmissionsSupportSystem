/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.BinhLuan;
import com.lnht.pojo.TinTuyenSinh;
import com.lnht.service.BinhLuanService;
import com.lnht.service.TinTuyenSinhService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiTinTuyenSinhController {
    @Autowired
    private TinTuyenSinhService tinTSService;
    @Autowired
    private BinhLuanService binhLuanService;
    
    @GetMapping("/news/")
    @CrossOrigin
    public ResponseEntity<List<TinTuyenSinh>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.tinTSService.getTinTuyenSinh(params), HttpStatus.OK);
    }
    
    @GetMapping(path="/news/{newId}/", produces = MediaType.APPLICATION_JSON_VALUE )
    @CrossOrigin
    public ResponseEntity<TinTuyenSinh> retrieve(@PathVariable(value = "newId") int id) {
        return new ResponseEntity<>(this.tinTSService.getTinTuyenSinhById(id), HttpStatus.OK);
    }
    
    @GetMapping("/news/{newId}/comments/")
    @CrossOrigin
    public ResponseEntity<List<BinhLuan>> listBinhLuans(@PathVariable(value = "newId") int newId) {
        return new ResponseEntity<>(this.binhLuanService.getBinhLuan(newId), HttpStatus.OK);
    }
    
    @PostMapping(path="/comments/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<BinhLuan> addComment(@RequestBody BinhLuan binhLuan) {
        BinhLuan c = this.binhLuanService.addBinhLuan(binhLuan);
        
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
}
