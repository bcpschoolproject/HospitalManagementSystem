/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DelaTorreNelson
 */
@Entity
@Table(name = "surgery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Surgery.findAll", query = "SELECT s FROM Surgery s")
    , @NamedQuery(name = "Surgery.findByRecordNo", query = "SELECT s FROM Surgery s WHERE s.recordNo = :recordNo")
    , @NamedQuery(name = "Surgery.findByDate", query = "SELECT s FROM Surgery s WHERE s.date = :date")
    , @NamedQuery(name = "Surgery.findByTime", query = "SELECT s FROM Surgery s WHERE s.time = :time")
    , @NamedQuery(name = "Surgery.findByDoctor1", query = "SELECT s FROM Surgery s WHERE s.doctor1 = :doctor1")})
public class Surgery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "record_no")
    private Integer recordNo;
    @Basic(optional = false)
    @Lob
    @Column(name = "procedures")
    private String procedures;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Basic(optional = false)
    @Column(name = "doctor")
    private int doctor1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "surgery")
    private Doctor doctor;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Patient id;

    public Surgery() {
    }

    public Surgery(Integer recordNo) {
        this.recordNo = recordNo;
    }

    public Surgery(Integer recordNo, String procedures, Date date, Date time, int doctor1) {
        this.recordNo = recordNo;
        this.procedures = procedures;
        this.date = date;
        this.time = time;
        this.doctor1 = doctor1;
    }

    public Integer getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(Integer recordNo) {
        this.recordNo = recordNo;
    }

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getDoctor1() {
        return doctor1;
    }

    public void setDoctor1(int doctor1) {
        this.doctor1 = doctor1;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getId() {
        return id;
    }

    public void setId(Patient id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordNo != null ? recordNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Surgery)) {
            return false;
        }
        Surgery other = (Surgery) object;
        if ((this.recordNo == null && other.recordNo != null) || (this.recordNo != null && !this.recordNo.equals(other.recordNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.Surgery[ recordNo=" + recordNo + " ]";
    }
    
}
