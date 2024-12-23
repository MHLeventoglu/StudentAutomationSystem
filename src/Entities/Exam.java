package Entities;

import java.time.LocalDateTime;

public class Exam extends BaseEntity {
    private String examType; // Vize, Final vb.
    private LocalDateTime examDate;
    private Course course;
    private int percentImpact; // 100 üzerinden nota etkisi

    public Exam(long id) {
        super(id);
    }


    // Getters and Setters
    public String getExamType(){ return examType; }

    public void setExamType(String examType){ this.examType = examType; }

    public LocalDateTime getExamDate(){ return examDate; }

    public void setExamDate(LocalDateTime examDate){ this.examDate = examDate; }

    public Course getCourse(){ return course; }

    public void setCourse(Course course){ this.course = course; }

}
