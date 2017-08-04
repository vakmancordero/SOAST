package com.candlelabs.soast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle  implements java.io.Serializable {
    
    private Long id;
    private String brand;
    private String model;
    private Integer cilinders;
    private Integer litters;
    private Integer capacity;
    private Double tons;
    
    public Vehicle() {
        
    }
    
    public Vehicle(String brand, String model, Integer cilinders, Integer litters, Integer capacity, Double tons) {
        this.brand = brand;
        this.model = model;
        this.cilinders = cilinders;
        this.litters = litters;
        this.capacity = capacity;
        this.tons = tons;
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
    
    @Column(name="brand")
    public String getBrand() {
        return this.brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    @Column(name="model")
    public String getModel() {
        return this.model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    @Column(name="cilinders")
    public Integer getCilinders() {
        return this.cilinders;
    }
    
    public void setCilinders(Integer cilinders) {
        this.cilinders = cilinders;
    }
    
    
    @Column(name="litters")
    public Integer getLitters() {
        return this.litters;
    }
    
    public void setLitters(Integer litters) {
        this.litters = litters;
    }
    
    @Column(name="capacity")
    public Integer getCapacity() {
        return this.capacity;
    }
    
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    
    @Column(name="tons", precision=22, scale=0)
    public Double getTons() {
        return this.tons;
    }
    
    public void setTons(Double tons) {
        this.tons = tons;
    }
    
}
