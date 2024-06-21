/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.repository;

import com.lnht.pojo.Videolivestream;
import java.util.List;
import java.util.Set;

/**
 *
 * @author minh-nguyen
 */
public interface VideoLivestreamRepository {
    List<Videolivestream> getAll();
    Set<Videolivestream> getAllWithSetType();
    Videolivestream getById(int id);
}
