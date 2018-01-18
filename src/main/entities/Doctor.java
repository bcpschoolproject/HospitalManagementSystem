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
@Table(name = "doctor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d")
    , @NamedQuery(name = "Doctor.findByDoctorsId", query = "SELECT d FROM Doctor d WHERE d.doctorsId = :doctorsId")})
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "doctors_id")
    private Integer doctorsId;
    @JoinColumn(name = "doctors_id", referencedColumnName = "doctor", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Surgery surgery;

    public Doctor() {
    }

    public Doctor(Integer doctorsId) {
        this.doctorsId = doctorsId;
    }

    public Integer getDoctorsId() {
        return doctorsId;
    }

    public void setDoctorsId(Integer doctorsId) {
        this.doctorsId = doctorsId;
    }

    public Surgery getSurgery() {
        return surgery;
    }

    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorsId != null ? doctorsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.doctorsId == null && other.doctorsId != null) || (this.doctorsId != null && !this.doctorsId.equals(other.doctorsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.Doctor[ doctorsId=" + doctorsId + " ]";
    }
    
}
