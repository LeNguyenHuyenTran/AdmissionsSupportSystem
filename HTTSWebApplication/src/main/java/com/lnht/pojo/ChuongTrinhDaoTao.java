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
@Table(name = "chuong_trinh_dao_tao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChuongTrinhDaoTao.findAll", query = "SELECT c FROM ChuongTrinhDaoTao c"),
    @NamedQuery(name = "ChuongTrinhDaoTao.findById", query = "SELECT c FROM ChuongTrinhDaoTao c WHERE c.id = :id"),
    @NamedQuery(name = "ChuongTrinhDaoTao.findByTen", query = "SELECT c FROM ChuongTrinhDaoTao c WHERE c.ten = :ten")})
public class ChuongTrinhDaoTao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "ten")
    private String ten;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "mo_ta")
    private String moTa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chuongTrinhDaoTao1")
    private Set<DiemTrungTuyen> diemTrungTuyenSet;

    public ChuongTrinhDaoTao() {
    }

    public ChuongTrinhDaoTao(Integer id) {
        this.id = id;
    }

    public ChuongTrinhDaoTao(Integer id, String ten) {
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @XmlTransient
    public Set<DiemTrungTuyen> getDiemTrungTuyenSet() {
        return diemTrungTuyenSet;
    }

    public void setDiemTrungTuyenSet(Set<DiemTrungTuyen> diemTrungTuyenSet) {
        this.diemTrungTuyenSet = diemTrungTuyenSet;
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
        if (!(object instanceof ChuongTrinhDaoTao)) {
            return false;
        }
        ChuongTrinhDaoTao other = (ChuongTrinhDaoTao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.ChuongTrinhDaoTao[ id=" + id + " ]";
    }
    
}
