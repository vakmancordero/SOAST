package com.candlelabs.soast.service;

import com.candlelabs.soast.model.CirculationCard;
import com.candlelabs.soast.model.Concession;
import com.candlelabs.soast.model.Person;
import com.candlelabs.soast.model.Vehicle;
import com.candlelabs.soast.persistence.GenericDao;
import com.candlelabs.soast.persistence.dao.CirculationCardDao;
import java.util.Date;
import java.util.List;
import javax.jws.WebParam;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author VakSF
 */
public class CirculationService {
    
    private GenericDao<CirculationCard, Long> circulationCardDao;
    private GenericDao<Person, Long> personDao;
    private GenericDao<Vehicle, Long> vehicleDao;


    
    public Long createCard(CirculationCard card){
        
        return this.circulationCardDao.create(card);
        
    }

    public CirculationService() {
        this.circulationCardDao = new CirculationCardDao();
    }
    
    protected GenericDao<CirculationCard, Long> getDao() {
        return circulationCardDao;
    }
    
    public void setDao(GenericDao<CirculationCard, Long> dao) {
        this.circulationCardDao = dao;
    }
    
    public CirculationCard recoverCard(Long cardId) {
        return this.circulationCardDao.read(cardId);
    }
    
    public List<CirculationCard> getCirculationCards() {
        return this.circulationCardDao.readAll();
    }
    
    public Long saveCard(
            Long personId, Long vehicleId, String licensePlate, 
            Date expeditionDate, Date expirationDate) {
        
        Person person = this.personDao.read(personId);
        Vehicle vehicle = this.vehicleDao.read(vehicleId);
        
        return this.circulationCardDao.create(
                new CirculationCard(person, vehicle, licensePlate, expeditionDate, expirationDate)
        );
    }
    
    public CirculationCard findByName(String circulationCardName) {
        
        CirculationCard circulationCard = null;
        
        if (circulationCardName != null && !circulationCardName.isEmpty()) {
            Criteria findbyName = getDao().getSession().createCriteria(getDao().clazz());
            findbyName.add(Restrictions.eq("name", circulationCardName));
            circulationCard = getDao().readUniqueByCriteria(findbyName);
        }
        
        return circulationCard;
    }
    
}
