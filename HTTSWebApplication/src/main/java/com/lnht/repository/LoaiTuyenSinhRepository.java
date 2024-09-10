/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository;

import com.lnht.pojo.LoaiTuyenSinh;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface LoaiTuyenSinhRepository {
    List<LoaiTuyenSinh> getLoaiTuyenSinhs();
    LoaiTuyenSinh getLoaiTuyenSinhById(int id);
}
