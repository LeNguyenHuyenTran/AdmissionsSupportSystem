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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
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
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "tieude")
    private String tieude;
    @JoinTable(name = "binhluan", joinColumns = {
        @JoinColumn(name = "tintuyensinh", referencedColumnName = "id"),
        @JoinColumn(name = "tintuyensinh", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "nguoibinhluan", referencedColumnName = "id"),
        @JoinColumn(name = "nguoibinhluan", referencedColumnName = "id")})
    @ManyToMany
    private Set<User> userSet;
    @JoinColumns({
        @JoinColumn(name = "loaituyensinh", referencedColumnName = "id"),
        @JoinColumn(name = "loaituyensinh", referencedColumnName = "id")})
    @ManyToOne(optional = false)
    private Loaituyensinh loaituyensinh;
    @JoinColumns({
        @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Thongtin thongtin;

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

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    @XmlTransient
    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
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
