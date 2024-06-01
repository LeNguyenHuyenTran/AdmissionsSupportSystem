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
@Table(name = "video_livestream")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VideoLivestream.findAll", query = "SELECT v FROM VideoLivestream v"),
    @NamedQuery(name = "VideoLivestream.findById", query = "SELECT v FROM VideoLivestream v WHERE v.id = :id"),
    @NamedQuery(name = "VideoLivestream.findByTieuDe", query = "SELECT v FROM VideoLivestream v WHERE v.tieuDe = :tieuDe")})
public class VideoLivestream implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tieu_de")
    private String tieuDe;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "video")
    private String video;
    @OneToMany(mappedBy = "videoLivestreamId")
    private Set<BinhLuanVideoLivestream> binhLuanVideoLivestreamSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "videoLivestreamId")
    private Set<ThongBaoLivestream> thongBaoLivestreamSet;

    public VideoLivestream() {
    }

    public VideoLivestream(Integer id) {
        this.id = id;
    }

    public VideoLivestream(Integer id, String tieuDe, String video) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.video = video;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @XmlTransient
    public Set<BinhLuanVideoLivestream> getBinhLuanVideoLivestreamSet() {
        return binhLuanVideoLivestreamSet;
    }

    public void setBinhLuanVideoLivestreamSet(Set<BinhLuanVideoLivestream> binhLuanVideoLivestreamSet) {
        this.binhLuanVideoLivestreamSet = binhLuanVideoLivestreamSet;
    }

    @XmlTransient
    public Set<ThongBaoLivestream> getThongBaoLivestreamSet() {
        return thongBaoLivestreamSet;
    }

    public void setThongBaoLivestreamSet(Set<ThongBaoLivestream> thongBaoLivestreamSet) {
        this.thongBaoLivestreamSet = thongBaoLivestreamSet;
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
        if (!(object instanceof VideoLivestream)) {
            return false;
        }
        VideoLivestream other = (VideoLivestream) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.VideoLivestream[ id=" + id + " ]";
    }
    
}
