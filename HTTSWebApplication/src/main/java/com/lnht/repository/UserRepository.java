/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lnht.repository;

import com.lnht.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author minh-nguyen
 */
public interface UserRepository {
    List<User> getUsers(Map<String, String> params);
    void addOrUpdateUser(User user);
    int countUser();
    User getUserById(int id);
    void deleteUser(int id);
}
