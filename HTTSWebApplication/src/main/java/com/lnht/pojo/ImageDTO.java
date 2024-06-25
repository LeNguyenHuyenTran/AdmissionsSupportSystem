/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author minh-nguyen
 */
public class ImageDTO {
    private String anh;
    private Integer id;
    private String nguoidangid;
    private MultipartFile file;

    /**
     * @return the anh
     */
    public String getAnh() {
        return anh;
    }

    /**
     * @param anh the anh to set
     */
    public void setAnh(String anh) {
        this.anh = anh;
    }

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
     * @return the nguoidangid
     */
    public String getNguoidangid() {
        return nguoidangid;
    }

    /**
     * @param nguoidangid the nguoidangid to set
     */
    public void setNguoidangid(String nguoidangid) {
        this.nguoidangid = nguoidangid;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
