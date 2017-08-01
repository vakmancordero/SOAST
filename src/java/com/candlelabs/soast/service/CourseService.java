package com.candlelabs.soast.service;

import com.candlelabs.soast.model.Concession;
import com.candlelabs.soast.model.Course;
import com.candlelabs.soast.model.Person;
import com.candlelabs.soast.persistence.GenericDao;
import com.candlelabs.soast.persistence.dao.CourseDao;
import com.candlelabs.soast.persistence.dao.PersonDao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author VakSF
 */
public class CourseService {
    
    private GenericDao<Course, Long> courseDao;
    private GenericDao<Person, Long> personDao;

    public CourseService() {
        this.courseDao = new CourseDao();
        this.personDao = new PersonDao();
    }
    
    protected GenericDao<Course, Long> getDao() {
        return courseDao;
    }
    
    public void setDao(GenericDao<Course, Long> courseDao) {
        this.courseDao = courseDao;
    }
    
    public Integer applyForCourse(Long courseId, Long personId) {
        
        Course course = this.courseDao.read(courseId);
        Person person = this.personDao.read(personId);
        
        System.out.println(
                "Persona added to the course " 
                        + course.getName() + " - " + person.getName());
        
        course.setInscribed(course.getInscribed() + 1);
        
        this.courseDao.update(course);
        
        return course.getInscribed();
    }
    
    public List<Course> getCourses() {
        return this.courseDao.readAll();
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
