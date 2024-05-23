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
import javax.persistence.ManyToMany;
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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByHoten", query = "SELECT u FROM User u WHERE u.hoten = :hoten"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.role = :role")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "hoten")
    private String hoten;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "username")
    private String username;
    @Size(max = 50)
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private Integer role;
    @ManyToMany(mappedBy = "userSet")
    private Set<Tintuyensinh> tintuyensinhSet;
    @OneToMany(mappedBy = "userId")
    private Set<Binhluanvideolivestream> binhluanvideolivestreamSet;
    @OneToMany(mappedBy = "userId")
    private Set<Banner> bannerSet;
    @OneToMany(mappedBy = "user")
    private Set<Thongbaolivestream> thongbaolivestreamSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Binhluanthongbao> binhluanthongbaoSet;

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

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @XmlTransient
    public Set<Tintuyensinh> getTintuyensinhSet() {
        return tintuyensinhSet;
    }

    public void setTintuyensinhSet(Set<Tintuyensinh> tintuyensinhSet) {
        this.tintuyensinhSet = tintuyensinhSet;
    }

    @XmlTransient
    public Set<Binhluanvideolivestream> getBinhluanvideolivestreamSet() {
        return binhluanvideolivestreamSet;
    }

    public void setBinhluanvideolivestreamSet(Set<Binhluanvideolivestream> binhluanvideolivestreamSet) {
        this.binhluanvideolivestreamSet = binhluanvideolivestreamSet;
    }

    @XmlTransient
    public Set<Banner> getBannerSet() {
        return bannerSet;
    }

    public void setBannerSet(Set<Banner> bannerSet) {
        this.bannerSet = bannerSet;
    }

    @XmlTransient
    public Set<Thongbaolivestream> getThongbaolivestreamSet() {
        return thongbaolivestreamSet;
    }

    public void setThongbaolivestreamSet(Set<Thongbaolivestream> thongbaolivestreamSet) {
        this.thongbaolivestreamSet = thongbaolivestreamSet;
    }

    @XmlTransient
    public Set<Binhluanthongbao> getBinhluanthongbaoSet() {
        return binhluanthongbaoSet;
    }

    public void setBinhluanthongbaoSet(Set<Binhluanthongbao> binhluanthongbaoSet) {
        this.binhluanthongbaoSet = binhluanthongbaoSet;
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
    
}
