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
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
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
    public String createView(Model model, HttpServletRequest request, @RequestParam Map<String, Object> params) {
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        String p = (String) params.get("page");
        int P = 1;
        if (p != null) {
            P = Integer.parseInt(p);
        }

        model.addAttribute("questions", questionService.getAll(params));
        model.addAttribute("questionQuantity", Math.ceil(questionService.count() * 1.0 / pageSize));
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
    }

    @PostMapping("/question")
    public String add(Model model, @ModelAttribute(value = "question") @Valid QuestionDTO q, 
            BindingResult result, HttpServletRequest request, @RequestParam Map<String,Object> params) {
        if (result.hasErrors()) {
            result.getFieldValue("hoten");
//            return this.createView(model, request, params);
        }
//        this.questionService.add(q, params);

        return "redirect:/questions";
    }

    @GetMapping("/questions/{id}")
    public String get(Model model, @PathVariable(value = "id") int id) {
        Cauhoi t = this.questionService.getById(id);

        model.addAttribute("question", t);
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("livestreamNotifies", livestreamNotifyService.getAll());
        model.addAttribute("videoLivestream", videoLivestreamNotifyService.getAll());
        model.addAttribute("title", "Detail Question");
        model.addAttribute("UID", OTPNumber.generateOTP());

        return "detailQuestion";
    }

    @DeleteMapping("/questions/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        this.questionService.delete(id);
        return "redirect:/questions";
    }
}
