package Managers;

import Entities.Course;
import Entities.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseManager implements IBaseManager<Course> {

    private static List<Course> coursesList = new ArrayList<>(); // Databasede tutulan öğretim üyesi listesini simüle eder

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

