/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository;

import com.lnht.pojo.Loaituyensinh;
import java.util.List;

/**
 *
 * @author minh-nguyen
 */
public interface TypeOfAdmissionRepository {
    List<Loaituyensinh> getAll();
    Loaituyensinh getById(int id);
}
