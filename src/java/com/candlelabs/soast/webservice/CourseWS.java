package com.candlelabs.soast.webservice;

import com.candlelabs.soast.model.Course;
import com.candlelabs.soast.service.CourseService;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author VakSF
 */
@WebService(serviceName = "CourseWS")
public class CourseWS {
    
    private final CourseService courseService = new CourseService();
    
    @WebMethod(operationName = "applyForCourse")
    public Integer applyForCourse(
            @WebParam(name = "courseId") Long courseId,
            @WebParam(name = "personId") Long personId) {
        
        return this.courseService.applyForCourse(courseId, personId);
    }

    @WebMethod(operationName = "listCourses")
    public List<Course> listCourses() {
        return this.courseService.getCourses();
    }
    
}
