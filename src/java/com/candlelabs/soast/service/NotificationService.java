package com.candlelabs.soast.service;

import com.candlelabs.soast.model.Person;
import com.candlelabs.soast.persistence.dao.PersonDao;
import com.candlelabs.soast.util.MailConnection;

/**
 *
 * @author VakSF
 */
public class NotificationService {
    
    private final PersonDao personDao;
    private final MailConnection mailConnection;

    public NotificationService() {
        this.personDao = new PersonDao();
        this.mailConnection = new MailConnection("", "", "smtp.gmail.com", "587");
    }
    
    public String sendMessage(Long personId, String subject, String message) {
        
        Person person = this.personDao.read(personId);
        
        this.mailConnection.sendMessage(person.getEmail(), subject, message, "html");
        
        return "Mensaje enviado a " + person.getName();
    }
    
}
