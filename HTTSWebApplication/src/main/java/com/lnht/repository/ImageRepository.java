/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository;

import com.lnht.pojo.Anh;
import com.lnht.pojo.Banner;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author minh-nguyen
 */
public interface ImageRepository {
    public void postOrEdit(Anh t);
    public void postOrEdit(Banner t);
    public List<Object> getAll(Map<String, Object> params);
    public Set<Anh> getAllImageWithSetType();
    public Set<Banner> getAllBannerWithSetType();
    public Anh getImageById(int id);
    public Banner getBannerById(int id);
    public void delete(int id, String type);
    public int count(String type);
}
