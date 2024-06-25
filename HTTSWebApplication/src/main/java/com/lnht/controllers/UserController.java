/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.components.JwtService;
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
import com.lnht.validator.UserTempValidator;
import java.security.Principal;
import javax.servlet.jsp.PageContext;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.security.core.userdetails.UserDetails;
import com.lnht.validator.UserTempValidator;
import com.lnht.validator.UserValidator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.validation.ObjectError;

/**
 *
 * @author minh-nguyen
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private UserroleService userRoleService;

    @Autowired
    private Environment env;

        @Autowired
    private JwtService jwtService;
    
    @GetMapping("/user")
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
            } else {
                P = 1;
                params.put("page", "1");
            }
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
            model.addAttribute("userQuantity", Math.ceil(userService.countUser() * 1.0 / page));
                        model.addAttribute("userQ", userService.countUser());

            model.addAttribute("title", "Users");
            model.addAttribute("currentPage", P);
            model.addAttribute("UID", OTPNumber.generateOTP());
            System.out.println(userService.getUsers(params));
            System.out.println(userRoleService.getAll());
            System.out.println(Math.ceil(userService.countUser() * 1.0 / page));
            System.out.println(P);
            String TinyMCEKey = this.env.getProperty("TinyMCE_Key");
            model.addAttribute("TinyMCE_Key", TinyMCEKey);

            return "user";
        } else {
            return "error";
        }

    }

    @PostMapping("/user")
    public String add(HttpSession session, Authentication authentication, Model model, @ModelAttribute(value = "user") @Valid UserDTO user, BindingResult result, HttpServletRequest request, @RequestParam Map<String, Object> params) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            if (result.hasErrors()) {

                String prev = request.getHeader("Referer");
                if (prev.contains(String.valueOf(user.getId())) == true) {
//                    prev = prev.replace(String.valueOf(user.getId()), "");
//                    prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
//                    prev = prev.concat("?current-tab=" + e);
                    UserTempValidator uValidator = new UserTempValidator();
                    for (ObjectError error : result.getAllErrors()) {
                        uValidator.getErrors().add(error.getDefaultMessage());
                    }
                    session.setAttribute("userErrors", uValidator.getErrors());

                    return "redirect:" + prev;
                } else {
                    return this.createView(model, params, authentication);
                }
            } else {
                UserTempValidator uv = new UserTempValidator();

                if (userService.getUser(user.getUsername()) == null
                        || userService.getUser(user.getUsername()).isEmpty()) {
                    Boolean hasErrors = false;
                    Boolean hasUserNameAndPasswordErrors = false;
                    Boolean isEqual = false;
                    if (uv.usernameValidator(user.getUsername()) == false) {
                        hasErrors = true;
                        hasUserNameAndPasswordErrors = true;
                    }
                    if (uv.passwordValidator(user.getPassword()) == false && uv.passwordValidator(user.getConfirmPassword()) == false) {
                        hasErrors = true;
                        hasUserNameAndPasswordErrors = true;
                    }

                    if (user.getPassword().equals(user.getConfirmPassword()) && hasUserNameAndPasswordErrors == false) {
                        isEqual = true;
                    } else {
                        isEqual = false;
                        uv.getErrors().add(uv.getPasswordMatchMsg());
                        hasErrors = true;
                    }

                    if (hasErrors) {
                        session.setAttribute("userErrors", uv.getErrors());
//                        model.addAttribute("user", new UserDTO());
//                        model.addAttribute("UID", OTPNumber.generateOTP());
//                        model.addAttribute("roles", userRoleService.getAll());
                        session.setAttribute("createUserMessage", (String) params.get("id") + " was not created");
                        String prev = request.getHeader("Referer");
                        if (prev.contains(String.valueOf(user.getId())) == true) {
                            //                    prev = prev.replace(String.valueOf(user.getId()), "");
                            //                    prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
                            //                    prev = prev.concat("?current-tab=" + e);

                            return "redirect:" + prev;
                        } else {
                            return this.createView(model, params, authentication);
                        }

                    } else {
                        User w = new User();
                        w.setId(user.getId());
                        w.setHoten(user.getHoten());
                        w.setPassword(user.getPassword());
                        w.setUsername(user.getUsername());
                        this.userService.addOrUpdateUser(w, request, params);
                        session.setAttribute("createUserMessage", (String) params.get("id") + " is created!");
                        session.removeAttribute("userErrors");
                        String prev = request.getHeader("Referer");
                        if (prev.contains(String.valueOf(user.getId())) == true) {
                            prev = prev.replace(String.valueOf(user.getId()), "");
                            prev = prev.replaceAll("user\\/.*", "user\\/");

                            return "redirect:" + prev;
                        } else {
                            return this.createView(model, params, authentication);
                        }
                    }

                } else {
                    String prev = request.getHeader("Referer");
                    if (prev.contains(String.valueOf(user.getId())) == true) {
                        // update in user detail by id
                        Boolean hasErrors = false;
                        Boolean hasUserNameAndPasswordErrors = false;
                        Boolean isEqual = false;
                        if (uv.usernameValidator(user.getUsername()) == false) {
                            hasErrors = true;
                            hasUserNameAndPasswordErrors = true;
                        }
                        if (uv.passwordValidator(user.getPassword()) == false && uv.passwordValidator(user.getConfirmPassword()) == false) {
                            hasErrors = true;
                            hasUserNameAndPasswordErrors = true;
                        }

                        if (user.getPassword().equals(user.getConfirmPassword()) && hasUserNameAndPasswordErrors == false) {
                            isEqual = true;

                        } else {
                            isEqual = false;
                            uv.getErrors().add(uv.getPasswordMatchMsg());
                            hasErrors = true;
                        }

                        if (hasErrors) {
                            session.setAttribute("userErrors", uv.getErrors());
                            session.setAttribute("createUserMessage", (String) params.get("id") + " was not created");
                            if (prev.contains(String.valueOf(user.getId())) == true) {
                                return "redirect:" + prev;
                            } else {
                                return "redirect:" + prev;
                            }

                        } else {
                            User u = new User();
                            u.setId(user.getId());
                            u.setHoten(user.getHoten());
                            u.setUsername(user.getUsername());
                            u.setPassword(user.getPassword());
                            userService.addOrUpdateUser(u, request, params);
                            session.setAttribute("createUserMessage", (String) params.get("id") + " is created!");
                            session.removeAttribute("userErrors");
                            if (prev.contains(String.valueOf(user.getId())) == true) {
                                prev = prev.replace(String.valueOf(user.getId()), "");
                                prev = prev.replaceAll("user\\/.*", "user\\/");

                                return "redirect:" + prev;
                            } else {
                                return "redirect:" + prev;
                            }
                        }

                    } else {
                        // just add
                        uv.getErrors().add(uv.getExistUser());
                        session.setAttribute("userErrors", uv.getErrors());
//                    model.addAttribute("user", new UserDTO());
//                    model.addAttribute("UID", OTPNumber.generateOTP());
//                    model.addAttribute("roles", userRoleService.getAll());
                        session.setAttribute("createUserMessage", (String) params.get("id") + " was not created");

                        if (prev.contains(String.valueOf(user.getId())) == true) {

                            return "redirect:" + prev;
                        } else {
                            return this.createView(model, params, authentication);
                        }
                    }

                }
            }

        } else {
            return "error";
        }
    }

    @GetMapping("/user/{id}")
    public String get(Model model, @PathVariable(value = "id") int id, HttpServletRequest request, @RequestParam Map<String, Object> params, Authentication authentication) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            User user = this.userService.getUserById(id);

            model.addAttribute("user", user);
            model.addAttribute("roles", userRoleService.getAll());
            model.addAttribute("title", "Detail Users");
            model.addAttribute("UID", OTPNumber.generateOTP());

            return "detailUser";
        } else {
            return "error";
        }

    }

    @DeleteMapping("/user/delete/{id}")
    public String delete(Model model, HttpSession session, @RequestParam Map<String, Object> params, @PathVariable(value = "id") int id, Authentication authentication) {
        Authentication auth = authentication;
        if (auth != null && auth.isAuthenticated()) {
            this.userService.deleteUser(id);
            session.setAttribute("createUserMessage", id + ", was deleted!");
            return this.createView(model, params, authentication);
        } else {
            return "error";
        }

    }

    @GetMapping("/login")
    public String login(Authentication authentication, Model model) {
        return "login";
    }

    
    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("UID", OTPNumber.generateOTP());
        model.addAttribute("roles", userRoleService.getAll());

        return "register";
    }

    @PostMapping("/register")
    public String register(HttpSession session, Model model, HttpServletRequest request, @ModelAttribute(value = "user") @Valid UserDTO user, BindingResult result) {
//        UserValidator uV = new UserValidator();
//        if(uV.validate(user)==true){
//            
//        }else{
//            List<String> errors = uV.getErrors();
//            model.addAttribute("errors", errors)
//        }
        String errMsg = "";
        if (result.hasErrors()) {
            model.addAttribute("user", new UserDTO());
            model.addAttribute("UID", OTPNumber.generateOTP());
            model.addAttribute("roles", userRoleService.getAll());
            UserTempValidator uValidator = new UserTempValidator();
            for (ObjectError error : result.getAllErrors()) {
                uValidator.getErrors().add(error.getDefaultMessage());
            }
            session.setAttribute("userErrors", uValidator.getErrors());
            return this.registerView(model);
        } else {
            UserTempValidator uv = new UserTempValidator();

            if (userService.getUser(user.getUsername()) == null
                    || userService.getUser(user.getUsername()).isEmpty()) {
                Boolean hasErrors = false;
                Boolean hasUserNameAndPasswordErrors = false;
                if (uv.usernameValidator(user.getUsername()) == false) {
                    hasErrors = true;
                    hasUserNameAndPasswordErrors = true;
                }
                if (uv.passwordValidator(user.getPassword()) == false && uv.passwordValidator(user.getConfirmPassword()) == false) {
                    hasErrors = true;
                    hasUserNameAndPasswordErrors = true;
                }

                if (user.getPassword().equals(user.getConfirmPassword()) && hasUserNameAndPasswordErrors == false) {
                    // Case valid
                    User u = new User();
                    u.setId(user.getId());
                    u.setHoten(user.getHoten());
                    u.setUsername(user.getUsername());
                    u.setPassword(user.getPassword());
                    u.setConfirmPassword(user.getConfirmPassword());
                    u.setRole(userRoleService.getById(Integer.parseInt(user.getRoleid())));
                    if (this.userDetailsService.addUser(u) == true) {
                        session.removeAttribute("userErrors");

                        return "redirect:/login";
                    } else {
                        uv.getErrors().add("Fail to create" + user.getUsername());
                        session.setAttribute("userErrors", uv.getErrors());
//                        model.addAttribute("user", new UserDTO());
//                        model.addAttribute("UID", OTPNumber.generateOTP());
//                        model.addAttribute("roles", userRoleService.getAll());
                        return this.registerView(model);
                    }
                } else {
                    uv.getErrors().add(uv.getPasswordMatchMsg());
                    hasErrors = true;
                }

                if (hasErrors) {
                    session.setAttribute("userErrors", uv.getErrors());
//                    model.addAttribute("user", new UserDTO());
//                    model.addAttribute("UID", OTPNumber.generateOTP());
//                    model.addAttribute("roles", userRoleService.getAll());

                    String prev = request.getHeader("Referer");

                    if (prev.contains(String.valueOf(user.getId())) == true) {
                        //                    prev = prev.replace(String.valueOf(user.getId()), "");
                        //                    prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
                        //                    prev = prev.concat("?current-tab=" + e);

                        return "redirect:" + prev;
                    } else {
                        return this.registerView(model);
                    }
                }
            } else {
                uv.getErrors().add(uv.getExistUser());
                session.setAttribute("userErrors", uv.getErrors());
//                model.addAttribute("user", new UserDTO());
//                model.addAttribute("UID", OTPNumber.generateOTP());
//                model.addAttribute("roles", userRoleService.getAll());
                String prev = request.getHeader("Referer");

                if (prev.contains(String.valueOf(user.getId())) == true) {
                    //                    prev = prev.replace(String.valueOf(user.getId()), "");
                    //                    prev = prev.replaceAll("faculty\\/.*", "faculty\\/");
                    //                    prev = prev.concat("?current-tab=" + e);

                    return "redirect:" + prev;
                } else {
                    return this.registerView(model);
                }
            }
        }
        return null;

    }
}
