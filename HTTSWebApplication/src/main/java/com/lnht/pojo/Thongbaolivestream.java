/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Basic(optional = false)
    @NotNull(message = "{value.NullMsg}")
    @Column(name = "id")
    private Integer id;
    @Column(name = "giolivestream")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "{value.NullMsg}")
    private Date giolivestream;
    @JoinColumn(name = "nguoidangthongbao", referencedColumnName = "id")
    @ManyToOne
    private Nguoituvan nguoidangthongbao;
    @JoinColumn(name = "videolivestream", referencedColumnName = "id")
    @ManyToOne
    private Videolivestream videolivestream;
    @OneToMany(mappedBy = "thongbaolivestream")
    private Set<Cauhoi> cauhoiSet;

    public Thongbaolivestream() {
    }

    public Thongbaolivestream(Integer id) {
        this.id = id;
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

    public Nguoituvan getNguoidangthongbao() {
        return nguoidangthongbao;
    }

    public void setNguoidangthongbao(Nguoituvan nguoidangthongbao) {
        this.nguoidangthongbao = nguoidangthongbao;
    }

    public Videolivestream getVideolivestream() {
        return videolivestream;
    }

    public void setVideolivestream(Videolivestream videolivestream) {
        this.videolivestream = videolivestream;
    }

    @XmlTransient
    public Set<Cauhoi> getCauhoiSet() {
        return cauhoiSet;
    }

    public void setCauhoiSet(Set<Cauhoi> cauhoiSet) {
        this.cauhoiSet = cauhoiSet;
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
