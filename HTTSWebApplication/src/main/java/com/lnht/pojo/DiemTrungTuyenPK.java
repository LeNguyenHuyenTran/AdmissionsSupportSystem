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
 * @author Admin
 */
@Embeddable
public class DiemTrungTuyenPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "khoa")
    private int khoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chuong_trinh_dao_tao")
    private int chuongTrinhDaoTao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nganh")
    private int nganh;

    public DiemTrungTuyenPK() {
    }

    public DiemTrungTuyenPK(int khoa, int chuongTrinhDaoTao, int nganh) {
        this.khoa = khoa;
        this.chuongTrinhDaoTao = chuongTrinhDaoTao;
        this.nganh = nganh;
    }

    public int getKhoa() {
        return khoa;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }

    public int getChuongTrinhDaoTao() {
        return chuongTrinhDaoTao;
    }

    public void setChuongTrinhDaoTao(int chuongTrinhDaoTao) {
        this.chuongTrinhDaoTao = chuongTrinhDaoTao;
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
        hash += (int) chuongTrinhDaoTao;
        hash += (int) nganh;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiemTrungTuyenPK)) {
            return false;
        }
        DiemTrungTuyenPK other = (DiemTrungTuyenPK) object;
        if (this.khoa != other.khoa) {
            return false;
        }
        if (this.chuongTrinhDaoTao != other.chuongTrinhDaoTao) {
            return false;
        }
        if (this.nganh != other.nganh) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.DiemTrungTuyenPK[ khoa=" + khoa + ", chuongTrinhDaoTao=" + chuongTrinhDaoTao + ", nganh=" + nganh + " ]";
    }
    
}
