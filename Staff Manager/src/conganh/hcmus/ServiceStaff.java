package conganh.hcmus;


import java.io.Serializable;

public class ServiceStaff extends Cadres implements Serializable {
    private String work;

    public ServiceStaff(String fullName, String birthDay, String gender, String address,String work) {
        super(fullName, birthDay, gender, address);
        this.work = work;
    }

    @Override
    public String toString() {
        return  "Service Staff" +
                "\nFull name: " + fullName +
                "\nBirthday: " + birthDay +
                "\nGender: " + gender +
                "\nAddress: " + address +
                "\nWork: " + work;
    }
}
