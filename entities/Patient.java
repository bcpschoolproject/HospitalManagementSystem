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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlRootElement;
import main.core1.Registration;

/**
 *
 * @author DelaTorreNelson
 */
@Entity
@Table(catalog = "hospital", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"patient_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
    , @NamedQuery(name = "Patient.findByPatientId", query = "SELECT p FROM Patient p WHERE p.patientId = :patientId")
    , @NamedQuery(name = "Patient.findByFirstname", query = "SELECT p FROM Patient p WHERE p.firstname = :firstname")
    , @NamedQuery(name = "Patient.findByLastname", query = "SELECT p FROM Patient p WHERE p.lastname = :lastname")
    , @NamedQuery(name = "Patient.findByMiddlename", query = "SELECT p FROM Patient p WHERE p.middlename = :middlename")
    , @NamedQuery(name = "Patient.findByBirthdate", query = "SELECT p FROM Patient p WHERE p.birthdate = :birthdate")
    , @NamedQuery(name = "Patient.findByNationality", query = "SELECT p FROM Patient p WHERE p.nationality = :nationality")
    , @NamedQuery(name = "Patient.findByCivilStatus", query = "SELECT p FROM Patient p WHERE p.civilStatus = :civilStatus")
    , @NamedQuery(name = "Patient.findByOccupation", query = "SELECT p FROM Patient p WHERE p.occupation = :occupation")
    , @NamedQuery(name = "Patient.findByGender", query = "SELECT p FROM Patient p WHERE p.gender = :gender")
    , @NamedQuery(name = "Patient.findByAge", query = "SELECT p FROM Patient p WHERE p.age = :age")
    , @NamedQuery(name = "Patient.findByPhilhealth", query = "SELECT p FROM Patient p WHERE p.philhealth = :philhealth")
    , @NamedQuery(name = "Patient.findBySss", query = "SELECT p FROM Patient p WHERE p.sss = :sss")
    , @NamedQuery(name = "Patient.findByGsis", query = "SELECT p FROM Patient p WHERE p.gsis = :gsis")
    , @NamedQuery(name = "Patient.findByInsuranceNo", query = "SELECT p FROM Patient p WHERE p.insuranceNo = :insuranceNo")
    , @NamedQuery(name = "Patient.findByDoctorId", query = "SELECT p FROM Patient p WHERE p.doctorId = :doctorId")
    , @NamedQuery(name = "Patient.findByContactPersonId", query = "SELECT p FROM Patient p WHERE p.contactPersonId = :contactPersonId")
    , @NamedQuery(name = "Patient.findByContactId", query = "SELECT p FROM Patient p WHERE p.contactId = :contactId")
    , @NamedQuery(name = "Patient.findByAddressId", query = "SELECT p FROM Patient p WHERE p.addressId = :addressId")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patient_id", nullable = false)
    private Integer patientId;
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
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 65535)
    private String birthplace;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String nationality;
    @Basic(optional = false)
    @Column(name = "civil_status", nullable = false, length = 20)
    private String civilStatus;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String occupation;
    @Basic(optional = false)
    @Column(nullable = false, length = 6)
    private String gender;
    @Basic(optional = false)
    @Column(nullable = false)
    private int age;
    @Basic(optional = false)
    @Column(nullable = false)
    private long philhealth;
    @Basic(optional = false)
    @Column(nullable = false)
    private long sss;
    @Basic(optional = false)
    @Column(nullable = false)
    private long gsis;
    @Basic(optional = false)
    @Column(name = "insurance_no", nullable = false)
    private int insuranceNo;
    @Basic(optional = false)
    @Column(name = "doctor_id", nullable = false)
    private int doctorId;
    @Basic(optional = false)
    @Column(name = "contact_person_id", nullable = false)
    private int contactPersonId;
    @Basic(optional = false)
    @Column(name = "contact_id", nullable = false)
    private int contactId;
    @Basic(optional = false)
    @Column(name = "address_id", nullable = false)
    private int addressId;

    public Patient() {
    }

    public Patient(Integer patientId) {
        this.patientId = patientId;
    }

    public Patient(Integer patientId, String firstname, String lastname, String middlename, Date birthdate, String birthplace, String nationality, String civilStatus, String occupation, String gender, int age, long philhealth, long sss, long gsis, int insuranceNo, int doctorId, int contactPersonId, int contactId, int addressId) {
        this.patientId = patientId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.birthdate = birthdate;
        this.birthplace = birthplace;
        this.nationality = nationality;
        this.civilStatus = civilStatus;
        this.occupation = occupation;
        this.gender = gender;
        this.age = age;
        this.philhealth = philhealth;
        this.sss = sss;
        this.gsis = gsis;
        this.insuranceNo = insuranceNo;
        this.doctorId = doctorId;
        this.contactPersonId = contactPersonId;
        this.contactId = contactId;
        this.addressId = addressId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhilhealth() {
        return philhealth;
    }

    public void setPhilhealth(long philhealth) {
        this.philhealth = philhealth;
    }

    public long getSss() {
        return sss;
    }

    public void setSss(long sss) {
        this.sss = sss;
    }

    public long getGsis() {
        return gsis;
    }

    public void setGsis(long gsis) {
        this.gsis = gsis;
    }

    public int getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(int insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getContactPersonId() {
        return contactPersonId;
    }

    public void setContactPersonId(int contactPersonId) {
        this.contactPersonId = contactPersonId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.patientId == null && other.patientId != null) || (this.patientId != null && !this.patientId.equals(other.patientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.Patient[ patientId=" + patientId + " ]";
    }
    
    public void register(Address address, Contact contact, ContactPerson contactPerson){
        //Patient patient = new Patient();
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;        
                
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
            
            String sql = "insert into patient (firstname,lastname, middlename,birthdate,"
                    + "birthplace, nationality, civil_status,occupation, gender, age,"
                    + "philhealth, sss, gsis)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            preparedStatement=connection.prepareStatement(sql);
                        
            preparedStatement.setString(1, this.getFirstname());
            preparedStatement.setString(2, this.getLastname());
            preparedStatement.setString(3, this.getMiddlename());
            preparedStatement.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(this.getBirthdate()));
            preparedStatement.setString(5, this.getBirthplace());
            preparedStatement.setString(6, this.getNationality());
            preparedStatement.setString(7, this.getCivilStatus());
            preparedStatement.setString(8, this.getOccupation());
            preparedStatement.setString(9, this.getGender());
            preparedStatement.setInt(10, this.getAge());
            preparedStatement.setInt(11, (int) this.getPhilhealth());
            preparedStatement.setInt(12, (int)  this.getSss());
            preparedStatement.setInt(13, (int) this.getGsis());
            
            preparedStatement.execute();
            //JOptionPane.showMessageDialog(this, (jd_birthdate.getDate().getYear()+118)+","+jd_birthdate.getDate().getMonth()+","+jd_birthdate.getDate().getDate()+","+jd_birthdate.getDate().getTimezoneOffset()+"\n"+jd_birthdate.getDate());
            JOptionPane.showMessageDialog(null,"Patient Saved");
            
            sql = "SELECT patient_id FROM patient ORDER BY patient_id DESC LIMIT 1";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                this.patientId = resultSet.getInt(1);
                address.register(patientId, address);
                contact.register(patientId, contact);
                contactPerson.register(patientId, contactPerson);
            }                       
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Connection Failed!!!");
        }        
    }
    
}
