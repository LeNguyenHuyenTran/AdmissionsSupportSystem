/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author minh-nguyen
 */
@Entity
@Table(name = "tintuyensinh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tintuyensinh.findAll", query = "SELECT t FROM Tintuyensinh t"),
    @NamedQuery(name = "Tintuyensinh.findById", query = "SELECT t FROM Tintuyensinh t WHERE t.id = :id")})
public class Tintuyensinh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @NotNull(message = "{value.NullMsg}")
    private Integer id;
    @JoinColumn(name = "loaituyensinh", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Loaituyensinh loaituyensinh;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Thongtin thongtin;
    @OneToMany(mappedBy = "tintuyensinh")
    private Set<Binhluan> binhluanSet;

    public Tintuyensinh() {
    }

    public Tintuyensinh(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Loaituyensinh getLoaituyensinh() {
        return loaituyensinh;
    }

    public void setLoaituyensinh(Loaituyensinh loaituyensinh) {
        this.loaituyensinh = loaituyensinh;
    }

    public Thongtin getThongtin() {
        return thongtin;
    }

    public void setThongtin(Thongtin thongtin) {
        this.thongtin = thongtin;
    }

    @XmlTransient
    public Set<Binhluan> getBinhluanSet() {
        return binhluanSet;
    }

    public void setBinhluanSet(Set<Binhluan> binhluanSet) {
        this.binhluanSet = binhluanSet;
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
        if (!(object instanceof Tintuyensinh)) {
            return false;
        }
        Tintuyensinh other = (Tintuyensinh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.Tintuyensinh[ id=" + id + " ]";
    }
    
}
