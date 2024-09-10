/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service;

import com.lnht.pojo.User;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author minh-nguyen
 */
public interface UserService extends UserDetailsService {
    List<User> getUsers(Map<String, String> params);
    User getUser(String username);
    void addOrUpdateUser(User user, HttpServletRequest request);
    boolean addUser(User user);
    int countUser();
    User getUserById(int id);
    void deleteUser(int id);
    boolean authUser(String username, String password);
}
