/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.User;
import com.lnht.pojo.UserDTO;
import com.lnht.service.UserService;
import com.lnht.service.UserroleService;
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
import com.lnht.utils.*;
import com.lnht.validator.QuestionValidator;
import com.lnht.validator.UserValidator;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
/**
 *
 * @author minh-nguyen
 */
@Controller
public class UserController {
    

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserroleService userRoleService;
    
    @Autowired
    private Environment env;
    
    
    @GetMapping("/user")
    public String createView(Model model, @RequestParam Map<String,Object> params){
        String p = (String) params.get("page");
        int P = 1;
        if(p!=null)
            P = Integer.parseInt(p);
//        String roleType =  (String) params.get("userrole");
//        if(roleType==null){
//            // admin type
//            roleType="1";
//        }
//        model.addAttribute("userRoleType", roleType);
            
        int page = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
            model.addAttribute("users", userService.getUsers(params));
        model.addAttribute("userRoles", userRoleService.getAll());

        model.addAttribute("roles", userRoleService.getAll());
        model.addAttribute("userQuantity", Math.ceil(userService.countUser()*1.0/page));
        model.addAttribute("title", "Users");
        model.addAttribute("currentPage",P);
        model.addAttribute("UID", OTPNumber.generateOTP());
        System.out.println(userService.getUsers(params));
                System.out.println(userRoleService.getAll());
        System.out.println(Math.ceil(userService.countUser()*1.0/page));
        System.out.println(P);
        String TinyMCEKey = this.env.getProperty("TinyMCE_Key");
        model.addAttribute("TinyMCE_Key", TinyMCEKey);

        return "user";
    }
    @PostMapping("/user")
    public String add(Model model, @ModelAttribute(value = "user") @Valid UserDTO user, BindingResult result, HttpServletRequest request, @RequestParam Map<String,Object> params){
        if(result.hasErrors())
            return this.createView(model, params);
//        this.userService.addOrUpdateUser(user, request, params);
        
        return "redirect:/user";
    }
    @GetMapping("/user/{id}")
    public String get(Model model, @PathVariable(value = "id") int id, HttpServletRequest request){
        User user = this.userService.getUserById(id);
        
        model.addAttribute("user", user);
        model.addAttribute("roles", userRoleService.getAll());
        model.addAttribute("title", "Detail Users");
                model.addAttribute("UID", OTPNumber.generateOTP());

        return "detailUser";
    }
    @DeleteMapping("/user/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        this.userService.deleteUser(id);
        return "redirect:/";
    }
}
