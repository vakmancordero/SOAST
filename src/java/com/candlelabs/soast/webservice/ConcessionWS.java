package com.candlelabs.soast.webservice;

import com.candlelabs.soast.model.Concession;
import com.candlelabs.soast.service.ConcessionService;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author VakSF
 */
@WebService(serviceName = "ConcessionWS")
public class ConcessionWS {
    
    private final ConcessionService concessionService = new ConcessionService();
    
    /**
     * @param idPerson
     * @param town
     * @param concessionType
     * @param expeditionDate
     * @param expirationDate
     * @param expeditionPlace
     * @param unitType
     * @param licensePlate
     * @return 
     */
    @WebMethod(operationName = "createConcession")
    public Long createConcession(
            //Person
            @WebParam(name = "idPerson") Long idPerson,
            // ConcessionS
            @WebParam(name = "town") String town,
            @WebParam(name = "concessionType") String concessionType,
            @WebParam(name = "expeditionDate") Date expeditionDate,
            @WebParam(name = "expirationDate") Date expirationDate,
            @WebParam(name = "expeditionPlace") String expeditionPlace,
            @WebParam(name = "unitType") String unitType,
            @WebParam(name = "licensePlate") String licensePlate) {
        
        return this.concessionService.saveConcession(
                idPerson, town, concessionType, expeditionDate, 
                expirationDate, expeditionPlace, unitType, licensePlate);
    }
    
    @WebMethod(operationName = "deleteConcession")
    public boolean deleteConcession(
            @WebParam(name = "idConcession") Long idConcession) {
        
        return this.concessionService.deleteConcession(idConcession);
    }
    
    @WebMethod(operationName = "listConcession")
    public List<Concession> listConcessions() {
        return this.concessionService.listConcessions();
    }
    
}
