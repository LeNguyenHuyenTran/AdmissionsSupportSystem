/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import java.io.Serializable;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "thong_tin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThongTin.findAll", query = "SELECT t FROM ThongTin t"),
    @NamedQuery(name = "ThongTin.findById", query = "SELECT t FROM ThongTin t WHERE t.id = :id")})
public class ThongTin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "noi_dung")
    private String noiDung;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "thongTin")
    private TinTuyenSinh tinTuyenSinh;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "thongTin")
    private ThongBaoLivestream thongBaoLivestream;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "thongTin")
    private Khoa khoa;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "thongTin")
    private Truong truong;

    public ThongTin() {
    }

    public ThongTin(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public TinTuyenSinh getTinTuyenSinh() {
        return tinTuyenSinh;
    }

    public void setTinTuyenSinh(TinTuyenSinh tinTuyenSinh) {
        this.tinTuyenSinh = tinTuyenSinh;
    }

    public ThongBaoLivestream getThongBaoLivestream() {
        return thongBaoLivestream;
    }

    public void setThongBaoLivestream(ThongBaoLivestream thongBaoLivestream) {
        this.thongBaoLivestream = thongBaoLivestream;
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
        if (!(object instanceof ThongTin)) {
            return false;
        }
        ThongTin other = (ThongTin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.ThongTin[ id=" + id + " ]";
    }

    /**
     * @return the khoa
     */
    public Khoa getKhoa() {
        return khoa;
    }

    /**
     * @param khoa the khoa to set
     */
    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }
    
}
