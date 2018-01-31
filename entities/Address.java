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
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByPatientId", query = "SELECT a FROM Address a WHERE a.patientId = :patientId")
    , @NamedQuery(name = "Address.findByLot", query = "SELECT a FROM Address a WHERE a.lot = :lot")
    , @NamedQuery(name = "Address.findByStreetNo", query = "SELECT a FROM Address a WHERE a.streetNo = :streetNo")
    , @NamedQuery(name = "Address.findByZip", query = "SELECT a FROM Address a WHERE a.zip = :zip")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patient_id", nullable = false)
    private Integer patientId;
    @Basic(optional = false)
    @Column(nullable = false)
    private int lot;
    @Basic(optional = false)
    @Column(name = "street_no", nullable = false)
    private int streetNo;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 65535)
    private String city;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 65535)
    private String municipality;
    @Basic(optional = false)
    @Column(nullable = false)
    private int zip;

    public Address() {
    }

    public Address(Integer patientId) {
        this.patientId = patientId;
    }

    public Address(Integer patientId, int lot, int streetNo, String city, String municipality, int zip) {
        this.patientId = patientId;
        this.lot = lot;
        this.streetNo = streetNo;
        this.city = city;
        this.municipality = municipality;
        this.zip = zip;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public int getLot() {
        return lot;
    }

    public void setLot(int lot) {
        this.lot = lot;
    }

    public int getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientId != null ? patientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.patientId == null && other.patientId != null) || (this.patientId != null && !this.patientId.equals(other.patientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.Address[ patientId=" + patientId + " ]";
    }
    
    public void register(int patientID, Address address){
        Connection connection = null;
        PreparedStatement preparedStatement = null;  
        
        try {            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
            //JOptionPane.showMessageDialog(null,"Saved");
        
            
            String sql = "INSERT INTO address (patient_id, lot, street_no, city, municipality, zip)"
                    + "VALUES(?,?,?,?,?,?)";
            
            preparedStatement = connection.prepareStatement(sql);                           
            
            
            preparedStatement.setInt(1, patientID);
            preparedStatement.setInt(2, this.lot);
            preparedStatement.setInt(3, this.streetNo);
            preparedStatement.setString(4, this.city);
            preparedStatement.setString(5, this.municipality);
            preparedStatement.setInt(6, this.zip);
            
            preparedStatement.execute();
            //JOptionPane.showMessageDialog(null, "Address SAVED!!!");
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Address not SAVED");
        }        
    }
    
}
