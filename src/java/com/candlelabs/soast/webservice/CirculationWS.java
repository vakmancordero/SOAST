package com.candlelabs.soast.webservice;

import com.candlelabs.soast.model.CirculationCard;
import com.candlelabs.soast.model.Person;
import com.candlelabs.soast.model.Vehicle;
import com.candlelabs.soast.service.CirculationService;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author VakSF
 */
@WebService(serviceName = "CirculationWS")
public class CirculationWS {
    
    private final CirculationService circulationService = new CirculationService();
    
    @WebMethod(operationName = "recoverCard")
    public CirculationCard recoverCard(@WebParam(name = "cardId") Long cardId) {
        return this.circulationService.recoverCard(cardId);
    }

    
    @WebMethod(operationName = "createCard")
    public Long createCard(
            @WebParam(name = "idPerson") Long personId,
            @WebParam(name = "vehicleId") Long vehicleId,
            @WebParam(name = "licensePlate") String licensePlate,
            @WebParam(name = "expeditionDate") Date expeditionDate,
            @WebParam(name = "expirationDate") Date expirationDate

    ) {
        
        return this.circulationService.saveCard(personId, vehicleId, 
                licensePlate, expeditionDate, expirationDate);
    }
}
