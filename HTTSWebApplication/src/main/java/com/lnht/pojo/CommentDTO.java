/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author minh-nguyen
 */
public class CommentDTO {
    private String id;
    private String userid;
    private String admissionnewsid;
    private String binhluan;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
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
     * @return the admissionnewsid
     */
    public String getAdmissionnewsid() {
        return admissionnewsid;
    }

    /**
     * @param admissionnewsid the admissionnewsid to set
     */
    public void setAdmissionnewsid(String admissionnewsid) {
        this.admissionnewsid = admissionnewsid;
    }

    /**
     * @return the binhluan
     */
    public String getBinhluan() {
        return binhluan;
    }

    /**
     * @param binhluan the binhluan to set
     */
    public void setBinhluan(String binhluan) {
        this.binhluan = binhluan;
    }
    
}
