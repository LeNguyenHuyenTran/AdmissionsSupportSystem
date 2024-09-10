/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service;

import com.lnht.pojo.BinhLuan;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface BinhLuanService {
    List<BinhLuan> getBinhLuan(int newId);
    BinhLuan addBinhLuan(BinhLuan c);
}
