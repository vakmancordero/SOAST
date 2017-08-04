package com.candlelabs.soast.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="concession")
public class Concession  implements Serializable {
    
    private Long id;
    private Person person;
    private String folio;
    private String town;
    private String concessionType;
    private Date expeditionDate;
    private Date expirationDate;
    private String expeditionPlace;
    private String unitType;
    private String licensePlate;
    
    public Concession() {
        
    }
    
    public Concession(Person person, String folio, String town, String concessionType, Date expeditionDate, Date expirationDate, String expeditionPlace, String unitType, String licensePlate) {
        this.person = person;
        this.folio = folio;
        this.town = town;
        this.concessionType = concessionType;
        this.expeditionDate = expeditionDate;
        this.expirationDate = expirationDate;
        this.expeditionPlace = expeditionPlace;
        this.unitType = unitType;
        this.licensePlate = licensePlate;
    }
    
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "person_id")
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person personId) {
        this.person = personId;
    }
    
    @Column(name="folio")
    public String getFolio() {
        return this.folio;
    }
    
    public void setFolio(String folio) {
        this.folio = folio;
    }
    
    @Column(name="town")
    public String getTown() {
        return this.town;
    }
    
    public void setTown(String town) {
        this.town = town;
    }
    
    @Column(name="concessionType")
    public String getConcessionType() {
        return this.concessionType;
    }
    
    public void setConcessionType(String concessionType) {
        this.concessionType = concessionType;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="expeditionDate", length=19)
    public Date getExpeditionDate() {
        return this.expeditionDate;
    }
    
    public void setExpeditionDate(Date expeditionDate) {
        this.expeditionDate = expeditionDate;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="expirationDate", length=19)
    public Date getExpirationDate() {
        return this.expirationDate;
    }
    
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    @Column(name="expeditionPlace")
    public String getExpeditionPlace() {
        return this.expeditionPlace;
    }
    
    public void setExpeditionPlace(String expeditionPlace) {
        this.expeditionPlace = expeditionPlace;
    }
    
    @Column(name="unitType")
    public String getUnitType() {
        return this.unitType;
    }
    
    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
    
    @Column(name="licensePlate")
    public String getLicensePlate() {
        return this.licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

}
