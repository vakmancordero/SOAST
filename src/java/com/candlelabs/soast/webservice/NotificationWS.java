package com.candlelabs.soast.webservice;

import com.candlelabs.soast.service.NotificationService;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author VakSF
 */
@WebService(serviceName = "NotificationWS")
public class NotificationWS {
    
    private NotificationService notificationService = new NotificationService();
    
    @WebMethod(operationName = "sendNotification")
    public String sendNotification(
            @WebParam(name = "personId") Long personId,
            @WebParam(name = "subject") String subject,
            @WebParam(name = "message") String message) {
        
        return this.notificationService.sendMessage(
                personId, subject, message);
    }
}
