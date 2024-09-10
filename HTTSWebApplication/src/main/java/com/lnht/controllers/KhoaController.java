/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.Khoa;
import com.lnht.service.KhoaService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class KhoaController {
    @Autowired
    private KhoaService khoaService;
    
    @GetMapping("/faculty")
    public String facultyView(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("faculties", this.khoaService.getKhoa(params));
        
        return "faculty";
    }
    
    @PostMapping("/faculty")
    public String faculty(@ModelAttribute("khoa") Khoa khoa , HttpServletRequest request) {
        this.khoaService.addOrUpdateKhoa(khoa, request);
        
        return "redirect:/faculty";
    }
}
