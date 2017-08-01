package com.candlelabs.soast.service;

import com.candlelabs.soast.model.Concession;
import com.candlelabs.soast.model.Person;
import com.candlelabs.soast.persistence.GenericDao;
import com.candlelabs.soast.persistence.dao.ConcessionDao;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author VakSF
 */
public class ConcessionService {
    
    private GenericDao<Concession, Long> concessionDao;

    public ConcessionService() {
        this.concessionDao = new ConcessionDao();
    }
    
    protected GenericDao<Concession, Long> getDao() {
        return concessionDao;
    }
    
    public void setDao(GenericDao<Concession, Long> concessionDao) {
        this.concessionDao = concessionDao;
    }
    
    public Long saveConcession(
            Person person, String folio, String town, 
            String concessionType, Date expeditionDate, 
            Date expirationDate, String expeditionPlace, 
            String unitType, String licensePlate) {
        
        return this.concessionDao.create(
                new Concession(
                        person, folio, town, concessionType, 
                        expeditionDate, expirationDate, expeditionPlace, 
                        unitType, licensePlate
                )
        );
    }
    
    public Concession findByName(String concessionName) {
        
        Concession concession = null;
        
        if (concessionName != null && !concessionName.isEmpty()) {
            Criteria findbyName = getDao().getSession().createCriteria(getDao().clazz());
            findbyName.add(Restrictions.eq("name", concessionName));
            concession = getDao().readUniqueByCriteria(findbyName);
        }
        
        return concession;
    }
    
}
