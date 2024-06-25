/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository;

import com.lnht.pojo.Tintuyensinh;
import java.util.List;
import java.util.Map;

/**
 *
 * @author minh-nguyen
 */
public interface AdmissionNewsRepository {
    public void postOrEdit(Tintuyensinh t);
    public Tintuyensinh getById(int id);
    public List<Tintuyensinh> getAll(Map<String, Object> params, String type);
    public List<Tintuyensinh> getAll();
    public void delete(int id);
    public int count();
}
