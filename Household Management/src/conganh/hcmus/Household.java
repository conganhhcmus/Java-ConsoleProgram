package conganh.hcmus;

import java.io.Serializable;
import java.util.Scanner;

public class Household implements Serializable {
    private int numMember;
    private int apartmentNumber;
    private Person[]listPersion;

    public Household(int numMember, int apartmentNumber) {
        this.numMember = numMember;
        this.apartmentNumber = apartmentNumber;
        this.listPersion = new Person[numMember];
        for (int i = 0; i < numMember; ++i) {
            System.out.printf("Enter the Person[%d]: ",i);
            System.out.println("Enter the full Name: ");
            String fulName = new Scanner(System.in).nextLine();
            System.out.println("Enter the Age: ");
            int age = new Scanner(System.in).nextInt();
            System.out.println("Enter the Year Of Birth: ");
            int yearOfBirth = new Scanner(System.in).nextInt();
            System.out.println("Enter the Job: ");
            String job = new Scanner(System.in).nextLine();
            listPersion[i]=new Person(fulName,age,yearOfBirth,job);
        }
    }

    public int getNumMember() {
        return numMember;
    }

    public void setNumMember(int numMember) {
        this.numMember = numMember;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Person[] getListPersion() {
        return listPersion;
    }

    public void setListPersion(Person[] listPersion) {
        this.listPersion = listPersion;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < numMember; ++i) {
            s += listPersion[i] + "\n";
        }
        return "\nNumber Member: " + numMember +
                "\nApartment Number: " + apartmentNumber +
                "\nList Person: " +
                "\n" + s;
    }
}
