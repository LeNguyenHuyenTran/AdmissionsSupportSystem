/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author minh-nguyen
 */
@Embeddable
public class DiemtrungtuyenPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "khoa")
    private int khoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chuongtrinhdaotao")
    private int chuongtrinhdaotao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nganh")
    private int nganh;

    public DiemtrungtuyenPK() {
    }

    public DiemtrungtuyenPK(int khoa, int chuongtrinhdaotao, int nganh) {
        this.khoa = khoa;
        this.chuongtrinhdaotao = chuongtrinhdaotao;
        this.nganh = nganh;
    }

    public int getKhoa() {
        return khoa;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }

    public int getChuongtrinhdaotao() {
        return chuongtrinhdaotao;
    }

    public void setChuongtrinhdaotao(int chuongtrinhdaotao) {
        this.chuongtrinhdaotao = chuongtrinhdaotao;
    }

    public int getNganh() {
        return nganh;
    }

    public void setNganh(int nganh) {
        this.nganh = nganh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) khoa;
        hash += (int) chuongtrinhdaotao;
        hash += (int) nganh;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiemtrungtuyenPK)) {
            return false;
        }
        DiemtrungtuyenPK other = (DiemtrungtuyenPK) object;
        if (this.khoa != other.khoa) {
            return false;
        }
        if (this.chuongtrinhdaotao != other.chuongtrinhdaotao) {
            return false;
        }
        if (this.nganh != other.nganh) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.DiemtrungtuyenPK[ khoa=" + khoa + ", chuongtrinhdaotao=" + chuongtrinhdaotao + ", nganh=" + nganh + " ]";
    }
    
}
