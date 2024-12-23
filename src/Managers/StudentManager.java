package Managers;

import Entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManager implements IBaseManager<Student> {

    private final List<Student> studentsList = new ArrayList<>(); //öğrencileri tutan database'i simüle eder

    @Override //Örenci ekler
    public void add(Student student) {
        studentsList.add(student);
        System.out.println("Student added successfully: " + student.getId());
    }

    @Override// Öğrenci siler
    public void delete(long id) {
        boolean isRemoved = studentsList.removeIf(student -> student.getId()==id);
        if (isRemoved) {
            System.out.println("Student with id " + id + " is removed.");
        } else {
            System.out.println("Student with id " + id + " not found.");
        }
    }

    @Override //Öğrenci günceller
    public void update(Student studentToUpdate) {
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getId()==studentToUpdate.getId()) {
                studentsList.set(i, studentToUpdate);
                System.out.println("Student updated successfully: " + studentToUpdate.getId());
                return;
            }
        }
        System.out.println("Student with this id not found!: "+studentToUpdate.getId());
    }

    @Override // Öğrenci listesini döndürür
    public List<Student> getAll() {
        return studentsList;

    }

    @Override // Id sine göre öğrenci objesini döner
    public Student getById(long id) {
        return studentsList.stream()
                .filter(student -> student.getId()==id)
                .findFirst()
                .orElse(null);

    }

    @Override // Adına göre öğrencileri listeler
    public List<Student> getByName(String name) {
        return studentsList.stream()
                .filter(student -> student.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}

