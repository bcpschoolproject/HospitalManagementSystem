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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DelaTorreNelson
 */
@Entity
@Table(catalog = "hospital", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"doctor_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d")
    , @NamedQuery(name = "Doctor.findByDoctorId", query = "SELECT d FROM Doctor d WHERE d.doctorId = :doctorId")
    , @NamedQuery(name = "Doctor.findByAge", query = "SELECT d FROM Doctor d WHERE d.age = :age")
    , @NamedQuery(name = "Doctor.findByGender", query = "SELECT d FROM Doctor d WHERE d.gender = :gender")
    , @NamedQuery(name = "Doctor.findByCivilStatus", query = "SELECT d FROM Doctor d WHERE d.civilStatus = :civilStatus")})
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doctor_id", nullable = false)
    private Integer doctorId;
    @Lob
    @Column(length = 65535)
    private String firstname;
    @Lob
    @Column(length = 65535)
    private String lastname;
    @Lob
    @Column(length = 65535)
    private String middlename;
    @Basic(optional = false)
    @Column(nullable = false)
    private int age;
    @Basic(optional = false)
    @Column(nullable = false, length = 6)
    private String gender;
    @Basic(optional = false)
    @Column(name = "civil_status", nullable = false, length = 20)
    private String civilStatus;

    public Doctor() {
    }

    public Doctor(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Doctor(Integer doctorId, int age, String gender, String civilStatus) {
        this.doctorId = doctorId;
        this.age = age;
        this.gender = gender;
        this.civilStatus = civilStatus;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorId != null ? doctorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.doctorId == null && other.doctorId != null) || (this.doctorId != null && !this.doctorId.equals(other.doctorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.Doctor[ doctorId=" + doctorId + " ]";
    }
    
}
