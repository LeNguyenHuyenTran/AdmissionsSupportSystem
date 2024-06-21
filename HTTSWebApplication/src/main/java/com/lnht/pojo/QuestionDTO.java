/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author minh-nguyen
 */
public class QuestionDTO {

    @NotBlank(message = "{value.NullMsg}")
    private Integer id;
    @NotBlank(message = "{value.NullMsg}")
    private String hoten;
//    @NotNull(message = "{value.NullMsg}")
//    private String userid;
//    @NotNull(message = "{value.NullMsg}")
//    private String livestreamnotifyid;
//    @NotNull(message = "{value.NullMsg}")
//    private String videolivestreamid;
    @NotBlank(message = "{value.NullMsg}")
    private String thoidiemdate;

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
     * @return the noidung
     */
//
//
//    /**
//     * @return the userid
//     */
//    public String getUserid() {
//        return userid;
//    }
//
//    /**
//     * @param userid the userid to set
//     */
//    public void setUserid(String userid) {
//        this.userid = userid;
//    }
//
//    /**
//     * @return the livestreamnotifyid
//     */
//    public String getLivestreamnotifyid() {
//        return livestreamnotifyid;
//    }
//
//    /**
//     * @param livestreamnotifyid the livestreamnotifyid to set
//     */
//    public void setLivestreamnotifyid(String livestreamnotifyid) {
//        this.livestreamnotifyid = livestreamnotifyid;
//    }
//
//    /**
//     * @return the videolivestreamid
//     */
//    public String getVideolivestreamid() {
//        return videolivestreamid;
//    }
//
//    /**
//     * @param videolivestreamid the videolivestreamid to set
//     */
//    public void setVideolivestreamid(String videolivestreamid) {
//        this.videolivestreamid = videolivestreamid;
//    }
    /**
     * @return the thoidiemdate
     */
    public String getThoidiemdate() {
        return thoidiemdate;
    }

    /**
     * @param thoidiemdate the thoidiemdate to set
     */
    public void setThoidiemdate(String thoidiemdate) {
        this.thoidiemdate = thoidiemdate;
    }

    /**
     * @return the hoten
     */
    public String getHoten() {
        return hoten;
    }

    /**
     * @param hoten the hoten to set
     */
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    /**
     * @return the content
     */


}
