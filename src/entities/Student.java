package entities;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    static long lastId = 0;
    private String department;
    private String faculty;
    private List<Course> enrolledCourses; // Öğrencinin kayıtlı dersleri

    public Student(String username, String password, String department, String mail) {
        super(++lastId, new String(username), new String(password), "Ogrenci",new String(mail));
        this.department = department;
        enrolledCourses = new ArrayList<Course>();
    }
    // Aynı zamanda Aggregation'ın "has a .." ilişkisini kullanmış olduk


    public String getDepartment(){ return department; }

    public void setDepartment(String department){ this.department = department; }

    public List<Course> getEnrolledCourses(){ return enrolledCourses; }

    public void addEnrolledCourse(Course course){
        boolean exist = false;
        for (Course a : enrolledCourses) {
            if (a.getCourseCode() == course.getCourseCode()) {
                exist = true;
                break;
            }
        }
        if (exist == false) {
            this.enrolledCourses.add(course);
            course.addStudent(this);
        }else
            System.out.println("This course is already exist");

    }
    public void removeEnrolledCourse(String courseCode){
        for(Course a: enrolledCourses){
            if (a.getCourseCode() == courseCode){
                enrolledCourses.remove(a);
                a.removeStudent(this);
                break;
            }
        }

    }

}
