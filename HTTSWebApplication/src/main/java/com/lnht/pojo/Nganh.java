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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "nganh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nganh.findAll", query = "SELECT n FROM Nganh n"),
    @NamedQuery(name = "Nganh.findById", query = "SELECT n FROM Nganh n WHERE n.id = :id"),
    @NamedQuery(name = "Nganh.findByTen", query = "SELECT n FROM Nganh n WHERE n.ten = :ten")})
public class Nganh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "ten")
    private String ten;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nganh1")
    private Set<Diemtrungtuyen> diemtrungtuyenSet;
    @JoinColumns({
        @JoinColumn(name = "khoa", referencedColumnName = "id"),
        @JoinColumn(name = "khoa", referencedColumnName = "id")})
    @ManyToOne(optional = false)
    private Khoa khoa;

    public Nganh() {
    }

    public Nganh(Integer id) {
        this.id = id;
    }

    public Nganh(Integer id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @XmlTransient
    public Set<Diemtrungtuyen> getDiemtrungtuyenSet() {
        return diemtrungtuyenSet;
    }

    public void setDiemtrungtuyenSet(Set<Diemtrungtuyen> diemtrungtuyenSet) {
        this.diemtrungtuyenSet = diemtrungtuyenSet;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
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
        if (!(object instanceof Nganh)) {
            return false;
        }
        Nganh other = (Nganh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.Nganh[ id=" + id + " ]";
    }
    
}
