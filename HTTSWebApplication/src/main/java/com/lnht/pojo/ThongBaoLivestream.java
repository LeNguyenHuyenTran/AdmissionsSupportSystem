/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "thong_bao_livestream")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThongBaoLivestream.findAll", query = "SELECT t FROM ThongBaoLivestream t"),
    @NamedQuery(name = "ThongBaoLivestream.findById", query = "SELECT t FROM ThongBaoLivestream t WHERE t.id = :id"),
    @NamedQuery(name = "ThongBaoLivestream.findByGioLivestream", query = "SELECT t FROM ThongBaoLivestream t WHERE t.gioLivestream = :gioLivestream")})
public class ThongBaoLivestream implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
//    @Lob
//    @Size(max = 2147483647)
//    @Column(name = "noi_dung")
//    private String noiDung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gio_livestream")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gioLivestream;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ThongTin thongTin;
    @JoinColumn(name = "nguoi_dang_thong_bao_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User nguoiDangThongBaoId;
    @JoinColumn(name = "video_livestream_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private VideoLivestream videoLivestreamId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thongBaoLivestreamId")
    @JsonIgnore
    private Set<BinhLuanThongBao> binhLuanThongBaoSet;

    public ThongBaoLivestream() {
    }

    public ThongBaoLivestream(Integer id) {
        this.id = id;
    }

    public ThongBaoLivestream(Integer id, Date gioLivestream) {
        this.id = id;
        this.gioLivestream = gioLivestream;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGioLivestream() {
        return gioLivestream;
    }

    public void setGioLivestream(Date gioLivestream) {
        this.gioLivestream = gioLivestream;
    }

    public ThongTin getThongTin() {
        return thongTin;
    }

    public void setThongTin(ThongTin thongTin) {
        this.thongTin = thongTin;
    }

    public User getNguoiDangThongBaoId() {
        return nguoiDangThongBaoId;
    }

    public void setNguoiDangThongBaoId(User nguoiDangThongBaoId) {
        this.nguoiDangThongBaoId = nguoiDangThongBaoId;
    }

    public VideoLivestream getVideoLivestreamId() {
        return videoLivestreamId;
    }

    public void setVideoLivestreamId(VideoLivestream videoLivestreamId) {
        this.videoLivestreamId = videoLivestreamId;
    }

    @XmlTransient
    public Set<BinhLuanThongBao> getBinhLuanThongBaoSet() {
        return binhLuanThongBaoSet;
    }

    public void setBinhLuanThongBaoSet(Set<BinhLuanThongBao> binhLuanThongBaoSet) {
        this.binhLuanThongBaoSet = binhLuanThongBaoSet;
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
        if (!(object instanceof ThongBaoLivestream)) {
            return false;
        }
        ThongBaoLivestream other = (ThongBaoLivestream) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.ThongBaoLivestream[ id=" + id + " ]";
    }
    
}
