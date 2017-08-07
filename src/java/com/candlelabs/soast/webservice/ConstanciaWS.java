/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.candlelabs.soast.webservice;

import com.candlelabs.soast.service.ConstanciaService;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Max
 */
@WebService(serviceName = "ConstanciaWS")
public class ConstanciaWS {
    
    private final ConstanciaService expedirConstacia = new ConstanciaService();
    
    @WebMethod(operationName = "expedirConstancia")
    public String expedirConstancia(
            @WebParam(name = "idPerson") Long idPerson,
            @WebParam(name = "idConcesion") Long idConcesion) {
        
        return this.expedirConstacia.expedirConstancia(idPerson, idConcesion);
    }
}
