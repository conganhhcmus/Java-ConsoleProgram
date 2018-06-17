package conganh.hcmus;

import java.io.Serializable;

public class Person implements Serializable {
    private String fullName;
    private int age;
    private int yearOfBirth;
    private String job;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Person(String fullName, int age, int yearOfBirth, String job) {

        this.fullName = fullName;
        this.age = age;
        this.yearOfBirth = yearOfBirth;
        this.job = job;
    }

    @Override
    public String toString() {
        return "\nFull Name: " + fullName +
                "\nAge: " + age +
                "\nYear Of Birth: " + yearOfBirth +
                "\nJob: " + job;
    }
}
