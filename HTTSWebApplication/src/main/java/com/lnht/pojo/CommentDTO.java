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
    @NotNull(message = "{value.NullMsg")
    private Integer id;
    @Size(min=5,max=40,message = "{value.SizeMsg}")
    private String userid;
    @Size(min=5,max=40,message = "{value.SizeMsg}")
    private String admissionnewsid;
    @Size(min=5,max=40,message = "{value.SizeMsg}")
    private String binhluan;

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
