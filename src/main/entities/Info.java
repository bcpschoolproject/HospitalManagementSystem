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
import javax.persistence.Lob;
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
@Table(name = "info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Info.findAll", query = "SELECT i FROM Info i")
    , @NamedQuery(name = "Info.findById", query = "SELECT i FROM Info i WHERE i.id = :id")
    , @NamedQuery(name = "Info.findByFirstname", query = "SELECT i FROM Info i WHERE i.firstname = :firstname")
    , @NamedQuery(name = "Info.findByLastname", query = "SELECT i FROM Info i WHERE i.lastname = :lastname")
    , @NamedQuery(name = "Info.findByMiddlename", query = "SELECT i FROM Info i WHERE i.middlename = :middlename")
    , @NamedQuery(name = "Info.findByCivilStatus", query = "SELECT i FROM Info i WHERE i.civilStatus = :civilStatus")
    , @NamedQuery(name = "Info.findByBirthdate", query = "SELECT i FROM Info i WHERE i.birthdate = :birthdate")
    , @NamedQuery(name = "Info.findByNationality", query = "SELECT i FROM Info i WHERE i.nationality = :nationality")
    , @NamedQuery(name = "Info.findByAge", query = "SELECT i FROM Info i WHERE i.age = :age")
    , @NamedQuery(name = "Info.findByGender", query = "SELECT i FROM Info i WHERE i.gender = :gender")
    , @NamedQuery(name = "Info.findByBirthplace", query = "SELECT i FROM Info i WHERE i.birthplace = :birthplace")})
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "middlename")
    private String middlename;
    @Basic(optional = false)
    @Column(name = "civil_status")
    private String civilStatus;
    @Basic(optional = false)
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Basic(optional = false)
    @Column(name = "nationality")
    private String nationality;
    @Basic(optional = false)
    @Column(name = "age")
    private int age;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "birthplace")
    @Temporal(TemporalType.DATE)
    private Date birthplace;
    @Basic(optional = false)
    @Lob
    @Column(name = "occupation")
    private String occupation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "info")
    private Patient patient;

    public Info() {
    }

    public Info(Integer id) {
        this.id = id;
    }

    public Info(Integer id, String firstname, String lastname, String middlename, String civilStatus, Date birthdate, String nationality, int age, String gender, Date birthplace, String occupation) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.civilStatus = civilStatus;
        this.birthdate = birthdate;
        this.nationality = nationality;
        this.age = age;
        this.gender = gender;
        this.birthplace = birthplace;
        this.occupation = occupation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public Date getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Date birthplace) {
        this.birthplace = birthplace;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
        if (!(object instanceof Info)) {
            return false;
        }
        Info other = (Info) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.Info[ id=" + id + " ]";
    }
    
}
