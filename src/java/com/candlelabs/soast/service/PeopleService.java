package com.candlelabs.soast.service;

import com.candlelabs.soast.model.Person;
import com.candlelabs.soast.persistence.GenericDao;
import com.candlelabs.soast.persistence.dao.PersonDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author VakSF
 */
public class PeopleService {
    
    private GenericDao<Person, Long> personDao;

    public PeopleService() {
        this.personDao = new PersonDao();
    }
    
    protected GenericDao<Person, Long> getDao() {
        return personDao;
    }
    
    public void setDao(GenericDao<Person, Long> personDao) {
        this.personDao = personDao;
    }
      
    public Person findByName(String personName) {
        
        Person person = null;
        
        if (personName != null && !personName.isEmpty()) {
            Criteria findbyName = getDao().getSession().createCriteria(getDao().clazz());
            findbyName.add(Restrictions.eq("name", personName));
            person = getDao().readUniqueByCriteria(findbyName);
        }
        
        return person;
    }
    
    public Long createPerson(Person person){
        
        return this.personDao.create(person);
        
    }
    
}
