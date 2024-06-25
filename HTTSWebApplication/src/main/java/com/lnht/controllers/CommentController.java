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
import com.lnht.validator.CommentValidator;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public String createView(Model model, HttpServletRequest request, @RequestParam Map<String, String> params, Authentication authentication) {
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
            int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
            String p = params.get("page");
            int P = 1;
            if (p != null) {
                P = Integer.parseInt(p);
            } else {
                P = 1;
                params.put("page", String.valueOf(1));
            }
            System.out.println(commentService.getAll(params));
            System.out.println(userService.getUsers());
            System.out.println(Math.ceil(commentService.count() * 1.0 / pageSize));
            
            System.out.println(admissionNewsService.getAll());
            System.out.println(P);
            
            model.addAttribute("comments", commentService.getAll(params));
            model.addAttribute("commentQ", commentService.count() );
            model.addAttribute("commentQuantity", Math.ceil(commentService.count() * 1.0 / pageSize));
            model.addAttribute("title", "Comments");
            model.addAttribute("users", userService.getUsers());
            model.addAttribute("admissionNews", admissionNewsService.getAll());
            model.addAttribute("UID", OTPNumber.generateOTP());
            
            model.addAttribute("currentPage", P);
            return "comment";
        } else {
            return "error";
        }
    }
    
    @PostMapping("/comments")
    public String add(Model model, HttpSession session, @ModelAttribute CommentDTO b, HttpServletRequest request, @RequestParam Map<String, String> params, BindingResult result, Authentication authentication) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            
            b.setId(params.get("id"));
            b.setBinhluan(params.get("binhluan"));
            b.setAdmissionnewsid(params.get("admissionnewsid"));
            b.setUserid((String) params.get("userid"));
            
            CommentValidator cValidator = new CommentValidator();
            Boolean w = cValidator.validate(b);
            if (cValidator.validate(b) == false) {
                session.setAttribute("commentErrors", cValidator.getErrors());
                session.setAttribute("createCommentMessage", (String) params.get("id") + ", was not created!");
                String prev = request.getHeader("Referer");
                if (prev.contains(String.valueOf(b.getId())) == true) {
//                    prev = prev.replace(aScore.getId(), "");
//                    prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
//                    prev = prev.concat("?current-tab=" + e);
                    return "redirect:" + prev;
                } else {
                    return "redirect:" + prev;
                }
            } else {
                this.commentService.add(params);
                session.setAttribute("createCommentMessage", (String) params.get("id") + ", is created");
                session.removeAttribute("commentErrors");
                
                String prev = request.getHeader("Referer");
                if (prev.contains(b.getId()) == true) {
//                    prev = prev.replace(String.valueOf(b.getId()), "");
//                    prev = prev.replaceAll("comments\\/.*", "comments\\/");
//                    prev = prev.concat("?current-tab=" + e);
//                    return this.createView(model, request, params, authentication);
                    return "redirect:" + prev.replaceAll("comments\\/.*", "comments\\/");
                } else {
                    return "redirect:" + prev;
                }
            }
            
        } else {
            return "error";
        }
        
    }
    
    @GetMapping("/comments/{id}")
    public String get(Model model, @PathVariable(value = "id") int id, Authentication authentication) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            Binhluan t = this.commentService.getById(id);
            
            model.addAttribute("comment", t);
            model.addAttribute("admissionNews", admissionNewsService.getAll());
            model.addAttribute("users", userService.getUsers());
            
            model.addAttribute("title", "Detail Comment");
            model.addAttribute("UID", OTPNumber.generateOTP());
            
            return "detailComment";
        } else {
            return "error";
        }
        
    }
    
    @DeleteMapping("/comments/delete/{id}")
    public String delete(Model model, HttpSession session, @PathVariable(value = "id") int id, HttpServletRequest request, @RequestParam Map<String, String> params, Authentication authentication) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            this.commentService.delete(id);
            session.setAttribute("createCommentMessage", id + ", is deleted!");
            return this.createView(model, request, params, authentication);
            
        } else {
            return "error";
        }
        
    }
}
