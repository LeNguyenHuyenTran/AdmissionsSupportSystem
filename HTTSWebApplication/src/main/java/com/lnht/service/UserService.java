/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service;

import com.lnht.pojo.Admin;
import com.lnht.pojo.Nguoituvan;
import com.lnht.pojo.Thisinh;
import com.lnht.pojo.User;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author minh-nguyen
 */
public interface UserService {
    List<User> getUsers(Map<String, Object> params);
        List<User> getUsers();

    void addOrUpdateUser(User user, HttpServletRequest request, Map<String,Object> params);
    int countUser();
    User getUserById(int id);
    Admin getAdminById(int id);
    Nguoituvan getInstructorById(int id);
    Thisinh getStudentById(int id);
    void deleteUser(int id);
}
