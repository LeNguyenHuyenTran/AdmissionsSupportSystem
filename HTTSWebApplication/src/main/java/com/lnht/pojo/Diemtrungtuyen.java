/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "diemtrungtuyen", catalog = "admission_support_system_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diemtrungtuyen.findAll", query = "SELECT d FROM Diemtrungtuyen d"),
    @NamedQuery(name = "Diemtrungtuyen.findById", query = "SELECT d FROM Diemtrungtuyen d WHERE d.id = :id"),
    @NamedQuery(name = "Diemtrungtuyen.findByDiem", query = "SELECT d FROM Diemtrungtuyen d WHERE d.diem = :diem"),
    @NamedQuery(name = "Diemtrungtuyen.findByNamhoc", query = "SELECT d FROM Diemtrungtuyen d WHERE d.namhoc = :namhoc")})
public class Diemtrungtuyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diem")
    private double diem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "namhoc")
    private int namhoc;
    @JoinColumn(name = "chuongtrinhdaotao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Chuongtrinhdaotao chuongtrinhdaotao;
    @JoinColumn(name = "khoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Khoa khoa;
    @JoinColumn(name = "nganh", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Nganh nganh;

    public Diemtrungtuyen() {
    }

    public Diemtrungtuyen(Integer id) {
        this.id = id;
    }

    public Diemtrungtuyen(Integer id, double diem, int namhoc) {
        this.id = id;
        this.diem = diem;
        this.namhoc = namhoc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public int getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(int namhoc) {
        this.namhoc = namhoc;
    }

    public Chuongtrinhdaotao getChuongtrinhdaotao() {
        return chuongtrinhdaotao;
    }

    public void setChuongtrinhdaotao(Chuongtrinhdaotao chuongtrinhdaotao) {
        this.chuongtrinhdaotao = chuongtrinhdaotao;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diemtrungtuyen)) {
            return false;
        }
        Diemtrungtuyen other = (Diemtrungtuyen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.Diemtrungtuyen[ id=" + id + " ]";
    }
    
}
