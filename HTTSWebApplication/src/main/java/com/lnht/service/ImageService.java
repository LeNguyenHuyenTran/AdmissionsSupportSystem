/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service;

import com.lnht.pojo.Anh;
import com.lnht.pojo.Banner;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author minh-nguyen
 */
public interface ImageService {
    List<Object> getAll(Map<String, Object> params);
    void addOrUpdate(Anh b, HttpServletRequest request,Map<String,Object> params);
    void addOrUpdate(Banner b, HttpServletRequest request,Map<String,Object> params);
    void add(Object o, Map<String,Object> params,HttpServletRequest request);
    public Anh getImageById(int id);
    public Banner getBannerById(int id);
    public void delete(int id, String type);
    public int count(String type);
}
