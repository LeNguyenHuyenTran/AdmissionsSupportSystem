/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository;

import com.lnht.pojo.Thongbaolivestream;
import java.util.List;
import java.util.Set;

/**
 *
 * @author minh-nguyen
 */
public interface LivestreamNotifyRepository {
    List<Thongbaolivestream> getAll();
    Set<Thongbaolivestream> getAllWithSetType();
    Thongbaolivestream getById(int id);
}
