/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository;

import com.lnht.pojo.Cauhoi;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author minh-nguyen
 */
public interface QuestionRepository {
        public void postOrEdit(Cauhoi t);
    public Cauhoi getById(int id);
    public List<Cauhoi> getAll(Map<String, Object> params);
    public Set<Cauhoi> getAll();
    public void delete(int id);
    public int count();
}
