/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service;

import com.lnht.pojo.ThongBaoLivestream;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ThongBaoLivestreamService {
    List<ThongBaoLivestream> getThongBaoLivestreams();
    ThongBaoLivestream getThongBaoLivestreamById(int id);
}
