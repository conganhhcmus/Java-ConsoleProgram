package conganh.hcmus;

import java.io.Serializable;

public abstract class Student implements Serializable {
    protected int studentID;
    protected String fullName;
    protected String address;
    protected String prioritize;

    public Student(int studentID, String fullName, String address, String prioritize) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.address = address;
        this.prioritize = prioritize;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrioritize() {
        return prioritize;
    }

    public void setPrioritize(String prioritize) {
        this.prioritize = prioritize;
    }

    @Override
    public abstract String toString();
}
