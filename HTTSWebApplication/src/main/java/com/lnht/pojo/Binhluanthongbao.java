/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author minh-nguyen
 */
@Entity
@Table(name = "binhluanthongbao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Binhluanthongbao.findAll", query = "SELECT b FROM Binhluanthongbao b"),
    @NamedQuery(name = "Binhluanthongbao.findById", query = "SELECT b FROM Binhluanthongbao b WHERE b.id = :id"),
    @NamedQuery(name = "Binhluanthongbao.findByCreatedDate", query = "SELECT b FROM Binhluanthongbao b WHERE b.createdDate = :createdDate")})
public class Binhluanthongbao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "noidung")
    private String noidung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "thongbaolivestream_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Thongbaolivestream thongbaolivestreamId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Binhluanthongbao() {
    }

    public Binhluanthongbao(Integer id) {
        this.id = id;
    }

    public Binhluanthongbao(Integer id, Date createdDate) {
        this.id = id;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Thongbaolivestream getThongbaolivestreamId() {
        return thongbaolivestreamId;
    }

    public void setThongbaolivestreamId(Thongbaolivestream thongbaolivestreamId) {
        this.thongbaolivestreamId = thongbaolivestreamId;
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
        if (!(object instanceof Binhluanthongbao)) {
            return false;
        }
        Binhluanthongbao other = (Binhluanthongbao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.Binhluanthongbao[ id=" + id + " ]";
    }
    
}
