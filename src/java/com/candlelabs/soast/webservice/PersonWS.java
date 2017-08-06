package com.candlelabs.soast.webservice;

import com.candlelabs.soast.model.Person;
import com.candlelabs.soast.service.PeopleService;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Max
 */
@WebService(serviceName = "PersonWS")
public class PersonWS {

    private final PeopleService personService = new PeopleService();
    
    @WebMethod(operationName = "createPerson")
    public Long createPerson(
            
            @WebParam(name = "name") String name,
            @WebParam(name = "rfc") String rfc,
            @WebParam(name = "address") String address,
            @WebParam(name = "nacionality") String nationality,
            @WebParam(name = "birthday") Date birthday,
            @WebParam(name = "email") String email,
            @WebParam(name = "cellphone") String cellphone) {
        
        Person person = new Person(name, rfc, address, nationality, birthday, email, cellphone);
        return this.personService.createPerson(person);
    }
    
    @WebMethod(operationName = "deletePerson")
    public boolean deletePerson(@WebParam(name = "personId") Long personId) {
        return this.personService.deletePerson(personId);
    }
    
    @WebMethod(operationName = "listPersons")
    public List<Person> listPersons() {
        return this.personService.listPersons();
    }
    
}
