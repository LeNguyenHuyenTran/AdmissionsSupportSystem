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
@Table(name = "cauhoi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cauhoi.findAll", query = "SELECT c FROM Cauhoi c"),
    @NamedQuery(name = "Cauhoi.findById", query = "SELECT c FROM Cauhoi c WHERE c.id = :id"),
    @NamedQuery(name = "Cauhoi.findByThoidiem", query = "SELECT c FROM Cauhoi c WHERE c.thoidiem = :thoidiem")})
public class Cauhoi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @NotNull(message = "{value.NullMsg}")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{value.NullMsg}")
    @Lob
    @Size(min = 1, max = 65535, message = "{value.SizeMsg}")
    @Column(name = "noidung")
    private String noidung;
    @Basic(optional = false)
    @NotNull(message = "{value.NullMsg}")
    @Column(name = "thoidiem")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoidiem;
    @JoinColumn(name = "thisinh", referencedColumnName = "id")
    @ManyToOne
    private Thisinh thisinh;
    @JoinColumn(name = "thongbaolivestream", referencedColumnName = "id")
    @ManyToOne
    private Thongbaolivestream thongbaolivestream;
    @JoinColumn(name = "video", referencedColumnName = "id")
    @ManyToOne
    private Videolivestream video;

    public Cauhoi() {
    }

    public Cauhoi(Integer id) {
        this.id = id;
    }

    public Cauhoi(Integer id, String noidung, Date thoidiem) {
        this.id = id;
        this.noidung = noidung;
        this.thoidiem = thoidiem;
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

    public Date getThoidiem() {
        return thoidiem;
    }

    public void setThoidiem(Date thoidiem) {
        this.thoidiem = thoidiem;
    }

    public Thisinh getThisinh() {
        return thisinh;
    }

    public void setThisinh(Thisinh thisinh) {
        this.thisinh = thisinh;
    }

    public Thongbaolivestream getThongbaolivestream() {
        return thongbaolivestream;
    }

    public void setThongbaolivestream(Thongbaolivestream thongbaolivestream) {
        this.thongbaolivestream = thongbaolivestream;
    }

    public Videolivestream getVideo() {
        return video;
    }

    public void setVideo(Videolivestream video) {
        this.video = video;
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
        if (!(object instanceof Cauhoi)) {
            return false;
        }
        Cauhoi other = (Cauhoi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnht.pojo.Cauhoi[ id=" + id + " ]";
    }
    
}
