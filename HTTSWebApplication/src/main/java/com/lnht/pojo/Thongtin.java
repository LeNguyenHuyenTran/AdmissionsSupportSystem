/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author minh-nguyen
 */
@Entity
@Table(name = "thongtin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thongtin.findAll", query = "SELECT t FROM Thongtin t"),
    @NamedQuery(name = "Thongtin.findById", query = "SELECT t FROM Thongtin t WHERE t.id = :id")})
public class Thongtin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "noidung")
    private String noidung;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "thongtin")
    private Tintuyensinh tintuyensinh;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "thongtin")
    private Khoa khoa;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "thongtin")
    private Truong truong;

    public Thongtin() {
    }

    public Thongtin(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Tintuyensinh getTintuyensinh() {
        return tintuyensinh;
    }

    public void setTintuyensinh(Tintuyensinh tintuyensinh) {
        this.tintuyensinh = tintuyensinh;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public Truong getTruong() {
        return truong;
    }

    public void setTruong(Truong truong) {
        this.truong = truong;
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
        if (!(object instanceof Thongtin)) {
            return false;
        }
        Thongtin other = (Thongtin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.Thongtin[ id=" + id + " ]";
    }
    
}
