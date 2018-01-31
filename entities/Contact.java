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
@Table(catalog = "hospital", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
    , @NamedQuery(name = "Contact.findByContactId", query = "SELECT c FROM Contact c WHERE c.contactId = :contactId")
    , @NamedQuery(name = "Contact.findByCellphoneNo", query = "SELECT c FROM Contact c WHERE c.cellphoneNo = :cellphoneNo")
    , @NamedQuery(name = "Contact.findByEmail", query = "SELECT c FROM Contact c WHERE c.email = :email")
    , @NamedQuery(name = "Contact.findByTelephoneNo", query = "SELECT c FROM Contact c WHERE c.telephoneNo = :telephoneNo")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contact_id", nullable = false)
    private Integer contactId;
    @Basic(optional = false)
    @Column(name = "cellphone_no", nullable = false)
    private long cellphoneNo;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String email;
    @Basic(optional = false)
    @Column(name = "telephone_no", nullable = false)
    private long telephoneNo;

    public Contact() {
    }

    public Contact(Integer contactId) {
        this.contactId = contactId;
    }

    public Contact(Integer contactId, long cellphoneNo, String email, long telephoneNo) {
        this.contactId = contactId;
        this.cellphoneNo = cellphoneNo;
        this.email = email;
        this.telephoneNo = telephoneNo;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public long getCellphoneNo() {
        return cellphoneNo;
    }

    public void setCellphoneNo(long cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(long telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.Contact[ contactId=" + contactId + " ]";
    }
    
    public void register(int patientId, Contact contact){
        Connection connection = null;
        PreparedStatement preparedStatement = null;  
        
        try {            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");                                
            String sql = "INSERT INTO contact (patient_id, cellphone_no, email, telephone_no)"
                    + "VALUES(?,?,?,?)";
            
            preparedStatement = connection.prepareStatement(sql);                           
            
            
            preparedStatement.setInt(1, patientId);
            preparedStatement.setInt(2, (int) this.cellphoneNo);
            preparedStatement.setString(3, this.email);
            preparedStatement.setInt(4, (int) this.telephoneNo);
            
            preparedStatement.execute();            
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Address not SAVED");
        }         
    }   
}
