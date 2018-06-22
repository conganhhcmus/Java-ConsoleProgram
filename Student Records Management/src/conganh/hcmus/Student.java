package conganh.hcmus;

import java.io.Serializable;

public class Student implements Serializable {
    private String fullName;
    private int age;
    private int yearOfBirth;
    private String homeTown;

    public Student(String fullName, int age, int yearOfBirth, String homeTown) {
        this.fullName = fullName;
        this.age = age;
        this.yearOfBirth = yearOfBirth;
        this.homeTown = homeTown;
    }

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

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Override
    public String toString() {
        return "\nFull Name: " + fullName +
                "\nAge: " + age +
                "\nYear Of Birth: " + yearOfBirth +
                "\nHome Town: " + homeTown;
    }
}
