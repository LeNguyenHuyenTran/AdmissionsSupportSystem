/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author minh-nguyen
 */
public class QuestionDTO {

    private Integer id;
    private String noidung;
    private String userid;
    private String livestreamnotifyid;
    private String videolivestreamid;
    private String thoidiem;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }



    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return the livestreamnotifyid
     */
    public String getLivestreamnotifyid() {
        return livestreamnotifyid;
    }

    /**
     * @param livestreamnotifyid the livestreamnotifyid to set
     */
    public void setLivestreamnotifyid(String livestreamnotifyid) {
        this.livestreamnotifyid = livestreamnotifyid;
    }

    /**
     * @return the videolivestreamid
     */
    public String getVideolivestreamid() {
        return videolivestreamid;
    }

    /**
     * @param videolivestreamid the videolivestreamid to set
     */
    public void setVideolivestreamid(String videolivestreamid) {
        this.videolivestreamid = videolivestreamid;
    }

    /**
     * @return the noidung
     */
    public String getNoidung() {
        return noidung;
    }

    /**
     * @param noidung the noidung to set
     */
    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    /**
     * @return the thoidiem
     */
    public String getThoidiem() {
        return thoidiem;
    }

    /**
     * @param thoidiem the thoidiem to set
     */
    public void setThoidiem(String thoidiem) {
        this.thoidiem = thoidiem;
    }


}
