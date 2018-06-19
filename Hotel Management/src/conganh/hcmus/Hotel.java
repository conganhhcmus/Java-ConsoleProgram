package conganh.hcmus;

import java.io.Serializable;

public class Hotel implements Serializable {
    private int numDay;
    private String typeRoom;
    private int priceRoom;
    private Person guest;

    public Hotel(int numDay, String typeRoom, int priceRoom, Person guest) {
        this.numDay = numDay;
        this.typeRoom = typeRoom;
        this.priceRoom = priceRoom;
        this.guest = guest;
    }

    public int getNumDay() {
        return numDay;
    }

    public void setNumDay(int numDay) {
        this.numDay = numDay;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public int getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(int priceRoom) {
        this.priceRoom = priceRoom;
    }

    public Person getGuest() {
        return guest;
    }

    public void setGuest(Person guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "\nNumber Day Stay: " + numDay +
                "\nType Room: " + typeRoom +
                "\nPrice Room: " + priceRoom +
                "\nPersonal Information: " +
                guest.toString();
    }
}
