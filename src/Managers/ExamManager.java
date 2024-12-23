package Managers;

import Entities.Exam;
import Entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExamManager implements IBaseManager<Exam> {
    private static List<Exam> examsList = new ArrayList<Exam>(); //öğrencileri tutan database'i simüle eder

    @Override
    public void add(Exam object) {
        examsList.add(object);
        System.out.println("Student added successfully: " + object.getId());
    }

    @Override
    public void delete(long id) {
        boolean isRemoved = examsList.removeIf(exam -> exam.getId()==id);
        if (isRemoved) {
            System.out.println("Exam with id " + id + " is removed.");
        } else {
            System.out.println("Exam with id " + id + " not found.");
        }
    }

    @Override
    public void update(Exam object) {
        for (int i = 0; i < examsList.size(); i++) {
            if (examsList.get(i).getId()==object.getId()) {
                examsList.set(i, object);
                System.out.println("Student updated successfully: " + object.getId());
                return;
            }
        }
        System.out.println("Student with this id not found!: "+object.getId());
    }

    @Override
    public List<Exam> getAll() {
        return examsList;
    }

    @Override
    public Exam getById(long id) {
        return examsList.stream().filter(Course -> Course.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public List<Exam> getByName(String courseName) {
        return examsList.stream()
                .filter(exam -> exam.getCourse().getCourseName().equalsIgnoreCase(courseName))
                .collect(Collectors.toList());
    }

    // Class'a özel metotlar aşağıdadır

    public List<Exam> getByStudenId(long studentId) {
        return examsList.stream()
                .filter(exam -> exam.getStudentId() == studentId)
                .collect(Collectors.toList());
    }



}
