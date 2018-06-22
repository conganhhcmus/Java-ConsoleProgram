package conganh.hcmus;

import java.io.Serializable;

public class StudentRecord implements Serializable,Comparable<StudentRecord>{
    private String classRoom;
    private String course;
    private String semester;
    private Student student;

    public StudentRecord(String classRoom, String course, String semester, Student student) {
        this.classRoom = classRoom;
        this.course = course;
        this.semester = semester;
        this.student = student;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return student.toString() +
                "\nClass Room: " + classRoom +
                "\nCourse: " + course +
                "\nSemester: " + semester;
    }

    @Override
    public int compareTo(StudentRecord o) {
        return this.student.getFullName().compareToIgnoreCase(o.student.getFullName());
    }
}
