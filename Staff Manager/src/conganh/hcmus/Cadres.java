package conganh.hcmus;


public abstract class Cadres {
    protected String fullName;
    protected String birthDay;
    protected String gender;
    protected String address;

    public Cadres(String fullName, String birthDay, String gender, String address) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.address = address;
    }

    @Override
    public abstract String toString();
}
