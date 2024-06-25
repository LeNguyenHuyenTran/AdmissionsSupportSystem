/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.service;

import com.lnht.pojo.Chuongtrinhdaotao;
import com.lnht.pojo.Diemtrungtuyen;
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
    void postOrEditAdmissionScore(Diemtrungtuyen d, Map<String, Object> params, HttpServletRequest request);
    void deleteFaculty(int id);
    void deleteMajor(int id);
    void deleteEducationProgram(int id);
    void deleteAdmisisonScore(int id);
    List<Khoa> getAllFaculty();
        List<Nganh> getAllMajor();
    List<Chuongtrinhdaotao> getAllEducationProgram();

    List<Khoa> getAll(Map<String,Object> params);
    List<Nganh> getAllMajor(Map<String,Object> params);
    List<Chuongtrinhdaotao> getAllEducationProgram(Map<String,Object> params);
    int countFaculty();
    int countMajor();
    int countEducationProgram();
    int countAdmissionScore();
    List<Diemtrungtuyen> getAllAdmissionScore(Map<String,Object> params);
    Diemtrungtuyen getAdmissionScoreById(int id);
}
