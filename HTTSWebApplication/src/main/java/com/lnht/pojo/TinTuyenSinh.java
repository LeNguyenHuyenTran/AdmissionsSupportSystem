/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tin_tuyen_sinh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TinTuyenSinh.findAll", query = "SELECT t FROM TinTuyenSinh t"),
    @NamedQuery(name = "TinTuyenSinh.findById", query = "SELECT t FROM TinTuyenSinh t WHERE t.id = :id")})
public class TinTuyenSinh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "tieu_de")
    private String tieuDe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "loai_tuyen_sinh_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private LoaiTuyenSinh loaiTuyenSinhId;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ThongTin thongTin;
    @JsonIgnore
    @OneToMany(mappedBy = "tinTuyenSinhId")
    private Set<BinhLuan> binhLuanSet;

    public TinTuyenSinh() {
    }

    public TinTuyenSinh(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public LoaiTuyenSinh getLoaiTuyenSinhId() {
        return loaiTuyenSinhId;
    }

    public void setLoaiTuyenSinhId(LoaiTuyenSinh loaiTuyenSinhId) {
        this.loaiTuyenSinhId = loaiTuyenSinhId;
    }

    public ThongTin getThongTin() {
        return thongTin;
    }

    public void setThongTin(ThongTin thongTin) {
        this.thongTin = thongTin;
    }

    @XmlTransient
    public Set<BinhLuan> getBinhLuanSet() {
        return binhLuanSet;
    }

    public void setBinhLuanSet(Set<BinhLuan> binhLuanSet) {
        this.binhLuanSet = binhLuanSet;
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
        if (!(object instanceof TinTuyenSinh)) {
            return false;
        }
        TinTuyenSinh other = (TinTuyenSinh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.TinTuyenSinh[ id=" + id + " ]";
    }
    
}
