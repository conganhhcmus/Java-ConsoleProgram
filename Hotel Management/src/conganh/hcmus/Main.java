package conganh.hcmus;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Hotel> listHotel=new ArrayList<Hotel>();

    private static String FILE_NAME = "Hotel_Management.dat";

    public static void main(String[] args) {
        readFile();
        while(menu());
        writeFile();
    }

    public static void input() {
        System.out.println("Enter the Guest");
        System.out.println("Enter the Number Day Stay:");
        int numDay = new Scanner(System.in).nextInt();
        System.out.println("Enter the Type Room:");
        String typeRoom = new Scanner(System.in).nextLine();
        System.out.println("Enter the Price Room:");
        int priceRoom = new Scanner(System.in).nextInt();
        System.out.println("Enter the Personal Information:");
        System.out.println("Enter the Full Name:");
        String fullName = new Scanner(System.in).nextLine();
        System.out.println("Enter the Age:");
        int age = new Scanner(System.in).nextInt();
        System.out.println("Enter the Year Of Birth:");
        int yearOfBirth = new Scanner(System.in).nextInt();
        System.out.println("Enter the CMND:");
        int cmnd = new Scanner(System.in).nextInt();
        int size = listHotel.size();
        listHotel.add(new Hotel(numDay, typeRoom, priceRoom, new Person(fullName, age, yearOfBirth, cmnd)));
        if (size < listHotel.size()) System.out.println("Input Guest is Successful !");
        else System.err.println("Input Guest is Error !");
    }

    public static void output() {
        if (listHotel.size() <= 0) {
            System.out.println("List is Empty !");
            return;
        }
        Iterator<Hotel> itr = listHotel.iterator();
        while (itr.hasNext()) {
            System.out.println("--------------------");
            System.out.println(itr.next());
        }
    }

    public static int payRoom(Person guest) {
        int price = 0;
        boolean check = false;
        Iterator<Hotel> itr = listHotel.iterator();
        Hotel tmp = null;
        while (itr.hasNext()) {
            tmp = itr.next();
            if (tmp.getGuest().compareTo(guest) == 0) {
                check = true;
                price += tmp.getPriceRoom() * tmp.getNumDay();
            }
        }
        if (!check) price = -1;
        return price;
    }

    public static boolean menu() {
        System.out.println("======================");
        System.out.println("Hotel Management\n");
        System.out.println("1. Input Guest");
        System.out.println("2. Pay Room for Guest");
        System.out.println("3. Output All Guest");
        System.out.println("4. Exit !");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                input();
                break;
            case 2:
                System.out.println("Enter the Guest For Pay:");
                System.out.println("Enter the full Name:");
                String fullName = new Scanner(System.in).nextLine();
                System.out.println("Enter the Age:");
                int age = new Scanner(System.in).nextInt();
                System.out.println("Enter the year Of Birth:");
                int yearOfBirth = new Scanner(System.in).nextInt();
                System.out.println("Enter the CMND:");
                int cmnd = new Scanner(System.in).nextInt();
                System.out.printf("Prices For Guest Is: \t");
                if (payRoom(new Person(fullName, age, yearOfBirth, cmnd)) < 0) {
                    System.out.println("Don't Find Guest !");
                } else System.out.println(payRoom(new Person(fullName, age, yearOfBirth, cmnd)));
                break;
            case 3:
                output();
                break;
            default:
                System.err.println("Exit !");
                return false;
        }
        return true;
    }

    public static void readFile() {
        File file = new File(FILE_NAME);
        boolean isEmpty = !file.exists() || file.length() == 0;
        if (isEmpty) {
            System.out.println("File is Empty!");
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream fin = new ObjectInputStream(fileInputStream);
            boolean isExist =true;
            Hotel tmp = null;
            while (isExist) {
                if (fileInputStream.available() != 0) {
                    tmp = (Hotel) fin.readObject();
                    if (tmp != null) listHotel.add(tmp);
                } else isExist = false;
            }
            fin.close();
            fileInputStream.close();
            System.out.println("Read File is Successful !");
        } catch (Exception ex) {
            System.err.println("Read File is Error !");
        }

    }

    public static void writeFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream fout = new ObjectOutputStream(fileOutputStream);
            if (listHotel.size() > 0) {
                Iterator<Hotel> itr = listHotel.iterator();
                while (itr.hasNext()) {
                    fout.writeObject(itr.next());
                }
            } else fout.writeObject(null);
            fout.close();
            fileOutputStream.close();
            System.out.println("Write File is Successful !");
        } catch (Exception ex) {
            System.err.println("Write File is Error !");
        }

    }

}
