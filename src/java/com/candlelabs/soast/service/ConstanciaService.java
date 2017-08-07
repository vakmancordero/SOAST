package com.candlelabs.soast.service;

import com.candlelabs.soast.model.Concession;
import com.candlelabs.soast.model.Person;
import com.candlelabs.soast.persistence.dao.ConcessionDao;
import com.candlelabs.soast.persistence.dao.PersonDao;
import com.candlelabs.soast.util.MailConnection;
import java.util.Date;

/**
 *
 * @author VakSF
 */
public class ConstanciaService {
    
    private final PersonDao personDao;
    private final ConcessionDao concesionDao;

    public ConstanciaService() {
        this.personDao = new PersonDao();
        this.concesionDao = new ConcessionDao();
    }
    
    public String expedirConstancia(Long personId,Long concesionId) {
        
        Person person = this.personDao.read(personId);
        Concession concession = this.concesionDao.read(concesionId);
        
        
        Date todayDate = new Date();
        
        if(todayDate.after(concession.getExpirationDate())) {
            return "La secretaria de transportes hace constar que el ciudadano " + person.getName() + 
                " con RFC: " + person.getRfc() + " de nacionalidad " + 
                person.getNacionality() + " es posedor de la Concesión con número de folio " +
                concession.getId() +" expedida en "+ concession.getExpeditionPlace() + 
                " con vigencia hasta el " + concession.getExpirationDate().toString();
        }else{
            return "La persona por la cual este buscando una concesión no posee "
                    + "concesiones o posee alguna vencida, lo sentimos";
        }
        
        
    }
    
}
