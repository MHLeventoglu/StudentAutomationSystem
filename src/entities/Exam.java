package entities;

import java.time.LocalDateTime;

public class Exam extends BaseEntity {
    private static long lastId=0;
    private long studentId;
    private String examType; // Vize, Final, Mazeret vb.
    private Course course;
    private int percentImpact; // 100 üzerinden nota etkisi
    private float point; // Sınavın yüz üzerinden puanı

    public Exam(long studentId, Course course, String examType,float point, int percentImpact) {
        super(++lastId);
        this.studentId = studentId;
        this.examType = examType;
        this.course = course;
        this.percentImpact = percentImpact;
        this.point = point;
    }

    public float getStudentId(){return this.studentId;}

    public String getExamType(){ return examType; }

    public void setExamType(String examType){ this.examType = examType; }

    public float getPoint(){ return point; }

    public void setPoint(float point){ this.point = point; }

    public Course getCourse(){ return course; }

    public void setCourse(Course course){ this.course = course; }

}
