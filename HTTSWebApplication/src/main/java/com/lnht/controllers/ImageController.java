/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.Anh;
import com.lnht.pojo.Banner;
import com.lnht.service.ImageService;
import com.lnht.service.UserService;
import com.lnht.utils.OTPNumber;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
public class ImageController {
    @Autowired
    private ImageService imageService;
    
    @Autowired
    private UserService userService;
       
    @Autowired
    private Environment env;
    
    @GetMapping("/images")
    public String createView(Model model, @RequestParam Map<String,Object> params){
        String p = (String) params.get("page");
        int P = 1;
        if (p!=null)
            P = Integer.parseInt(p);
        int page = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        
        String type = (String) params.get("image");
        if(type==null){
            type="image";
        }
        params.put("image", type);
        model.addAttribute("imageType", type);
        
        if(type.equals("image")){
            List<Object> i = imageService.getAll(params);
            List<Anh>  images;
            images = i.stream()
                    .map(element->(Anh) element)
                    .collect(Collectors.toList());
            model.addAttribute("images", images);

        }else if(type.equals("banner")){
            List<Object> i = imageService.getAll(params);
            List<Banner>  banners;
            banners = i.stream()
                    .map(element->(Banner) element)
                    .collect(Collectors.toList());
            model.addAttribute("images", banners);
        }
        
//        model.addAttribute("images", imageService.getAll(params));
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("UID", OTPNumber.generateOTP());

        model.addAttribute("imageQuantity", Math.ceil(imageService.count(type)*1.0/page));
        model.addAttribute("title", "Images");
        model.addAttribute("currentPage", P);
        System.out.println(imageService.getAll(params));
        System.out.println(userService.getUsers());
                System.out.println(OTPNumber.generateOTP());
                System.out.println(Math.ceil(imageService.count(type)*1.0/page));

        return "image";
    }
    @PostMapping("/images/image")
    public String add(@ModelAttribute("image") Anh o, @RequestParam Map<String,Object> params, HttpServletRequest request,  BindingResult result){
        if(result.hasErrors())
            return "image";
        this.imageService.add(o, params, request);
        return "redirect:/images";
    }
    @PostMapping("/images/banner")
    public String addd(@ModelAttribute("banner") Banner o, @RequestParam Map<String,Object> params, HttpServletRequest request,  BindingResult result){
        if(result.hasErrors())
            return "image";
        this.imageService.add(o, params, request);
        return "redirect:/images";
    }
    @GetMapping("/images/{id}-{type}")
    public String get(Model model, @PathVariable(value = "id") int id, @PathVariable(value="type") String type, @RequestParam Map<String,Object> params, HttpServletRequest request){
//        Banner b = this.imageService.getById(id);
//        HttpSession session = request.getSession();
        
        if(type.equals("image")){
            model.addAttribute("image", imageService.getImageById(id));
            model.addAttribute("banner", null);
            System.out.println(imageService.getImageById(id));
            model.addAttribute("UID", OTPNumber.generateOTP());
        System.out.println(OTPNumber.generateOTP());
        model.addAttribute("title", "Detail Image");
        model.addAttribute("users", userService.getUsers());

        return "detailImage";
        
        }else if(type.equals("banner")){
            model.addAttribute("banner", imageService.getBannerById(id));
            model.addAttribute("image", null);
            System.out.println(imageService.getBannerById(id));
            model.addAttribute("UID", OTPNumber.generateOTP());
        System.out.println(OTPNumber.generateOTP());
        model.addAttribute("title", "Detail Image");
        model.addAttribute("users", userService.getUsers());

        return "detailBanner";
        }
        return "redirect:/images";
    }
    @DeleteMapping("/images/delete/{id}-{type}")
    public String delete(@PathVariable(value = "id") int id, @PathVariable(value="type") String type, @RequestParam Map<String,String> params){
        this.imageService.delete(id, type);
        return "redirect:/images";
    }
}
