package conganh.hcmus;

import java.io.Serializable;

public class Person implements Serializable {
    String fullName;
    int yearOfBirth;
    String homeTown;

    public Person(String fullName, int yearOfBirth, String homeTown) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.homeTown = homeTown;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
        return "\nPersonal Information:" +
                "\nFull Name : " + fullName +
                "\nYear Of Birth : " + yearOfBirth +
                "\nHomeTown : '" + homeTown;
    }
}
