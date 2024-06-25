/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.AdmissionNewsDTO;
import com.lnht.pojo.AdmissionScoreDTO;
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
import com.lnht.validator.AdmissionNewsValidator;
import com.lnht.validator.AdmissionScoreValidator;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.validation.BindingResult;

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
    public String createView(Model model, @RequestParam Map<String, Object> params, Authentication authentication) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            String sortType = (String) params.get("sort");

            if (sortType == null) {
                model.addAttribute("sortType", "default");
            } else {
                if ("".equals(sortType)) {
                    model.addAttribute("sortType", "default");
                }
                if ("asc".equals(sortType)) {
                    model.addAttribute("sortType", "asc");
                }
                if ("desc".equals(sortType)) {
                    model.addAttribute("sortType", "desc");
                }
            }
            String p =(String) params.get("page");
            int P = 1;
            if (p != null) {
                P = Integer.parseInt(p);
            }else{
                P=1;
                params.put("page", "1");
            }
            String TinyMCEKey = this.env.getProperty("TinyMCE_Key");

//        String page =  params.getOrDefault("page", String.valueOf(1));
            String type =(String) params.getOrDefault("type", "tintuyensinh");
            int page_size = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

            String b =(String) params.get("tintuc");
            if (b == null) {
                b = "tatca";
            }
            params.put("tintuc", b);
            model.addAttribute("tintuc", b);
            model.addAttribute("UID", OTPNumber.generateOTP());
            System.out.println(OTPNumber.generateOTP());

            model.addAttribute("typeOfAdmissions", typeOfAdmissionService.getAll());
            System.out.println(typeOfAdmissionService.getAll());
            System.out.println("ok");
            model.addAttribute("admissionNews", admissionNewsService.getAll(params, type));
            
            admissionNewsService.getAll(params, type).forEach(i->{
                            System.err.print(i.getId()+"-");
                            System.err.println(i.getThongtin().getId());
                            System.err.println(i.getThongtin().getTieude());
                            
                System.err.println(i.getThongtin().getNoidung());
            });
            
            System.out.println(admissionNewsService.getAll(params, type));

            model.addAttribute("admissionNewsQuantity", Math.ceil(admissionNewsService.count() * 1.0 / page_size));
            model.addAttribute("admissionNewsQ", admissionNewsService.count());
            System.out.println(Math.ceil(admissionNewsService.count() * 1.0 / page_size));

            model.addAttribute("title", "News");
            model.addAttribute("TinyMCE_Key", TinyMCEKey);
            model.addAttribute("currentPage", P);
            return "admissionNews";
        }else{
            return "error";
        }

    }

    @PostMapping("/admission-news")
    public String add(HttpSession session, Model model, @ModelAttribute("admissionNews") Tintuyensinh t,HttpServletRequest request, @RequestParam Map<String, Object> params, Authentication authentication) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            AdmissionNewsDTO anDTO = new AdmissionNewsDTO();
            anDTO.setId(Integer.parseInt((String)params.get("id")));
            anDTO.setLoaituyensinhid((String)params.get("loaituyensinhid"));
            anDTO.setNoidung((String)params.get("noidung"));
            anDTO.setTieude((String)params.get("tieude"));
            
            AdmissionNewsValidator anValidator = new AdmissionNewsValidator();
            if(anValidator.validate(anDTO)==false){
                session.setAttribute("createAdmissionNewsMessage", (String)params.get("id")+" was not created");
                session.setAttribute("admissionNewsErrors", anValidator.getErrors());
                String prev = request.getHeader("Referer");
                if (prev.contains(String.valueOf(anDTO.getId())) == true) {
                    return "redirect:" + prev;
                } else {
                    return "redirect:" + prev;
                }
            }else{
                this.admissionNewsService.add(params, t);
                session.setAttribute("createAdmissionNewsMessage", (String)params.get("id")+" is created!");
                session.removeAttribute("admissionNewsErrors");
                String prev = request.getHeader("Referer");
                if (prev.contains(String.valueOf(anDTO.getId())) == true) {
                    prev = prev.replace(String.valueOf(anDTO.getId()), "");
                    prev = prev.replaceAll("admission-news\\/.*", "admission-news\\/");
//                    prev = prev.concat("?current-tab=" + e);
                    return "redirect:" + prev;
                } else {
                    return "redirect:" + prev;
                }
            }
            
        }else{
            return "error";
        }
//        if(result.hasErrors())
//            return "redirect:/admission-news";

    }

    @GetMapping("/admission-news/{id}")
    public String get(Model model, @PathVariable(value = "id") int id, Authentication authentication) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
             Tintuyensinh t = this.admissionNewsService.getById(id);
        String TinyMCEKey = this.env.getProperty("TinyMCE_Key");

        model.addAttribute("admissionNews", t);
        model.addAttribute("title", "Detail News");
        model.addAttribute("typeOfAdmissions", typeOfAdmissionService.getAll());

        model.addAttribute("UID", OTPNumber.generateOTP());
        model.addAttribute("TinyMCE_Key", TinyMCEKey);

        return "detailAdmissionNews";
        }else{
            return "error";
        }
       
    }

    @DeleteMapping("/admission-news/delete/{id}")
    public String delete(@PathVariable(value = "id") int id,HttpSession session,Model model, @RequestParam Map<String, Object> params, Authentication authentication) {
         Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            this.admissionNewsService.delete(id);
             session.setAttribute("createAdmissionNewsMessage", id+", was deleted!");
            return this.createView(model, params, authentication);
        }else{
            return "error";
        }        
    }
}
