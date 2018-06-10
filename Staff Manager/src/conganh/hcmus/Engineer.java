package conganh.hcmus;


import java.io.Serializable;

public class Engineer extends Cadres implements Serializable {
    private String trainingSector;

    public Engineer(String fullName, String birthDay, String gender, String address,String trainingSector) {
        super(fullName, birthDay, gender, address);
        this.trainingSector = trainingSector;
    }

    @Override
    public String toString() {
        return  "Engineer" +
                "\nFull name: " + fullName +
                "\nBirthday: " + birthDay +
                "\nGender: " + gender +
                "\nAddress: " + address +
                "Training Sector: " + trainingSector;
    }
}
