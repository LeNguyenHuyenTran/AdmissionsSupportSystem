/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository;

import com.lnht.pojo.Binhluan;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author minh-nguyen
 */
public interface CommentRepository {
    public void postOrEdit(Binhluan t);
    public Binhluan getById(int id);
    public List<Binhluan> getAll(Map<String, String> params);
    public Set<Binhluan> getAll();
    public void delete(int id);
    public int count();
}
