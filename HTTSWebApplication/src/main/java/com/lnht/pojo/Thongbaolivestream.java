/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author minh-nguyen
 */
@Entity
@Table(name = "thongbaolivestream")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thongbaolivestream.findAll", query = "SELECT t FROM Thongbaolivestream t"),
    @NamedQuery(name = "Thongbaolivestream.findById", query = "SELECT t FROM Thongbaolivestream t WHERE t.id = :id"),
    @NamedQuery(name = "Thongbaolivestream.findByGiolivestream", query = "SELECT t FROM Thongbaolivestream t WHERE t.giolivestream = :giolivestream")})
public class Thongbaolivestream implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "giolivestream")
    @Temporal(TemporalType.TIMESTAMP)
    private Date giolivestream;
    @JoinColumn(name = "nguoidangthongbao_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User nguoidangthongbaoId;
    @JoinColumn(name = "videolivestream_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Videolivestream videolivestreamId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thongbaolivestreamId")
    private Set<Binhluanthongbao> binhluanthongbaoSet;

    public Thongbaolivestream() {
    }

    public Thongbaolivestream(Integer id) {
        this.id = id;
    }

    public Thongbaolivestream(Integer id, Date giolivestream) {
        this.id = id;
        this.giolivestream = giolivestream;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGiolivestream() {
        return giolivestream;
    }

    public void setGiolivestream(Date giolivestream) {
        this.giolivestream = giolivestream;
    }

    public User getNguoidangthongbaoId() {
        return nguoidangthongbaoId;
    }

    public void setNguoidangthongbaoId(User nguoidangthongbaoId) {
        this.nguoidangthongbaoId = nguoidangthongbaoId;
    }

    public Videolivestream getVideolivestreamId() {
        return videolivestreamId;
    }

    public void setVideolivestreamId(Videolivestream videolivestreamId) {
        this.videolivestreamId = videolivestreamId;
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
        if (!(object instanceof Thongbaolivestream)) {
            return false;
        }
        Thongbaolivestream other = (Thongbaolivestream) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.Thongbaolivestream[ id=" + id + " ]";
    }
    
}
