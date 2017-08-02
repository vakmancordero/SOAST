package com.candlelabs.soast.webservice;

import com.candlelabs.soast.model.CirculationCard;
import com.candlelabs.soast.service.CirculationService;
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
}
