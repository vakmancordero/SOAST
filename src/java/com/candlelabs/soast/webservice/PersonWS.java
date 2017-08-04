/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.candlelabs.soast.webservice;

import com.candlelabs.soast.model.Person;
import com.candlelabs.soast.service.PeopleService;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Max
 */
@WebService(serviceName = "PersonWS")
public class PersonWS {

    private PeopleService personService = new PeopleService();

       private Long id;
    private String name;
    private String rfc;
    private String address;
    private String nacionality;
    private Date birthday;
    private String email;
    private String cellphone;
    
    
    @WebMethod(operationName = "createPerson")
    public Long createPerson(
            
            @WebParam(name = "name") String name,
            @WebParam(name = "rfc") String rfc,
            @WebParam(name = "address") String address,
            @WebParam(name = "nacionality") String nationality,
            @WebParam(name = "birthday") Date birthday,
            @WebParam(name = "email") String email,
            @WebParam(name = "cellphone") String cellphone) {
        
        Person person = new Person(name, rfc, address, nacionality, birthday);
        //System.out.println(birthday);
        return this.personService.createPerson(person);
    }
}
