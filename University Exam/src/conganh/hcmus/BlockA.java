package conganh.hcmus;

import java.io.Serializable;

public class BlockA extends Student implements Serializable {
    private String math;
    private String physical;
    private String chemistry;

    public BlockA(int studentID, String fullName, String address, String prioritize, String math, String physical, String chemistry) {
        super(studentID, fullName, address, prioritize);
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getPhysical() {
        return physical;
    }

    public void setPhysical(String physical) {
        this.physical = physical;
    }

    public String getChemistry() {
        return chemistry;
    }

    public void setChemistry(String chemistry) {
        this.chemistry = chemistry;
    }

    @Override
    public String toString() {
        return null;
    }
}
