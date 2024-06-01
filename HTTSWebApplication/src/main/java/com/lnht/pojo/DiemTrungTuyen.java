/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "diem_trung_tuyen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiemTrungTuyen.findAll", query = "SELECT d FROM DiemTrungTuyen d"),
    @NamedQuery(name = "DiemTrungTuyen.findByKhoa", query = "SELECT d FROM DiemTrungTuyen d WHERE d.diemTrungTuyenPK.khoa = :khoa"),
    @NamedQuery(name = "DiemTrungTuyen.findByChuongTrinhDaoTao", query = "SELECT d FROM DiemTrungTuyen d WHERE d.diemTrungTuyenPK.chuongTrinhDaoTao = :chuongTrinhDaoTao"),
    @NamedQuery(name = "DiemTrungTuyen.findByNganh", query = "SELECT d FROM DiemTrungTuyen d WHERE d.diemTrungTuyenPK.nganh = :nganh"),
    @NamedQuery(name = "DiemTrungTuyen.findByNamHoc", query = "SELECT d FROM DiemTrungTuyen d WHERE d.namHoc = :namHoc"),
    @NamedQuery(name = "DiemTrungTuyen.findByDiem", query = "SELECT d FROM DiemTrungTuyen d WHERE d.diem = :diem")})
public class DiemTrungTuyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiemTrungTuyenPK diemTrungTuyenPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nam_hoc")
    private int namHoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diem")
    private double diem;
    @JoinColumn(name = "chuong_trinh_dao_tao", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ChuongTrinhDaoTao chuongTrinhDaoTao1;
    @JoinColumn(name = "khoa", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Khoa khoa1;
    @JoinColumn(name = "nganh", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nganh nganh1;

    public DiemTrungTuyen() {
    }

    public DiemTrungTuyen(DiemTrungTuyenPK diemTrungTuyenPK) {
        this.diemTrungTuyenPK = diemTrungTuyenPK;
    }

    public DiemTrungTuyen(DiemTrungTuyenPK diemTrungTuyenPK, int namHoc, double diem) {
        this.diemTrungTuyenPK = diemTrungTuyenPK;
        this.namHoc = namHoc;
        this.diem = diem;
    }

    public DiemTrungTuyen(int khoa, int chuongTrinhDaoTao, int nganh) {
        this.diemTrungTuyenPK = new DiemTrungTuyenPK(khoa, chuongTrinhDaoTao, nganh);
    }

    public DiemTrungTuyenPK getDiemTrungTuyenPK() {
        return diemTrungTuyenPK;
    }

    public void setDiemTrungTuyenPK(DiemTrungTuyenPK diemTrungTuyenPK) {
        this.diemTrungTuyenPK = diemTrungTuyenPK;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public ChuongTrinhDaoTao getChuongTrinhDaoTao1() {
        return chuongTrinhDaoTao1;
    }

    public void setChuongTrinhDaoTao1(ChuongTrinhDaoTao chuongTrinhDaoTao1) {
        this.chuongTrinhDaoTao1 = chuongTrinhDaoTao1;
    }

    public Khoa getKhoa1() {
        return khoa1;
    }

    public void setKhoa1(Khoa khoa1) {
        this.khoa1 = khoa1;
    }

    public Nganh getNganh1() {
        return nganh1;
    }

    public void setNganh1(Nganh nganh1) {
        this.nganh1 = nganh1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diemTrungTuyenPK != null ? diemTrungTuyenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiemTrungTuyen)) {
            return false;
        }
        DiemTrungTuyen other = (DiemTrungTuyen) object;
        if ((this.diemTrungTuyenPK == null && other.diemTrungTuyenPK != null) || (this.diemTrungTuyenPK != null && !this.diemTrungTuyenPK.equals(other.diemTrungTuyenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.DiemTrungTuyen[ diemTrungTuyenPK=" + diemTrungTuyenPK + " ]";
    }
    
}
