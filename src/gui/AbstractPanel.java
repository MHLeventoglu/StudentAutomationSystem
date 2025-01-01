package gui;

import controllers.StudentController;
import entities.Student;
import managers.CourseManager;
import managers.ExamManager;
import managers.LecturerManager;
import managers.StudentManager;
import controllers.UserController;

import javax.swing.*;

public abstract class AbstractPanel extends JPanel {
    public static UserController userController = new UserController();
    public static StudentManager studentManager = new StudentManager();
    public static LecturerManager lecturerManager = new LecturerManager();
    public static CourseManager courseManager = new CourseManager();
    public static ExamManager examManager = new ExamManager();
    public static StudentController studentController = new StudentController();
    static boolean isSet = false;

    public AbstractPanel(){
        if(!isSet){
            for (Student x:studentManager.getAll()){
                studentController.enrollCourse(x,"prog");
            }
            isSet = true;
        }
    }

}
