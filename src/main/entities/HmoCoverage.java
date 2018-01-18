/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "hmo_coverage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HmoCoverage.findAll", query = "SELECT h FROM HmoCoverage h")
    , @NamedQuery(name = "HmoCoverage.findByHmoNo", query = "SELECT h FROM HmoCoverage h WHERE h.hmoNo = :hmoNo")
    , @NamedQuery(name = "HmoCoverage.findByAmount", query = "SELECT h FROM HmoCoverage h WHERE h.amount = :amount")})
public class HmoCoverage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "hmo_no")
    private Integer hmoNo;
    @Basic(optional = false)
    @Lob
    @Column(name = "coverage")
    private String coverage;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @JoinColumn(name = "hmo_no", referencedColumnName = "hmo_no", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Hmo hmo;

    public HmoCoverage() {
    }

    public HmoCoverage(Integer hmoNo) {
        this.hmoNo = hmoNo;
    }

    public HmoCoverage(Integer hmoNo, String coverage, int amount) {
        this.hmoNo = hmoNo;
        this.coverage = coverage;
        this.amount = amount;
    }

    public Integer getHmoNo() {
        return hmoNo;
    }

    public void setHmoNo(Integer hmoNo) {
        this.hmoNo = hmoNo;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Hmo getHmo() {
        return hmo;
    }

    public void setHmo(Hmo hmo) {
        this.hmo = hmo;
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
        if (!(object instanceof HmoCoverage)) {
            return false;
        }
        HmoCoverage other = (HmoCoverage) object;
        if ((this.hmoNo == null && other.hmoNo != null) || (this.hmoNo != null && !this.hmoNo.equals(other.hmoNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.HmoCoverage[ hmoNo=" + hmoNo + " ]";
    }
    
}
