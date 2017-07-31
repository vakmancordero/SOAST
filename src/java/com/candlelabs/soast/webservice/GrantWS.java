package com.candlelabs.soast.webservice;

import com.candlelabs.soast.service.GrantService;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author VakSF
 */
@WebService(serviceName = "GrantWS")
public class GrantWS {
    
    private final GrantService grantService = new GrantService();

    @WebMethod(operationName = "saveGrant")
    public Long saveGrant(@WebParam(name = "name") String name) {
        return this.grantService.saveGrant(name);
    }
}
