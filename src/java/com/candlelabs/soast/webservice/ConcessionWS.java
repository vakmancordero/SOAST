package com.candlelabs.soast.webservice;

import com.candlelabs.soast.model.Person;
import com.candlelabs.soast.service.ConcessionService;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author VakSF
 */
@WebService(serviceName = "ConcessionWS")
public class ConcessionWS {
    
    private ConcessionService concessionService = new ConcessionService();
    
    /**
     * @param name
     * @param rfc
     * @param address
     * @param birthday
     * @param nacionality
     * @param folio
     * @param town
     * @param concessionType
     * @param expeditionDate
     * @param expirationDate
     * @param expeditionPlace
     * @param unitType
     * @param licensePlate
     * @return 
     */
    @WebMethod(operationName = "saveConcession")
    public Long saveConcession(
            
            // Person
            @WebParam(name = "name") String name,
            @WebParam(name = "rfc") String rfc,
            @WebParam(name = "address") String address,
            @WebParam(name = "birthday") Date birthday,
            @WebParam(name = "nacionality") String nacionality,
            
            // Concession
            @WebParam(name = "folio") String folio,
            @WebParam(name = "town") String town,
            @WebParam(name = "concessionType") String concessionType,
            @WebParam(name = "expeditionDate") Date expeditionDate,
            @WebParam(name = "expirationDate") Date expirationDate,
            @WebParam(name = "expeditionPlace") String expeditionPlace,
            @WebParam(name = "unitType") String unitType,
            @WebParam(name = "licensePlate") String licensePlate) {
        
        Person person = new Person(name, rfc, address, nacionality, birthday);
        
        return this.concessionService.saveConcession(
                person, folio, town, concessionType, expeditionDate, 
                expirationDate, expeditionPlace, unitType, licensePlate);
    }
    
    
    // expedicionConcesion() -> Concession
            
}
