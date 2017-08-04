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
@Table(name="circulation_card")
public class CirculationCard implements Serializable {

    private Long id;
    private Person person;
    private Vehicle vehicle;
    private String licensePlate;
    private Date expeditionDate;
    private Date expirationDate;
    
    public CirculationCard() {
        
    }
    
    public CirculationCard(Person person, Vehicle vehicle, String licensePlate, 
            Date expeditionDate, Date expirationDate) {
        this.person = person;
        this.vehicle = vehicle;
        this.licensePlate = licensePlate;
        this.expeditionDate = expeditionDate;
        this.expirationDate = expirationDate;
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
    public Person getPersonId() {
        return this.person;
    }
    
    public void setPersonId(Person personId) {
        this.person = personId;
    }
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "vehicleId")
    public Vehicle getVehicleId() {
        return this.vehicle;
    }
    
    public void setVehicleId(Vehicle vehicleId) {
        this.vehicle = vehicleId;
    }
    
    @Column(name="licensePlate")
    public String getLicensePlate() {
        return this.licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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
    
}
