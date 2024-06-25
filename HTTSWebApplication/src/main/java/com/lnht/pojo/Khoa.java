/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author minh-nguyen
 */
@Entity
@Table(name = "khoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Khoa.findAll", query = "SELECT k FROM Khoa k"),
    @NamedQuery(name = "Khoa.findById", query = "SELECT k FROM Khoa k WHERE k.id = :id"),
    @NamedQuery(name = "Khoa.findByTenkhoa", query = "SELECT k FROM Khoa k WHERE k.tenkhoa = :tenkhoa")})
public class Khoa implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tenkhoa")
    private String tenkhoa;
    @Lob
    @Size(max = 65535)
    @Column(name = "video")
    private String video;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoa")
    private Set<Diemtrungtuyen> diemtrungtuyenSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoa")
    private Set<Nganh> nganhSet;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull(message = "{value.NullMsg}")
    @Column(name = "id")
    private Integer id;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoa1")
//    private Set<Diemtrungtuyen> diemtrungtuyenSet;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoa")
//    private Set<Nganh> nganhSet;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Thongtin thongtin;

    public Khoa() {
    }

    public Khoa(Integer id) {
        this.id = id;
    }

    public Khoa(Integer id, String tenkhoa) {
        this.id = id;
        this.tenkhoa = tenkhoa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


//    @XmlTransient
//    public Set<Diemtrungtuyen> getDiemtrungtuyenSet() {
//        return Collections.unmodifiableSet(diemtrungtuyenSet);
//    }
//
//    public void setDiemtrungtuyenSet(Set<Diemtrungtuyen> diemtrungtuyenSet) {
//        this.diemtrungtuyenSet = diemtrungtuyenSet;
//    }
//
//    @XmlTransient
//    public Set<Nganh> getNganhSet() {
//        return Collections.unmodifiableSet(nganhSet);
//    }
//
//    public void setNganhSet(Set<Nganh> nganhSet) {
//        this.nganhSet = nganhSet;
//    }

    public Thongtin getThongtin() {
        return thongtin;
    }

    public void setThongtin(Thongtin thongtin) {
        this.thongtin = thongtin;
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
        if (!(object instanceof Khoa)) {
            return false;
        }
        Khoa other = (Khoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.Khoa[ id=" + id + " ]";
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @XmlTransient
    public Set<Diemtrungtuyen> getDiemtrungtuyenSet() {
        return diemtrungtuyenSet;
    }

    public void setDiemtrungtuyenSet(Set<Diemtrungtuyen> diemtrungtuyenSet) {
        this.diemtrungtuyenSet = diemtrungtuyenSet;
    }

    @XmlTransient
    public Set<Nganh> getNganhSet() {
        return nganhSet;
    }

    public void setNganhSet(Set<Nganh> nganhSet) {
        this.nganhSet = nganhSet;
    }
    
}
