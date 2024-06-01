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
 * @author Admin
 */
@Entity
@Table(name = "binh_luan_video_livestream")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BinhLuanVideoLivestream.findAll", query = "SELECT b FROM BinhLuanVideoLivestream b"),
    @NamedQuery(name = "BinhLuanVideoLivestream.findById", query = "SELECT b FROM BinhLuanVideoLivestream b WHERE b.id = :id"),
    @NamedQuery(name = "BinhLuanVideoLivestream.findByCreatedDate", query = "SELECT b FROM BinhLuanVideoLivestream b WHERE b.createdDate = :createdDate")})
public class BinhLuanVideoLivestream implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "noi_dung")
    private String noiDung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;
    @JoinColumn(name = "video_livestream_id", referencedColumnName = "id")
    @ManyToOne
    private VideoLivestream videoLivestreamId;

    public BinhLuanVideoLivestream() {
    }

    public BinhLuanVideoLivestream(Integer id) {
        this.id = id;
    }

    public BinhLuanVideoLivestream(Integer id, Date createdDate) {
        this.id = id;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public VideoLivestream getVideoLivestreamId() {
        return videoLivestreamId;
    }

    public void setVideoLivestreamId(VideoLivestream videoLivestreamId) {
        this.videoLivestreamId = videoLivestreamId;
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
        if (!(object instanceof BinhLuanVideoLivestream)) {
            return false;
        }
        BinhLuanVideoLivestream other = (BinhLuanVideoLivestream) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.BinhLuanVideoLivestream[ id=" + id + " ]";
    }
    
}
