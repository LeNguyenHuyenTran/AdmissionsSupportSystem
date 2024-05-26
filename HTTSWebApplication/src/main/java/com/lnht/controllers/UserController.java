/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.User;
import com.lnht.service.UserService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author minh-nguyen
 */
@Controller
public class UserController {
    

    @Autowired
    private UserService userService;
    
    @Autowired
    private Environment env;
    
    @GetMapping("/user")
    public String createView(Model model, @RequestParam Map<String,String> params){
        int page = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        model.addAttribute("users", userService.getUsers(params));
        model.addAttribute("userQuantity", Math.ceil(userService.countUser()*1.0/page));
        return "user";
    }
    @PostMapping("/user")
    public String add(@ModelAttribute("user") User user, HttpServletRequest request){
        this.userService.addOrUpdateUser(user, request);
        
        return "redirect:/user";
    }
    @GetMapping("/user/{id}")
    public String get(Model model, @PathVariable(value = "id") String id, HttpServletRequest request){
        User user = this.userService.getUserById(id);
        HttpSession session = request.getSession();
        String file = (String) session.getAttribute("image-file");
        if(file==null){
//            session.setAttribute("image-file", user.getAvatar());
        }
        
        String[] role = {"admin", "instructor", "student"};
        model.addAttribute("user", user);
        model.addAttribute("roles", role);
        return "detailUser";
    }
    @DeleteMapping("/user/delete/{id}")
    public String delete(@PathVariable(value = "id") String id){
        this.userService.deleteUser(id);
        return "redirect:/";
    }
}
