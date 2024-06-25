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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author minh-nguyen
 */
@Entity
@Table(name = "anh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anh.findAll", query = "SELECT a FROM Anh a"),
    @NamedQuery(name = "Anh.findById", query = "SELECT a FROM Anh a WHERE a.id = :id")})
public class Anh implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "anh")
    private String anh;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @NotNull(message = "{value.NullMsg}")
    private Integer id;
    @JoinColumn(name = "nguoidang", referencedColumnName = "id")
    @ManyToOne
    private Admin nguoidang;

    @Transient
    private MultipartFile file;
    
    public Anh() {
    }

    public Anh(Integer id) {
        this.id = id;
    }

    public Anh(Integer id, String anh) {
        this.id = id;
        this.anh = anh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Admin getNguoidang() {
        return nguoidang;
    }

    public void setNguoidang(Admin nguoidang) {
        this.nguoidang = nguoidang;
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
        if (!(object instanceof Anh)) {
            return false;
        }
        Anh other = (Anh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.Anh[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
}
