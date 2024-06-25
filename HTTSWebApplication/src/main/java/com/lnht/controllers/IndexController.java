    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.controllers;

import com.lnht.service.UserService;
import java.security.Principal;
import java.util.Collection;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author minh-nguyen
 */
@Controller
@PropertySource("classpath:configs.properties")
public class IndexController {
    @Autowired
    private Environment env;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String index(Model model, @RequestParam Map<String, Object> params, Authentication authentication, Principal principal) {
//        authentication
//= SecurityContextHolder.getContext().getAuthentication();
//UserDetails currentPrincipalName = (UserDetails) authentication.getDetails();
//    model.addAttribute("role", currentPrincipalName.getAuthorities());

if(authentication != null){
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            model.addAttribute("role", authorities.iterator().next());
            return "index";
        }
        return "login";
        
    }
}
