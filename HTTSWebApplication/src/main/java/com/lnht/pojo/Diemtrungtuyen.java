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
 * @author minh-nguyen
 */
@Entity
@Table(name = "diemtrungtuyen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diemtrungtuyen.findAll", query = "SELECT d FROM Diemtrungtuyen d"),
    @NamedQuery(name = "Diemtrungtuyen.findByKhoa", query = "SELECT d FROM Diemtrungtuyen d WHERE d.diemtrungtuyenPK.khoa = :khoa"),
    @NamedQuery(name = "Diemtrungtuyen.findByChuongtrinhdaotao", query = "SELECT d FROM Diemtrungtuyen d WHERE d.diemtrungtuyenPK.chuongtrinhdaotao = :chuongtrinhdaotao"),
    @NamedQuery(name = "Diemtrungtuyen.findByNganh", query = "SELECT d FROM Diemtrungtuyen d WHERE d.diemtrungtuyenPK.nganh = :nganh"),
    @NamedQuery(name = "Diemtrungtuyen.findByNamhoc", query = "SELECT d FROM Diemtrungtuyen d WHERE d.namhoc = :namhoc"),
    @NamedQuery(name = "Diemtrungtuyen.findByDiem", query = "SELECT d FROM Diemtrungtuyen d WHERE d.diem = :diem")})
public class Diemtrungtuyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiemtrungtuyenPK diemtrungtuyenPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "namhoc")
    private int namhoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diem")
    private double diem;
    @JoinColumn(name = "chuongtrinhdaotao", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Chuongtrinhdaotao chuongtrinhdaotao1;
    @JoinColumn(name = "khoa", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Khoa khoa1;
    @JoinColumn(name = "nganh", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nganh nganh1;

    public Diemtrungtuyen() {
    }

    public Diemtrungtuyen(DiemtrungtuyenPK diemtrungtuyenPK) {
        this.diemtrungtuyenPK = diemtrungtuyenPK;
    }

    public Diemtrungtuyen(DiemtrungtuyenPK diemtrungtuyenPK, int namhoc, double diem) {
        this.diemtrungtuyenPK = diemtrungtuyenPK;
        this.namhoc = namhoc;
        this.diem = diem;
    }

    public Diemtrungtuyen(int khoa, int chuongtrinhdaotao, int nganh) {
        this.diemtrungtuyenPK = new DiemtrungtuyenPK(khoa, chuongtrinhdaotao, nganh);
    }

    public DiemtrungtuyenPK getDiemtrungtuyenPK() {
        return diemtrungtuyenPK;
    }

    public void setDiemtrungtuyenPK(DiemtrungtuyenPK diemtrungtuyenPK) {
        this.diemtrungtuyenPK = diemtrungtuyenPK;
    }

    public int getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(int namhoc) {
        this.namhoc = namhoc;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public Chuongtrinhdaotao getChuongtrinhdaotao1() {
        return chuongtrinhdaotao1;
    }

    public void setChuongtrinhdaotao1(Chuongtrinhdaotao chuongtrinhdaotao1) {
        this.chuongtrinhdaotao1 = chuongtrinhdaotao1;
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
        hash += (diemtrungtuyenPK != null ? diemtrungtuyenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diemtrungtuyen)) {
            return false;
        }
        Diemtrungtuyen other = (Diemtrungtuyen) object;
        if ((this.diemtrungtuyenPK == null && other.diemtrungtuyenPK != null) || (this.diemtrungtuyenPK != null && !this.diemtrungtuyenPK.equals(other.diemtrungtuyenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.Diemtrungtuyen[ diemtrungtuyenPK=" + diemtrungtuyenPK + " ]";
    }
    
}
