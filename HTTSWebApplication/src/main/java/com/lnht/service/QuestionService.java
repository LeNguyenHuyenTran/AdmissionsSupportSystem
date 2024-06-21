/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service;

import com.lnht.pojo.Cauhoi;
import java.util.List;
import java.util.Map;

/**
 *
 * @author minh-nguyen
 */
public interface QuestionService {
        public void postOrEdit(Cauhoi t);
    public Cauhoi getById(int id);
    public List<Cauhoi> getAll(Map<String, Object> params);
    public void delete(int id);
    public int count();
    public void add(Cauhoi e, Map<String,Object> params);
}
