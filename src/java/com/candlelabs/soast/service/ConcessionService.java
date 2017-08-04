package com.candlelabs.soast.service;

import com.candlelabs.soast.model.Concession;
import com.candlelabs.soast.model.Person;
import com.candlelabs.soast.persistence.GenericDao;
import com.candlelabs.soast.persistence.dao.ConcessionDao;
import com.candlelabs.soast.persistence.dao.PersonDao;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author VakSF
 */
public class ConcessionService {
    
    private GenericDao<Concession, Long> concessionDao;
    
    private GenericDao<Person, Long> personDao;
    

    public ConcessionService() {
        this.concessionDao = new ConcessionDao();
        this.personDao = new PersonDao();
    }
    
    protected GenericDao<Concession, Long> getDao() {
        return concessionDao;
    }
    
    public void setDao(GenericDao<Concession, Long> concessionDao) {
        this.concessionDao = concessionDao;
    }
    
    public Long saveConcession(
            Long idPerson, String folio, String town, 
            String concessionType, Date expeditionDate, 
            Date expirationDate, String expeditionPlace, 
            String unitType, String licensePlate) {
        
        Person person = this.personDao.read(idPerson);
        
        return this.concessionDao.create(
                new Concession(
                        person, folio, town, concessionType, 
                        expeditionDate, expirationDate, expeditionPlace, 
                        unitType, licensePlate
                )
        );
    }
    
    public boolean deleteConcession(Long idConcession) {
        return this.concessionDao.delete(
                this.concessionDao.read(idConcession)
        );
    }
    
    public List<Concession> listConcessions() {
        return this.concessionDao.readAll();
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
