/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.entities;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlRootElement;
import main.core1.Registration;

/**
 *
 * @author DelaTorreNelson
 */
@Entity
@Table(name = "contact_person", catalog = "hospital", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactPerson.findAll", query = "SELECT c FROM ContactPerson c")
    , @NamedQuery(name = "ContactPerson.findByContactPersonId", query = "SELECT c FROM ContactPerson c WHERE c.contactPersonId = :contactPersonId")
    , @NamedQuery(name = "ContactPerson.findByPatientId", query = "SELECT c FROM ContactPerson c WHERE c.patientId = :patientId")
    , @NamedQuery(name = "ContactPerson.findByFirstname", query = "SELECT c FROM ContactPerson c WHERE c.firstname = :firstname")
    , @NamedQuery(name = "ContactPerson.findByLastname", query = "SELECT c FROM ContactPerson c WHERE c.lastname = :lastname")
    , @NamedQuery(name = "ContactPerson.findByMiddlename", query = "SELECT c FROM ContactPerson c WHERE c.middlename = :middlename")
    , @NamedQuery(name = "ContactPerson.findByRelationship", query = "SELECT c FROM ContactPerson c WHERE c.relationship = :relationship")
    , @NamedQuery(name = "ContactPerson.findByContactNo", query = "SELECT c FROM ContactPerson c WHERE c.contactNo = :contactNo")})
public class ContactPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contact_person_id", nullable = false)
    private Integer contactPersonId;
    @Basic(optional = false)
    @Column(name = "patient_id", nullable = false)
    private int patientId;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String firstname;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String lastname;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String middlename;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String relationship;
    @Basic(optional = false)
    @Column(name = "contact_no", nullable = false)
    private long contactNo;

    public ContactPerson() {
    }

    public ContactPerson(Integer contactPersonId) {
        this.contactPersonId = contactPersonId;
    }

    public ContactPerson(Integer contactPersonId, int patientId, String firstname, String lastname, String middlename, String relationship, long contactNo) {
        this.contactPersonId = contactPersonId;
        this.patientId = patientId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.relationship = relationship;
        this.contactNo = contactNo;
    }

    public Integer getContactPersonId() {
        return contactPersonId;
    }

    public void setContactPersonId(Integer contactPersonId) {
        this.contactPersonId = contactPersonId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactPersonId != null ? contactPersonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactPerson)) {
            return false;
        }
        ContactPerson other = (ContactPerson) object;
        if ((this.contactPersonId == null && other.contactPersonId != null) || (this.contactPersonId != null && !this.contactPersonId.equals(other.contactPersonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.ContactPerson[ contactPersonId=" + contactPersonId + " ]";
    }

    public void register(int patientId, ContactPerson contactPerson){
        Connection connection = null;
        PreparedStatement preparedStatement = null;  
        
        try {            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");                                
            String sql = "INSERT INTO contact_person (patient_id,firstname, lastname, middlename, relationship, contact_no)"
                    + "VALUES(?,?,?,?,?,?)";
            
            preparedStatement = connection.prepareStatement(sql);                           
            
            preparedStatement.setInt(1, patientId);
            preparedStatement.setString(2, this.firstname);
            preparedStatement.setString(3, this.lastname);
            preparedStatement.setString(4, this.middlename);
            preparedStatement.setString(5, this.relationship);
            preparedStatement.setInt(6, (int) this.contactNo);
            
            preparedStatement.setInt(1, patientId);
            
            preparedStatement.execute();                        
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Address not SAVED");
        }         
    }
    
}
