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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author minh-nguyen
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByHoten", query = "SELECT u FROM User u WHERE u.hoten = :hoten"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {

    @Size(max = 45)
    @Column(name = "hoten")
    private String hoten;
    @Size(max = 50)
    @Column(name = "username")
    private String username;
    @Lob
    @Size(max = 65535)
    @Column(name = "password")
    private String password;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull(message = "{value.NulMsg}")
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Banner> bannerSet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Thisinh thisinh;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Admin admin;
    @OneToMany(mappedBy = "nguoibinhluan")
    private Set<Binhluan> binhluanSet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Nguoituvan nguoituvan;
    @JoinColumn(name = "role", referencedColumnName = "id")
    @ManyToOne
    private Userrole role;

     @Transient
    private String confirmPassword;
    
    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @XmlTransient
    public Set<Banner> getBannerSet() {
        return Collections.unmodifiableSet(bannerSet);
    }

    public void setBannerSet(Set<Banner> bannerSet) {
        this.bannerSet = bannerSet;
    }

    public Thisinh getThisinh() {
        return thisinh;
    }

    public void setThisinh(Thisinh thisinh) {
        this.thisinh = thisinh;
    }

    @XmlTransient
    public Set<Binhluan> getBinhluanSet() {
        return Collections.unmodifiableSet(binhluanSet);
    }

    public void setBinhluanSet(Set<Binhluan> binhluanSet) {
        this.binhluanSet = binhluanSet;
    }

    public Nguoituvan getNguoituvan() {
        return nguoituvan;
    }

    public void setNguoituvan(Nguoituvan nguoituvan) {
        this.nguoituvan = nguoituvan;
    }

    public Userrole getRole() {
        return role;
    }

    public void setRole(Userrole role) {
        this.role = role;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.User[ id=" + id + " ]";
    }

    /**
     * @return the admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
