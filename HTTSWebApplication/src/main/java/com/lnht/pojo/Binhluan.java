/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author minh-nguyen
 */
@Entity
@Table(name = "binhluan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Binhluan.findAll", query = "SELECT b FROM Binhluan b"),
    @NamedQuery(name = "Binhluan.findById", query = "SELECT b FROM Binhluan b WHERE b.id = :id")})
public class Binhluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "binhluan")
    private String binhluan;
    @JoinColumn(name = "tintuyensinh_id", referencedColumnName = "id")
    @ManyToOne
    private Tintuyensinh tintuyensinhId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public Binhluan() {
    }

    public Binhluan(Integer id) {
        this.id = id;
    }

    public Binhluan(Integer id, String binhluan) {
        this.id = id;
        this.binhluan = binhluan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBinhluan() {
        return binhluan;
    }

    public void setBinhluan(String binhluan) {
        this.binhluan = binhluan;
    }

    public Tintuyensinh getTintuyensinhId() {
        return tintuyensinhId;
    }

    public void setTintuyensinhId(Tintuyensinh tintuyensinhId) {
        this.tintuyensinhId = tintuyensinhId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Binhluan)) {
            return false;
        }
        Binhluan other = (Binhluan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.Binhluan[ id=" + id + " ]";
    }
    
}
