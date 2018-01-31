/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DelaTorreNelson
 */
@Entity
@Table(catalog = "hospital", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insurance.findAll", query = "SELECT i FROM Insurance i")
    , @NamedQuery(name = "Insurance.findByInsuranceNo", query = "SELECT i FROM Insurance i WHERE i.insuranceNo = :insuranceNo")
    , @NamedQuery(name = "Insurance.findByInsuranceName", query = "SELECT i FROM Insurance i WHERE i.insuranceName = :insuranceName")
    , @NamedQuery(name = "Insurance.findByInsuredFirstname", query = "SELECT i FROM Insurance i WHERE i.insuredFirstname = :insuredFirstname")
    , @NamedQuery(name = "Insurance.findByInsuredLastname", query = "SELECT i FROM Insurance i WHERE i.insuredLastname = :insuredLastname")
    , @NamedQuery(name = "Insurance.findByInsuredMiddlename", query = "SELECT i FROM Insurance i WHERE i.insuredMiddlename = :insuredMiddlename")
    , @NamedQuery(name = "Insurance.findByInsuredBirthdate", query = "SELECT i FROM Insurance i WHERE i.insuredBirthdate = :insuredBirthdate")
    , @NamedQuery(name = "Insurance.findByInsuredRelationship", query = "SELECT i FROM Insurance i WHERE i.insuredRelationship = :insuredRelationship")
    , @NamedQuery(name = "Insurance.findByInsuranceCompanyName", query = "SELECT i FROM Insurance i WHERE i.insuranceCompanyName = :insuranceCompanyName")
    , @NamedQuery(name = "Insurance.findByInsuranceZip", query = "SELECT i FROM Insurance i WHERE i.insuranceZip = :insuranceZip")
    , @NamedQuery(name = "Insurance.findByAmmount", query = "SELECT i FROM Insurance i WHERE i.ammount = :ammount")
    , @NamedQuery(name = "Insurance.findByRemaining", query = "SELECT i FROM Insurance i WHERE i.remaining = :remaining")
    , @NamedQuery(name = "Insurance.findByCharge", query = "SELECT i FROM Insurance i WHERE i.charge = :charge")})
public class Insurance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "insurance_no", nullable = false)
    private Integer insuranceNo;
    @Basic(optional = false)
    @Column(name = "insurance_name", nullable = false, length = 20)
    private String insuranceName;
    @Basic(optional = false)
    @Column(name = "insured_firstname", nullable = false, length = 50)
    private String insuredFirstname;
    @Basic(optional = false)
    @Column(name = "insured_lastname", nullable = false, length = 50)
    private String insuredLastname;
    @Basic(optional = false)
    @Column(name = "insured_middlename", nullable = false, length = 50)
    private String insuredMiddlename;
    @Basic(optional = false)
    @Column(name = "insured_birthdate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date insuredBirthdate;
    @Basic(optional = false)
    @Column(name = "insured_relationship", nullable = false, length = 20)
    private String insuredRelationship;
    @Basic(optional = false)
    @Column(name = "insurance_company_name", nullable = false, length = 20)
    private String insuranceCompanyName;
    @Basic(optional = false)
    @Lob
    @Column(name = "insurance_address", nullable = false, length = 65535)
    private String insuranceAddress;
    @Basic(optional = false)
    @Lob
    @Column(name = "insurance_municipality", nullable = false, length = 65535)
    private String insuranceMunicipality;
    @Basic(optional = false)
    @Lob
    @Column(name = "insurance_city", nullable = false, length = 65535)
    private String insuranceCity;
    @Basic(optional = false)
    @Column(name = "insurance_zip", nullable = false)
    private int insuranceZip;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal ammount;
    @Basic(optional = false)
    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal remaining;
    @Basic(optional = false)
    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal charge;

    public Insurance() {
    }

    public Insurance(Integer insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public Insurance(Integer insuranceNo, String insuranceName, String insuredFirstname, String insuredLastname, String insuredMiddlename, Date insuredBirthdate, String insuredRelationship, String insuranceCompanyName, String insuranceAddress, String insuranceMunicipality, String insuranceCity, int insuranceZip, BigDecimal ammount, BigDecimal remaining, BigDecimal charge) {
        this.insuranceNo = insuranceNo;
        this.insuranceName = insuranceName;
        this.insuredFirstname = insuredFirstname;
        this.insuredLastname = insuredLastname;
        this.insuredMiddlename = insuredMiddlename;
        this.insuredBirthdate = insuredBirthdate;
        this.insuredRelationship = insuredRelationship;
        this.insuranceCompanyName = insuranceCompanyName;
        this.insuranceAddress = insuranceAddress;
        this.insuranceMunicipality = insuranceMunicipality;
        this.insuranceCity = insuranceCity;
        this.insuranceZip = insuranceZip;
        this.ammount = ammount;
        this.remaining = remaining;
        this.charge = charge;
    }

    public Integer getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(Integer insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getInsuredFirstname() {
        return insuredFirstname;
    }

    public void setInsuredFirstname(String insuredFirstname) {
        this.insuredFirstname = insuredFirstname;
    }

    public String getInsuredLastname() {
        return insuredLastname;
    }

    public void setInsuredLastname(String insuredLastname) {
        this.insuredLastname = insuredLastname;
    }

    public String getInsuredMiddlename() {
        return insuredMiddlename;
    }

    public void setInsuredMiddlename(String insuredMiddlename) {
        this.insuredMiddlename = insuredMiddlename;
    }

    public Date getInsuredBirthdate() {
        return insuredBirthdate;
    }

    public void setInsuredBirthdate(Date insuredBirthdate) {
        this.insuredBirthdate = insuredBirthdate;
    }

    public String getInsuredRelationship() {
        return insuredRelationship;
    }

    public void setInsuredRelationship(String insuredRelationship) {
        this.insuredRelationship = insuredRelationship;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    public String getInsuranceAddress() {
        return insuranceAddress;
    }

    public void setInsuranceAddress(String insuranceAddress) {
        this.insuranceAddress = insuranceAddress;
    }

    public String getInsuranceMunicipality() {
        return insuranceMunicipality;
    }

    public void setInsuranceMunicipality(String insuranceMunicipality) {
        this.insuranceMunicipality = insuranceMunicipality;
    }

    public String getInsuranceCity() {
        return insuranceCity;
    }

    public void setInsuranceCity(String insuranceCity) {
        this.insuranceCity = insuranceCity;
    }

    public int getInsuranceZip() {
        return insuranceZip;
    }

    public void setInsuranceZip(int insuranceZip) {
        this.insuranceZip = insuranceZip;
    }

    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount(BigDecimal ammount) {
        this.ammount = ammount;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insuranceNo != null ? insuranceNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insurance)) {
            return false;
        }
        Insurance other = (Insurance) object;
        if ((this.insuranceNo == null && other.insuranceNo != null) || (this.insuranceNo != null && !this.insuranceNo.equals(other.insuranceNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.Insurance[ insuranceNo=" + insuranceNo + " ]";
    }
    
}
