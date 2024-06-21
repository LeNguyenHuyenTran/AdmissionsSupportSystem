/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.Binhluan;
import com.lnht.pojo.CommentDTO;
import com.lnht.pojo.Tintuyensinh;
import com.lnht.service.AdmissionNewsService;
import com.lnht.service.CommentService;
import com.lnht.service.LivestreamNotifyService;
import com.lnht.service.UserService;
import com.lnht.service.VideoLivestreamNotifyService;
import java.util.Map;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
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
public class CommentController {
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private AdmissionNewsService admissionNewsService;
    
    @Autowired
    private UserService userService;
        
    @Autowired
    private VideoLivestreamNotifyService videoLivestreamNotifyService;
        
    @Autowired
    private LivestreamNotifyService livestreamNotifyService;
    
    
    @Autowired
    private Environment env;
    
    @GetMapping("/comments")
    public String createView(Model model,HttpServletRequest request, @RequestParam Map<String,String> params){
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        String p = params.get("page");
        int P = 1;
            if(p!=null)
                P=Integer.parseInt(p);
        System.out.println(commentService.getAll(params));
                System.out.println(userService.getUsers());
                System.out.println(Math.ceil(commentService.count()*1.0/pageSize));

                        System.out.println(admissionNewsService.getAll());
                                                System.out.println(P);


        model.addAttribute("comments", commentService.getAll(params));
            model.addAttribute("commentQuantity", Math.ceil(commentService.count()*1.0/pageSize));
        model.addAttribute("title", "Comments");
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("admissionNews", admissionNewsService.getAll());
        model.addAttribute("UID", OTPNumber.generateOTP());

        model.addAttribute("currentPage",P);
        return "comment";
    }
    @PostMapping("/comment")
    public String add(@ModelAttribute(value="comment") @Valid CommentDTO b, @RequestParam Map<String,String> params,  BindingResult result){
        if(result.hasErrors())
            return "redirect:/comments";
//        this.commentService.add(params);
        
        return "redirect:/comments";
    }
    @GetMapping("/comments/{id}")
    public String get(Model model, @PathVariable(value = "id") int id){
        Binhluan t = this.commentService.getById(id);
        
        model.addAttribute("comment", t);
        model.addAttribute("admissionNews", admissionNewsService.getAll());
                model.addAttribute("users", userService.getUsers());

        model.addAttribute("title", "Detail Comment");
                model.addAttribute("UID", OTPNumber.generateOTP());

        return "detailComment";
    }
    @DeleteMapping("/comments/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        this.commentService.delete(id);
        return "redirect:/comments";
    }
}
