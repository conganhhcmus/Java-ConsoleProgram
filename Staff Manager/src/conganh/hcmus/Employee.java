package conganh.hcmus;

import java.util.Date;

public class Employee extends Cadres{
    private String rank;

    public Employee(String fullName, String birthDay, String gender, String address,String rank) {
        super(fullName, birthDay, gender, address);
        this.rank = rank;
    }

    @Override
    public String toString() {
        return  "Employee" +
                "\nFull name: " + fullName +
                "\nBirthday: " + birthDay +
                "\nGender: " + gender +
                "\nAddress: " + address +
                "Rank: " + rank;
    }
}
