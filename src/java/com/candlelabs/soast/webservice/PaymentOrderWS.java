package com.candlelabs.soast.webservice;

import com.candlelabs.soast.model.Payment;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author VakSF
 */
@WebService(serviceName = "PaymentOrderWS")
public class PaymentOrderWS {
    
    @WebMethod(operationName = "generatePaymentOrder")
    public Payment generatePaymentOrder(
            @WebParam(name = "paymentType") String paymentType) {
        
        Payment payment = new Payment(0, "Banamex", "01237482374987234");
        
        if (paymentType.equals("constancia")) {
            
            payment.setAmount(200);
            
        } else if (paymentType.equals("reposicion")) {
            
            payment.setAmount(300);
            
        } else if (paymentType.equals("curso")) {
            
            payment.setAmount(500);
            
        } else if (paymentType.equals("other")) {
            
            payment.setAmount(20);
            
        }
        
        return payment;
    }
}
