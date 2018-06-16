package conganh.hcmus;

import java.io.Serializable;

public class BlockB extends Student implements Serializable {
    private String math;
    private String chemistry;
    private String biological;

    public BlockB(int studentID, String fullName, String address, String prioritize, String math, String chemistry, String biological) {
        super(studentID, fullName, address, prioritize);
        this.math = math;
        this.chemistry = chemistry;
        this.biological = biological;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getChemistry() {
        return chemistry;
    }

    public void setChemistry(String chemistry) {
        this.chemistry = chemistry;
    }

    public String getBiological() {
        return biological;
    }

    public void setBiological(String biological) {
        this.biological = biological;
    }

    @Override
    public String toString() {
        return "\nStudent ID: " + studentID +
                "\nFull Name: " + fullName +
                "\nAddress: " + address +
                "\nPrioritize: " + prioritize +
                "\nBlock B Is:" +
                "\nMath: " + math +
                "\nChemistry: " + chemistry +
                "\nBiological: " + biological +
                "\n--------------------------\n";
    }
}
