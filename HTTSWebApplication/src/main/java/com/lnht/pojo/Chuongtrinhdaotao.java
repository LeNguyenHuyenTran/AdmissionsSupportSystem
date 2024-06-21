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
 * @author minh-nguyen
 */
@Entity
@Table(name = "chuongtrinhdaotao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chuongtrinhdaotao.findAll", query = "SELECT c FROM Chuongtrinhdaotao c"),
    @NamedQuery(name = "Chuongtrinhdaotao.findById", query = "SELECT c FROM Chuongtrinhdaotao c WHERE c.id = :id"),
    @NamedQuery(name = "Chuongtrinhdaotao.findByTen", query = "SELECT c FROM Chuongtrinhdaotao c WHERE c.ten = :ten")})
public class Chuongtrinhdaotao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @NotNull(message = "{value.NullMsg}")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{value.NullMsg}")
    @Size(min = 1, max = 70)
    @Column(name = "ten")
    private String ten;
    @Lob
    @Size(min=1, max = 2147483647, message = "{value.SizeMsg}")
    @Column(name = "mota")
    private String mota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chuongtrinhdaotao1")
    private Set<Diemtrungtuyen> diemtrungtuyenSet;

    public Chuongtrinhdaotao() {
    }

    public Chuongtrinhdaotao(Integer id) {
        this.id = id;
    }

    public Chuongtrinhdaotao(Integer id, String ten) {
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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @XmlTransient
    public Set<Diemtrungtuyen> getDiemtrungtuyenSet() {
        return diemtrungtuyenSet;
    }

    public void setDiemtrungtuyenSet(Set<Diemtrungtuyen> diemtrungtuyenSet) {
        this.diemtrungtuyenSet = diemtrungtuyenSet;
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
        if (!(object instanceof Chuongtrinhdaotao)) {
            return false;
        }
        Chuongtrinhdaotao other = (Chuongtrinhdaotao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.Chuongtrinhdaotao[ id=" + id + " ]";
    }
    
}
