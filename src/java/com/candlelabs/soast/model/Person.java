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
@Table(name="person", catalog="soast")
public class Person implements Serializable {
    
    private Long id;
    private String name;
    private String rfc;
    private String address;
    private String nacionality;
    private Date birthday;
    private String email;
    private String cellphone;
    
    public Person() {
        
    }
    
    public Person(String name, String rfc, String address, String nacionality, Date birthday) {
        this.name = name;
        this.rfc = rfc;
        this.address = address;
        this.nacionality = nacionality;
        this.birthday = birthday;
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
    
    @Column(name="rfc")
    public String getRfc() {
        return this.rfc;
    }
    
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    
    @Column(name="address")
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    
    @Column(name="nacionality")
    public String getNacionality() {
        return this.nacionality;
    }
    
    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="birthday", length=19)
    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="cellphone")
    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

}