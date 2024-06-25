/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.pojo.Anh;
import com.lnht.pojo.Banner;
import com.lnht.pojo.BannerDTO;
import com.lnht.pojo.ImageDTO;
import com.lnht.service.ImageService;
import com.lnht.service.UserService;
import com.lnht.utils.OTPNumber;
import com.lnht.validator.BannerValidator;
import com.lnht.validator.ImageValidator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
            String p = (String) params.get("page");
            int P = 1;
            if (p != null) {
                P = Integer.parseInt(p);
            }else{
                P=1;
                params.put("page", "1");
            }
            int page = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

            String type = (String) params.get("image");
            if (type == null || type.isEmpty() == true) {
                type = "image";
            }
            params.put("image", type);
            model.addAttribute("imageType", type);

            if (type.equals("image")) {
                List<Object> i = imageService.getAll(params);
                List<Anh> images;
                images = i.stream()
                        .map(element -> (Anh) element)
                        .collect(Collectors.toList());
                model.addAttribute("images", images);

            } else if (type.equals("banner")) {
                List<Object> i = imageService.getAll(params);
                List<Banner> banners;
                banners = i.stream()
                        .map(element -> (Banner) element)
                        .collect(Collectors.toList());
                model.addAttribute("images", banners);
            }

//        model.addAttribute("images", imageService.getAll(params));
            model.addAttribute("users", userService.getUsers());
            model.addAttribute("UID", OTPNumber.generateOTP());

            model.addAttribute("imageQuantity", Math.ceil(imageService.count(type) * 1.0 / page));
                        model.addAttribute("imageQ", imageService.count(type));

            model.addAttribute("title", "Images");
            model.addAttribute("currentPage", P);
            System.out.println(imageService.getAll(params));
            System.out.println(userService.getUsers());
            System.out.println(OTPNumber.generateOTP());
            System.out.println(Math.ceil(imageService.count(type) * 1.0 / page));

            return "image";
        } else {
            return "error";
        }

    }

    @PostMapping("/images/image")
    public String add(HttpSession session, Model model, Authentication authentication, @ModelAttribute("image") Anh o, @RequestParam Map<String, Object> params, HttpServletRequest request, BindingResult result) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {

            ImageDTO iDTO = new ImageDTO();
            iDTO.setId(Integer.parseInt((String) params.get("id")));
            iDTO.setFile(o.getFile());
            iDTO.setNguoidangid((String) params.get("userid"));

            ImageValidator iValidator = new ImageValidator();
            if (iValidator.validator(iDTO) == false) {
                session.setAttribute("createImageMessage", (String) params.get("id") + ", was not created!");
                session.setAttribute("imageErrors", iValidator.getErrors());
                params.put("image", "image");
                String prev = request.getHeader("Referer");

                if (prev.contains(String.valueOf(iDTO.getId())) == true) {
//                    prev = prev.replace(aScore.getId(), "");
//                    prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
//                    prev = prev.concat("?current-tab=" + e);
                    return "redirect:" + prev;
                } else {
                    return "redirect:" + prev;
                }
                
            } else {
                this.imageService.add(o, params, request);
                session.setAttribute("createImageMessage", (String) params.get("id") + " is created!");
                params.put("image", "image");
                String prev = request.getHeader("Referer");
                if (prev.contains(String.valueOf(iDTO.getId()))==true ) {
                    prev = prev.replace(String.valueOf(iDTO.getId()), "");
                    prev = prev.replaceAll("images\\/.*", "images\\/");

                    return "redirect:" + prev;
                } else {
                    return "redirect:" + prev;
                }
            }
        } else {
            return "error";
        }

    }

    @PostMapping("/images/banner")
    public String addd(HttpSession session, Model model, Authentication authentication, @ModelAttribute("banner") Banner o, @RequestParam Map<String, Object> params, HttpServletRequest request, BindingResult result) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            BannerDTO bDTO = new BannerDTO();

            bDTO.setFile(o.getFile());
            bDTO.setId(Integer.parseInt((String) params.get("id")));
            bDTO.setUserid((String) params.get("userid"));
            BannerValidator bValidator = new BannerValidator();
            if (bValidator.validator(bDTO) == false) {
                session.setAttribute("createBannerMessage", (String) params.get("id") + ", was not created!");
                session.setAttribute("bannerErrors", bValidator.getErrors());
                params.put("image", "banner");
                 String prev = request.getHeader("Referer");
                if (prev.contains(String.valueOf(bDTO.getId()))==true ) {
//                    prev = prev.replace(String.valueOf(bDTO.getId()), "");
//                    prev = prev.replaceAll("images\\/.*", "images\\/");

                    return "redirect:" + prev;
                } else {
                    return "redirect:" + prev;
                }
            } else {
                this.imageService.add(o, params, request);
                session.setAttribute("createBannerMessage", (String) params.get("id") + " is created!");
                params.put("image", "banner");
                String prev = request.getHeader("Referer");
                if (prev.contains(String.valueOf(bDTO.getId()))==true ) {
                    prev = prev.replace(String.valueOf(bDTO.getId()), "");
                    prev = prev.replaceAll("images\\/.*", "images\\/");

                    return "redirect:" + prev;
                } else {
                    return "redirect:" + prev;
                }
            }
        } else {
            return "error";
        }
    }

    @GetMapping("/images/{id}-{type}")
    public String get(Authentication authentication, Model model, @PathVariable(value = "id") int id, @PathVariable(value = "type") String type, @RequestParam Map<String, Object> params, HttpServletRequest request) {
//        Banner b = this.imageService.getById(id);
//        HttpSession session = request.getSession();
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            if (type.equals("image")) {
                model.addAttribute("image", imageService.getImageById(id));
                model.addAttribute("banner", null);
                System.out.println(imageService.getImageById(id));
                model.addAttribute("UID", OTPNumber.generateOTP());
                System.out.println(OTPNumber.generateOTP());
                model.addAttribute("title", "Detail Image");
                model.addAttribute("users", userService.getUsers());

                return "detailImage";

            } else if (type.equals("banner")) {
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
        } else {
            return "error";
        }

    }

    @DeleteMapping("/images/delete/{id}-{type}")
    public String delete(Model model, HttpSession session,@PathVariable(value = "id") int id, @PathVariable(value = "type") String type, @RequestParam Map<String, Object> params, Authentication authentication) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            this.imageService.delete(id, type);
            session.setAttribute("createImageMessage", id + " with " + type + " was deleted!");
            return this.createView(model, params, authentication);
        } else {
            return "error";
        }
    }
}
