/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.candlelabs.soast.webservice;

import com.candlelabs.soast.service.CirculationService;
import com.candlelabs.soast.service.PeopleService;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Max
 */
@WebService(serviceName = "JefeDepartamento")
public class JefeDepartamento {

    private final PeopleService peopleService = new PeopleService();
        
    @WebMethod(operationName = "valida")
    public boolean valida(@WebParam(name = "idPersona") Long idPersona) {
        
        return Math.random() < 0.5;
    }
}
