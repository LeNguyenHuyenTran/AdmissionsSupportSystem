/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

/**
 *
 * @author minh-nguyen
 */
public class AdmissionNewsDTO {
        private Integer id;

    private String loaituyensinhid;
    
        private String tieude;
    private String noidung;

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
     * @return the loaituyensinhid
     */
    public String getLoaituyensinhid() {
        return loaituyensinhid;
    }

    /**
     * @param loaituyensinhid the loaituyensinhid to set
     */
    public void setLoaituyensinhid(String loaituyensinhid) {
        this.loaituyensinhid = loaituyensinhid;
    }

    /**
     * @return the tieude
     */
    public String getTieude() {
        return tieude;
    }

    /**
     * @param tieude the tieude to set
     */
    public void setTieude(String tieude) {
        this.tieude = tieude;
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
    
}
