/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.Binhluan;
import com.lnht.pojo.Cauhoi;
import com.lnht.pojo.QuestionDTO;
import com.lnht.service.AdmissionNewsService;
import com.lnht.service.CommentService;
import com.lnht.service.LivestreamNotifyService;
import com.lnht.service.QuestionService;
import com.lnht.service.UserService;
import com.lnht.service.VideoLivestreamNotifyService;
import com.lnht.utils.OTPNumber;
import com.lnht.validator.QuestionValidator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author minh-nguyen
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @Autowired
    private VideoLivestreamNotifyService videoLivestreamNotifyService;

    @Autowired
    private LivestreamNotifyService livestreamNotifyService;

    @Autowired
    private Environment env;

    @GetMapping("/questions")
    public String createView(Model model, HttpServletRequest request, @RequestParam Map<String, Object> params, Authentication authentication) {
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
            String p = (String) params.get("page");
            int P = 1;
            if (p != null) {
                P = Integer.parseInt(p);
            }else{
                P=1;
                params.put("page", "1");
            }
            model.addAttribute("question", new QuestionDTO());
            model.addAttribute("questions", questionService.getAll(params));
            model.addAttribute("questionQuantity", Math.ceil(questionService.count() * 1.0 / pageSize));
                        model.addAttribute("questionQ", questionService.count());

            model.addAttribute("title", "Questions");
            model.addAttribute("users", userService.getUsers());
            model.addAttribute("livestreamNotifies", livestreamNotifyService.getAll());
            model.addAttribute("videoLivestream", videoLivestreamNotifyService.getAll());
            System.out.println(questionService.getAll(params));
            System.out.println(Math.ceil(questionService.count() * 1.0 / pageSize));
            System.out.println(userService.getUsers());
            System.out.println(livestreamNotifyService.getAll());
            System.out.println(videoLivestreamNotifyService.getAll());

            model.addAttribute("UID", OTPNumber.generateOTP());

            model.addAttribute("currentPage", P);
            return "question";
        } else {
            return "error";
        }

    }

    @PostMapping("/question")
    public String add(QuestionDTO q,HttpSession session,
            @RequestParam Map<String, Object> params, Model model, HttpServletRequest request, Authentication authentication) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            
            q.setId(Integer.parseInt((String) params.get("id")));
            q.setLivestreamnotifyid((String) params.get("livestreamnotifyid"));
            q.setNoidung((String) params.get("noidung"));
            q.setThoidiem((String) params.get("thoidiem"));
            q.setUserid((String) params.get("userid"));
            q.setVideolivestreamid((String) params.get("videolivestreamid"));
            
            QuestionValidator qValidator = new QuestionValidator();
            if(qValidator.validate(q)==false){
                session.setAttribute("createQuestionMessage", (String)params.get("id")+", was not created!");
                session.setAttribute("questionErrors", qValidator.getErrors());
                String prev = request.getHeader("Referer");
                if (prev.contains(String.valueOf(q.getId())) == true) {
//                    prev = prev.replace(aScore.getId(), "");
//                    prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
//                    prev = prev.concat("?current-tab=" + e);
                    return "redirect:" + prev;
                } else {
                    return "redirect:" + prev;
                }
                
            }else{
                Cauhoi w = new Cauhoi();
                w.setId(q.getId());

                this.questionService.add(w, params);
                session.setAttribute("createQuestionMessage", String.valueOf(params.get("id"))+" is created!");
                String prev = request.getHeader("Referer");
                    if (prev.contains(String.valueOf(q.getId()))==true ) {
                        prev = prev.replace(String.valueOf(q.getId()), "");
                        prev = prev.replaceAll("questions\\/.*", "questions\\/");

                        return "redirect:" + prev;
                    } else {
                        return "redirect:" + prev;
                    }
                
            }
        } else {
            return "error";
        }

    }

    @GetMapping("/questions/{id}")
    public String get(Authentication authentication,Model model, @PathVariable(value = "id") int id) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            Cauhoi t = this.questionService.getById(id);

            model.addAttribute("question", t);
            model.addAttribute("users", userService.getUsers());
            model.addAttribute("livestreamNotifies", livestreamNotifyService.getAll());
            model.addAttribute("videoLivestream", videoLivestreamNotifyService.getAll());
            model.addAttribute("title", "Detail Question");
            model.addAttribute("UID", OTPNumber.generateOTP());

            return "detailQuestion";
        } else {
            return "error";
        }

    }

    @DeleteMapping("/questions/delete/{id}")
    public String delete(Model model,HttpSession session, HttpServletRequest request, @RequestParam Map<String, Object> params, @PathVariable(value = "id") int id, Authentication authentication) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            this.questionService.delete(id);
             session.setAttribute("createQuestionMessage", id+", was deleted!");
            return this.createView(model, request, params, authentication);
        } else {
            return "error";
        }
    }
}
