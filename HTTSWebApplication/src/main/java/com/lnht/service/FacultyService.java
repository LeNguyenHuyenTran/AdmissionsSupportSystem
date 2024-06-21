/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service;

import com.lnht.pojo.Chuongtrinhdaotao;
import com.lnht.pojo.Khoa;
import com.lnht.pojo.Nganh;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author minh-nguyen
 */
public interface FacultyService {
    Khoa getFacultyById(int id);
    Nganh getMajorById(int id);
    Chuongtrinhdaotao getEducationProgramById(int id);
    void postOrEditFaculty(Khoa f, Map<String,Object> params, HttpServletRequest request);
    void postOrEditMajor(Nganh f, Map<String,Object> params, HttpServletRequest request);
    void postOrEditEducationProgram(Chuongtrinhdaotao f, Map<String,Object> params, HttpServletRequest request);
    void deleteFaculty(int id);
    void deleteMajor(int id);
    void deleteEducationProgram(int id);
    List<Khoa> getAll();
    List<Khoa> getAll(Map<String,String> params);
    List<Nganh> getAllMajor(Map<String,String> params);
    List<Chuongtrinhdaotao> getAllEducationProgram(Map<String,String> params);
    int countFaculty();
    int countMajor();
    int countEducationProgram();
}
