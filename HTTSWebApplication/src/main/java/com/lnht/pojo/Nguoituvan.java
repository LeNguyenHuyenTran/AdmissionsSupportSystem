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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "nguoituvan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nguoituvan.findAll", query = "SELECT n FROM Nguoituvan n"),
    @NamedQuery(name = "Nguoituvan.findById", query = "SELECT n FROM Nguoituvan n WHERE n.id = :id")})
public class Nguoituvan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull(message = "{value.NullMsg}")
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "nguoidangthongbao")
    private Set<Thongbaolivestream> thongbaolivestreamSet;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public Nguoituvan() {
    }

    public Nguoituvan(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Set<Thongbaolivestream> getThongbaolivestreamSet() {
        return thongbaolivestreamSet;
    }

    public void setThongbaolivestreamSet(Set<Thongbaolivestream> thongbaolivestreamSet) {
        this.thongbaolivestreamSet = thongbaolivestreamSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!(object instanceof Nguoituvan)) {
            return false;
        }
        Nguoituvan other = (Nguoituvan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.Nguoituvan[ id=" + id + " ]";
    }
    
}
