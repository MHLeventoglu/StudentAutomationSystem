package controllers;

import controllers.abstracts.AbstractUserController;
import entities.Course;
import entities.Student;
import managers.CourseManager;

public class StudentController extends AbstractUserController {
    static CourseManager courseManager = new CourseManager();
    public void enrollCourse(Student student,String courseCode){
        Course course = courseManager.getByCourseCode(courseCode);
        student.addEnrolledCourse(course);
    }
    public void removeCourse(Student student, String courseCode){
        Course course = courseManager.getByCourseCode(courseCode);
        student.removeEnrolledCourse(courseCode);
    }
    
}
