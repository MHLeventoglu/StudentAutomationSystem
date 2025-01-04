package entities;

import java.util.ArrayList;
import java.util.List;

public class Course extends BaseEntity {
    static long lastId = 0;
    private String courseCode;
    private String courseName;
    private int credit;
    private Lecturer instructor = null;
    private List<Student> students;
    public  boolean hasInstructor = false;

    //Farklı ihtiyaçlar için 3 farklı constructor
    public Course(String courseCode, String courseName, int credit) {
        super(++lastId);
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credit = credit;
        students = new ArrayList<Student>();
    }public Course(String courseCode, String courseName) {
        super(++lastId);
        this.courseCode = courseCode;
        this.courseName = courseName;
        students = new ArrayList<Student>();
    }
    public Course (String courseName){
        super();
        this.courseName = courseName;
    }


    public void setCourseCode(String courseCode) {this.courseCode = courseCode;}

    public String getCourseCode() {return courseCode;}

    public String getCourseName() {return courseName;}

    public void setCourseName(String courseName) {this.courseName = courseName;}

    public int getCredit() {return credit;}

    public void setCredit(int credit) {this.credit = credit;}

    public Lecturer getInstructor() {return instructor;}

    public void setInstructor(Lecturer instructor) {
        if(this.instructor != null){
            this.instructor.removeCourse(this.courseCode);
        }
        hasInstructor = true;
        this.instructor = instructor;
        instructor.addCourse(this);

    }

    public List<Student> getStudents() {return students;}

    public void addStudent(Student student) {this.students.add(student);}

    public void removeStudent(Student student){this.students.remove(student);}

    @Override
    public String toString(){
        return " Ders kokdu: " + this.getCourseCode() + "  /  Ders adı: " + this.courseName + "  /  Kredi: " + this.credit;
    }
}

