/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository;

import com.lnht.pojo.Khoa;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface KhoaRepository {
    List<Khoa> getKhoa(Map<String, String> params);
    void addOrUpdateKhoa(Khoa khoa);
    void deleteKhoa(int id);
    Khoa getKhoaById(int id);
}
