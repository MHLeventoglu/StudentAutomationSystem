import Entities.Lecturer;
import Entities.Student;
import Entities.User;
import Managers.LecturerManager;
import Managers.StudentManager;

import java.util.List;

public class Main {


    public static void main(String[] args){
        StudentManager studentManager = new StudentManager();
        studentManager.add(new Student("isim","şifre","departman"));
        studentManager.add(new Student("isim2","şifre2","departman2"));
        List<Student> students = studentManager.getAll();
        // Print the student details
        System.out.println("All Students:");
        for (Student student : students) {
            System.out.println("ID: " + student.getId() +
                    ", Student Number: " + student.getId() +
                    ", Name: " + student.getName());
        }



        LecturerManager lecturerManager = new LecturerManager();

        // Create lecturers
        Lecturer lecturer1 = new Lecturer(1L, "JohnSmith", "password123", "Computer Science");
        Lecturer lecturer2 = new Lecturer(2L, "JaneDoe", "password456", "Mathematics");

        // Add lecturers to the manager
        lecturerManager.add(lecturer1);
        lecturerManager.add(lecturer2);

        // Retrieve all lecturers
        List<Lecturer> lecturers = lecturerManager.getAll();

        // Print the details of all lecturers
        System.out.println("All Lecturers:");
        for (Lecturer lecturer : lecturers) {
            System.out.println("ID: " + lecturer.getId() +
                    ", Name: " + lecturer.getName() +
                    ", Faculty: " + lecturer.getFaculty());
        }

        // Find a lecturer by name
        List<Lecturer> foundLecturers = lecturerManager.getByName("JaneDoe");
        if (!foundLecturers.isEmpty()) {
            System.out.println("\nLecturer found: ");
            for (Lecturer foundLecturer : foundLecturers) {
                System.out.println("ID: " + foundLecturer.getId() +
                        ", Name: " + foundLecturer.getName() +
                        ", Faculty: " + foundLecturer.getFaculty());
            }
        }

        List<User> allUsers = lecturerManager.getAllUsers();
        if (!foundLecturers.isEmpty()) {
            System.out.println("\nLecturer found: ");
            for (User user : allUsers) {
                System.out.println("ID: " + user.getUserId() +
                        ", Name: " + user.getName());
            }
        }
    }
}
