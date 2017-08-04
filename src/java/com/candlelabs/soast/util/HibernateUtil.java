package com.candlelabs.soast.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author VakSF
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    
    
    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            
            System.out.println("Error: " + ex.toString());
            
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
