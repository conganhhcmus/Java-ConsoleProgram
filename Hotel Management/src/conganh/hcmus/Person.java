package conganh.hcmus;

import java.io.Serializable;

public class Person implements Serializable,Comparable<Person> {
    private String fullName;
    private int age;
    private int yearOfBirth;
    private int cmnd;

    public Person(String fullName, int age, int yearOfBirth, int cmnd) {
        this.fullName = fullName;
        this.age = age;
        this.yearOfBirth = yearOfBirth;
        this.cmnd = cmnd;
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

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    @Override
    public String toString() {
        return "\nFull Name: " + fullName +
                "\nAge: " + age +
                "\nYear Of Birth: " + yearOfBirth +
                "\nCMND: " + cmnd;
    }

    @Override
    public int compareTo(Person o) {
        if (this.fullName.compareToIgnoreCase(o.fullName) == 0 &&
                this.age == o.age && this.yearOfBirth == o.yearOfBirth &&
                this.cmnd == o.cmnd) {
            return 0;
        }
        return (this.cmnd > o.cmnd) ? 1 : -1;
    }
}
