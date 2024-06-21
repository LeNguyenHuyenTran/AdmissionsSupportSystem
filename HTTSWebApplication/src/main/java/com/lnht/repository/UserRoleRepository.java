/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository;

import com.lnht.pojo.Userrole;
import java.util.List;

/**
 *
 * @author minh-nguyen
 */
public interface UserRoleRepository {
    List<Userrole> getAll();
    Userrole getById(int id);
}
