/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service;

import com.lnht.pojo.Thongbaolivestream;
import java.util.List;

/**
 *
 * @author minh-nguyen
 */
public interface LivestreamNotifyService {
    List<Thongbaolivestream> getAll();
    Thongbaolivestream getById(int id);
}
