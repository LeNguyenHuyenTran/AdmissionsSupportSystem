/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.Tintuyensinh;
import com.lnht.service.TypeOfAdmissionService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.lnht.service.AdmissionNewsService;
import com.lnht.utils.OTPNumber;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

/**
 *
 * @author minh-nguyen
 */
@Controller
public class AdmissionNewsController {
    @Autowired
    private AdmissionNewsService admissionNewsService;
    
    @Autowired
    private TypeOfAdmissionService typeOfAdmissionService;
    
    @Autowired
    private Environment env;
    
    @GetMapping("/admission-news")
    public String createView(Model model, @RequestParam Map<String,String> params){
        String p = params.get("page");
        int P=1;
        if(p!=null)
            P = Integer.parseInt(p);
        String TinyMCEKey = this.env.getProperty("TinyMCE_Key");
        
//        String page =  params.getOrDefault("page", String.valueOf(1));
        String type = params.getOrDefault("type", "tintuyensinh");
        int page_size = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

        String b =  params.get("tintuc");
        if(b==null){
            b="tatca";
        }
        params.put("tintuc", b);
        model.addAttribute("tintuc", b);
                model.addAttribute("UID", OTPNumber.generateOTP());
        System.out.println(OTPNumber.generateOTP());

            model.addAttribute("typeOfAdmissions", typeOfAdmissionService.getAll());
                        System.out.println(typeOfAdmissionService.getAll());
                        System.out.println("ok");
        model.addAttribute("admissionNews", admissionNewsService.getAll(params, type));
                System.out.println(admissionNewsService.getAll(params, type));

        model.addAttribute("admissionNewsQuantity", Math.ceil(admissionNewsService.count()*1.0/page_size));
        

                        System.out.println(Math.ceil(admissionNewsService.count()*1.0/page_size));

        
        
        model.addAttribute("title", "News");
        model.addAttribute("TinyMCE_Key", TinyMCEKey);
        model.addAttribute("currentPage",P);
        return "admissionNews";
    }
    @PostMapping("/admission-news")
    public String add(@ModelAttribute("admissionNews") Tintuyensinh t,  BindingResult result,@RequestParam Map<String, Object> params){
        if(result.hasErrors())
            return "redirect:/admission-news";
        this.admissionNewsService.add(params, t);
        
        return "redirect:/admission-news";
    }
    @GetMapping("/admission-news/{id}")
    public String get(Model model, @PathVariable(value = "id") int id){
        Tintuyensinh t = this.admissionNewsService.getById(id);
        String TinyMCEKey = this.env.getProperty("TinyMCE_Key");

        model.addAttribute("admissionNews", t);
        model.addAttribute("title", "Detail News");
                model.addAttribute("typeOfAdmissions", typeOfAdmissionService.getAll());

        model.addAttribute("UID", OTPNumber.generateOTP());
        model.addAttribute("TinyMCE_Key", TinyMCEKey);

        return "detailAdmissionNews";
    }
    @DeleteMapping("/admission-news/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        this.admissionNewsService.delete(id);
        return "redirect:/admission-news";
    }
}
