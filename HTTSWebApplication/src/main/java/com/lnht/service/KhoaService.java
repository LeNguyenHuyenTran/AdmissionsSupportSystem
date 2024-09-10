/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service;

import com.lnht.pojo.Khoa;
import com.lnht.repository.UserRepository;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Admin
 */
public interface KhoaService {
    List<Khoa> getKhoa(Map<String, String> params);
    void addOrUpdateKhoa(Khoa khoa, HttpServletRequest request);
    void deleteKhoa(int id);
    Khoa getKhoaById(int id);
}
