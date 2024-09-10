/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service;

import com.lnht.pojo.TinTuyenSinh;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface TinTuyenSinhService {
    List<TinTuyenSinh> getTinTuyenSinh(Map<String, String> params);
    TinTuyenSinh getTinTuyenSinhById(int id);
}
