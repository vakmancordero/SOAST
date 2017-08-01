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
@Table(name="course", catalog="soast")
public class Course implements Serializable {

    private Long id;
    private String name;
    private String place;
    private String area;
    private Date startDate;
    private Date endDate;
    private Integer inscribed;
    
    public Course() {
        
    }
    
    public Course(String name, String place, String area, Date startDate, Date endDate) {
        this.name = name;
        this.place = place;
        this.area = area;
        this.startDate = startDate;
        this.endDate = endDate;
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
    
    @Column(name="name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="place")
    public String getPlace() {
        return this.place;
    }
    
    public void setPlace(String place) {
        this.place = place;
    }
    
    @Column(name="area")
    public String getArea() {
        return this.area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="startDate", length=19)
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="endDate", length=19)
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    @Column(name="inscribed")
    public Integer getInscribed() {
        return inscribed;
    }

    public void setInscribed(Integer inscribed) {
        this.inscribed = inscribed;
    }

}
