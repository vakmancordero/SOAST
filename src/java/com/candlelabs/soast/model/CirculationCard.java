package com.candlelabs.soast.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="circulation_card", catalog="soast")
public class CirculationCard implements Serializable {

    private Long id;
    private Long personId;
    private Long vehicleId;
    private String licensePlate;
    private Date expeditionDate;
    private Date expirationDate;
    
    public CirculationCard() {
        
    }
    
    public CirculationCard(Long personId, Long vehicleId, String licensePlate, Date expeditionDate, Date expirationDate) {
        this.personId = personId;
        this.vehicleId = vehicleId;
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
    
    @Column(name="personId")
    public Long getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(Long personId) {
        this.personId = personId;
    }
    
    @Column(name="vehicleId")
    public Long getVehicleId() {
        return this.vehicleId;
    }
    
    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
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
