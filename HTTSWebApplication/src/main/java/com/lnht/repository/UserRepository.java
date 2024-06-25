/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lnht.repository;

import com.lnht.pojo.Admin;
import com.lnht.pojo.Nguoituvan;
import com.lnht.pojo.Thisinh;
import com.lnht.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author minh-nguyen
 */
public interface UserRepository {
    List<User> getUsers(Map<String, Object> params);
    List<User> getUsers();

    List<User> getUsersByRole(String roleType);
    void addOrUpdateUser(User user);
    void addOrUpdateStudent(Thisinh student);
    void addOrUpdateInstructor(Nguoituvan instructor);
    void addOrUpdateAdmin(Admin admin);
    int countUser();
    User getUserById(int id);
    Admin getAdminById(int id);
    Nguoituvan getInstructorById(int id);
    Thisinh getStudentById(int id);
    void deleteUser(int id);
    boolean addUser(User user);
    List<User> getUser(String username);
    User getUserByUsername(String username);
}
