package managers;

import entities.Course;
import managers.abstracts.AbstractBaseManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseManager  extends AbstractBaseManager<Course> {
    static boolean isSet = false;
    private static List<Course> coursesList = new ArrayList<>(); // Databasede tutulan öğretim üyesi listesini simüle eder

    public CourseManager(){
        LecturerManager lecturerManager = new LecturerManager();

        if (!isSet){
            Course prog,mat,dvs;
            prog = new Course("prog","programlama",0);
            prog.setInstructor(lecturerManager.getById(1));
            mat = new Course("mat","Matematik",0);
            mat.setInstructor(lecturerManager.getById(2));
            dvs = new Course("dvs","Devreler ve Sistemler",0);
            dvs.setInstructor(lecturerManager.getById(1));
            add(prog);
            add(mat);
            add(dvs);

            System.out.println(lecturerManager.getById(1).getCourses().get(1));
            isSet = true;
        }
    }

    @Override // Öğretim üyesi ekler
    public void add(Course course) {
        coursesList.add(course);
        System.out.println("Course added successfully: " + course.getCourseName());

    }

    @Override // Öğretim üyesi çıkarır
    public void delete(long id) {
        boolean removed = coursesList.removeIf(Course -> Course.getId() == id);
        if (removed) {
            System.out.println("Course with id \"" + id + "\" is removed.");
        }
        else {

            System.out.println("Course with id " + id + " not found.");
        }
    }

    @Override // Öğretim üyesinin bilgilerini günceller
    public void update(Course updatedCourse) {
        for (int i = 0; i < coursesList.size(); i++) {
            if (coursesList.get(i).getId() == updatedCourse.getId()) {
                coursesList.set(i, updatedCourse);
                System.out.println("The Course successfully updated: " + updatedCourse.getId());
                return;
            }
        }

        System.out.println("The Course not found: " + updatedCourse.getId());
    }

    @Override // Öğretim üyelerinin listesini döndürür
    public List<Course> getAll() {
        return coursesList;
    }

    @Override // Id'sine göre öğretim üyesi objesi döndürür
    public Course getById(long id) {
        return coursesList.stream().filter(Course -> Course.getId() == id)
                .findFirst().orElse(null);

    }

    @Override // Girilen isme sahip derslerin listesini döndürür
    public List<Course> getByName(String name) {
        return coursesList.stream().filter(Course -> Course.getCourseName().equalsIgnoreCase(name)).collect(Collectors.toList());

    }

    // Bu managere özel metotlar VVVVVVV
    public Course getByCourseCode(String code){
        return coursesList.stream().filter(Course -> Course.getCourseCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }
}

