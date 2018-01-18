/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DelaTorreNelson
 */
@Entity
@Table(name = "hmo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hmo.findAll", query = "SELECT h FROM Hmo h")
    , @NamedQuery(name = "Hmo.findByHmoNo", query = "SELECT h FROM Hmo h WHERE h.hmoNo = :hmoNo")
    , @NamedQuery(name = "Hmo.findByFund", query = "SELECT h FROM Hmo h WHERE h.fund = :fund")})
public class Hmo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "hmo_no")
    private Integer hmoNo;
    @Basic(optional = false)
    @Column(name = "fund")
    private int fund;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Patient id;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "hmo")
    private HmoCoverage hmoCoverage;

    public Hmo() {
    }

    public Hmo(Integer hmoNo) {
        this.hmoNo = hmoNo;
    }

    public Hmo(Integer hmoNo, int fund) {
        this.hmoNo = hmoNo;
        this.fund = fund;
    }

    public Integer getHmoNo() {
        return hmoNo;
    }

    public void setHmoNo(Integer hmoNo) {
        this.hmoNo = hmoNo;
    }

    public int getFund() {
        return fund;
    }

    public void setFund(int fund) {
        this.fund = fund;
    }

    public Patient getId() {
        return id;
    }

    public void setId(Patient id) {
        this.id = id;
    }

    public HmoCoverage getHmoCoverage() {
        return hmoCoverage;
    }

    public void setHmoCoverage(HmoCoverage hmoCoverage) {
        this.hmoCoverage = hmoCoverage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hmoNo != null ? hmoNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hmo)) {
            return false;
        }
        Hmo other = (Hmo) object;
        if ((this.hmoNo == null && other.hmoNo != null) || (this.hmoNo != null && !this.hmoNo.equals(other.hmoNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.Hmo[ hmoNo=" + hmoNo + " ]";
    }
    
}
