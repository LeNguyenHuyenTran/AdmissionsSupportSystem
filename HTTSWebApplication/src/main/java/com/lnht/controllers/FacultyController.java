/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.Chuongtrinhdaotao;
import com.lnht.pojo.Khoa;
import com.lnht.pojo.Nganh;
import com.lnht.pojo.Tintuyensinh;
import com.lnht.service.AdmissionNewsService;
import com.lnht.service.FacultyService;
import com.lnht.service.TypeOfAdmissionService;
import com.lnht.utils.OTPNumber;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author minh-nguyen
 */
@Controller
public class FacultyController {
        @Autowired
    private FacultyService facultyService;
    
    
    @Autowired
    private Environment env;
    
    @GetMapping("/faculty")
    public String createView(Model model, HttpSession session, @RequestParam Map<String,String> params){
            String e = params.get("current-tab");
        
        // faculty, major, educationProgram
        if(e==null){
            e = (String) session.getAttribute("current-tab");
            if(e == null)
                e = "faculty";
        }
        
        model.addAttribute("currentTab", e);
        
        
        String pF = params.get("faculty-page");
                String pM = params.get("major-page");
        String pE = params.get("education-program-page");

        int P1=1;int P2=1;int P3=1;
        if(pF!=null)
            P1 = Integer.parseInt(pF);
        if(pM!=null)
            P2 = Integer.parseInt(pM);
        if(pE!=null)
            P3=Integer.parseInt(pE);
        
        
        String TinyMCEKey = this.env.getProperty("TinyMCE_Key");
        
        String page =  params.getOrDefault("page", String.valueOf(1));
        int page_size = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        
        model.addAttribute("faculties", facultyService.getAll(params));
        model.addAttribute("faculties1", facultyService.getAll());

        model.addAttribute("majors", facultyService.getAllMajor(params));
        model.addAttribute("educationPrograms", facultyService.getAllEducationProgram(params));
        System.out.println(facultyService.getAll(params));
                System.out.println(facultyService.getAllMajor(params));
        System.out.println(facultyService.getAllEducationProgram(params));

                
        model.addAttribute("facultyQuantity", Math.ceil(facultyService.countFaculty()*1.0/page_size));
        model.addAttribute("majorQuantity", Math.ceil(facultyService.countMajor()*1.0/page_size));
        model.addAttribute("educationProgramQuantity", Math.ceil(facultyService.countEducationProgram()*1.0/page_size));

        System.out.println(Math.ceil(facultyService.countFaculty()*1.0/page_size));
                System.out.println(Math.ceil(facultyService.countMajor()*1.0/page_size));
        System.out.println(Math.ceil(facultyService.countEducationProgram()*1.0/page_size));
                        model.addAttribute("UID", OTPNumber.generateOTP());

        model.addAttribute("title", "Faculty");
        model.addAttribute("TinyMCE_Key", TinyMCEKey);
        model.addAttribute("currentFacultyPage",P1);
        model.addAttribute("currentMajorPage",P2);
        model.addAttribute("currentEducationProgramPage",P3);

                
        return "faculty";
    }
    @PostMapping("/faculty")
    public String add(@ModelAttribute(value="faculty") Khoa f, HttpSession session, @RequestParam Map<String,Object> params, HttpServletRequest request,  BindingResult result){
        if(result.hasErrors())
            return "redirect:/faculty";
        String facultyFormType =(String) params.get("faculty");
        String majorFormType = (String) params.get("major");
        String educationFormType = (String) params.get("educationProgram");
        
        if(facultyFormType!=null){
            this.facultyService.postOrEditFaculty(f, params, request);

        }
        
        String e = (String) params.get("current-tab");
       session.setAttribute("current-tab", e);
        return "redirect:/faculty";
    }
    
    @PostMapping("/faculty/major")
    public String add2(@ModelAttribute(value="major") Nganh n, HttpSession session, @RequestParam Map<String,Object> params, HttpServletRequest request,  BindingResult result){
        if(result.hasErrors())
            return "redirect:/faculty";
        String facultyFormType =(String) params.get("faculty");
        String majorFormType = (String) params.get("major");
        String educationFormType = (String) params.get("educationProgram");
        
        if(majorFormType!=null){
            this.facultyService.postOrEditMajor(n, params, request);

        }
        
        
        String e = (String) params.get("current-tab");
       session.setAttribute("current-tab", e);
        return "redirect:/faculty";
    }
    
    @PostMapping("/faculty/education-program")
    public String add1(@ModelAttribute(value="educationProgram") Chuongtrinhdaotao c, HttpSession session, @RequestParam Map<String,Object> params, HttpServletRequest request,  BindingResult result){
        if(result.hasErrors())
            return "redirect:/faculty";
        String facultyFormType =(String) params.get("faculty");
        String majorFormType = (String) params.get("major");
        String educationFormType = (String) params.get("educationProgram");
        
        if(educationFormType!=null){
            this.facultyService.postOrEditEducationProgram(c, params, request);
        }
        
        String e = (String) params.get("current-tab");
       session.setAttribute("current-tab", e);
        
        return "redirect:/faculty";
    }
    
    
    
    
    @GetMapping("/faculty/{id}")
    public String getFaculty(Model model, HttpSession session, @PathVariable(value = "id") int id){
                String TinyMCEKey = this.env.getProperty("TinyMCE_Key");

        Khoa t = this.facultyService.getFacultyById(id);
                model.addAttribute("UID", OTPNumber.generateOTP());

        model.addAttribute("faculty", t);
        model.addAttribute("title", "Detail Faculty");
                model.addAttribute("TinyMCE_Key", TinyMCEKey);
            
        session.setAttribute("current-tab", "faculty");
        return "detailFaculty";
    }
     @GetMapping("/faculty/major/{id}")
    public String getMajor(Model model, HttpSession session, @PathVariable(value = "id") int id){
                String TinyMCEKey = this.env.getProperty("TinyMCE_Key");

        Nganh t = this.facultyService.getMajorById(id);

        model.addAttribute("major", t);
        model.addAttribute("title", "Detail Major");
                model.addAttribute("TinyMCE_Key", TinyMCEKey);
                model.addAttribute("faculties1", facultyService.getAll());
        session.setAttribute("current-tab", "major");


        return "detailMajor";
    }
     @GetMapping("/faculty/education-program/{id}")
    public String getEducationProgram(Model model, HttpSession session, @PathVariable(value = "id") int id){
                String TinyMCEKey = this.env.getProperty("TinyMCE_Key");

        Chuongtrinhdaotao t = this.facultyService.getEducationProgramById(id);

        model.addAttribute("educationProgram", t);
        model.addAttribute("title", "Detail Education Program");
        model.addAttribute("TinyMCE_Key", TinyMCEKey);
        session.setAttribute("current-tab", "educationProgram");


        return "detailEducationProgram";
    }
    @DeleteMapping("/faculty/delete/{id}")
    public String deleteFaculty(@PathVariable(value = "id") int id){
        this.facultyService.deleteFaculty(id);
        return "redirect:/faculty";
    }
        @DeleteMapping("/faculty/major/delete/{id}")
    public String deleteMajor(@PathVariable(value = "id") int id){
        this.facultyService.deleteMajor(id);
        return "redirect:/faculty";
    }
        @DeleteMapping("/faculty/education-program/delete/{id}")
    public String deleteEducationProgram(@PathVariable(value = "id") int id){
        this.facultyService.deleteEducationProgram(id);
        return "redirect:/faculty";
    }
}
