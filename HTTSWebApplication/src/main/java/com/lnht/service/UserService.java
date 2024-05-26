/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service;

import com.lnht.pojo.User;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author minh-nguyen
 */
public interface UserService {
    List<User> getUsers(Map<String, String> params);
    void addOrUpdateUser(User user, HttpServletRequest request);
    int countUser();
    User getUserById(String id);
    void deleteUser(String id);
}
