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
 * @author Admin
 */
@Entity
@Table(name = "videolivestream")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Videolivestream.findAll", query = "SELECT v FROM Videolivestream v"),
    @NamedQuery(name = "Videolivestream.findById", query = "SELECT v FROM Videolivestream v WHERE v.id = :id"),
    @NamedQuery(name = "Videolivestream.findByTieude", query = "SELECT v FROM Videolivestream v WHERE v.tieude = :tieude")})
public class Videolivestream implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tieude")
    private String tieude;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "video")
    private String video;
    @OneToMany(mappedBy = "videoLivestream")
    private Set<Binhluanvideolivestream> binhluanvideolivestreamSet;
    @OneToMany(mappedBy = "videolivestream")
    private Set<Thongbaolivestream> thongbaolivestreamSet;

    public Videolivestream() {
    }

    public Videolivestream(Integer id) {
        this.id = id;
    }

    public Videolivestream(Integer id, String tieude, String video) {
        this.id = id;
        this.tieude = tieude;
        this.video = video;
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @XmlTransient
    public Set<Binhluanvideolivestream> getBinhluanvideolivestreamSet() {
        return binhluanvideolivestreamSet;
    }

    public void setBinhluanvideolivestreamSet(Set<Binhluanvideolivestream> binhluanvideolivestreamSet) {
        this.binhluanvideolivestreamSet = binhluanvideolivestreamSet;
    }

    @XmlTransient
    public Set<Thongbaolivestream> getThongbaolivestreamSet() {
        return thongbaolivestreamSet;
    }

    public void setThongbaolivestreamSet(Set<Thongbaolivestream> thongbaolivestreamSet) {
        this.thongbaolivestreamSet = thongbaolivestreamSet;
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
        if (!(object instanceof Videolivestream)) {
            return false;
        }
        Videolivestream other = (Videolivestream) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.Videolivestream[ id=" + id + " ]";
    }
    
}
