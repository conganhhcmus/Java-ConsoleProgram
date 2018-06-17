package conganh.hcmus;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Household> listHousehold = new ArrayList<Household>();
    private static final String FILE_NAME = "Household_Management.dat";

    public static void main(String[] args) {
        try {
            readFile();
            while (menu()) ;
            writeFile();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("============");
            System.out.println("Thank You !");
            System.out.println("============");
        }
    }

    private static void readFile() {
        File file = new File(FILE_NAME);
        boolean isEmpty = !file.exists() || file.length() == 0;
        if (isEmpty) {
            System.out.println("File is Empty !");
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream fin = new ObjectInputStream(fileInputStream);
            boolean isExist = true;
            Household tmp = null;
            while (isExist) {
                if (fileInputStream.available() != 0) {
                    tmp = (Household) fin.readObject();
                    if (tmp != null) listHousehold.add(tmp);
                } else isExist = false;
            }
            fin.close();
            fileInputStream.close();
            System.out.println("Read File Successful !");
        } catch (Exception ex) {
            System.err.println("Error Read File !");
        }
    }

    private static void writeFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream fout = new ObjectOutputStream(fileOutputStream);
            if (listHousehold.size() > 0) {
                Iterator<Household> itr = listHousehold.iterator();
                while (itr.hasNext()) {
                    fout.writeObject(itr.next());
                }
            } else fout.writeObject(null);
            fout.close();
            fileOutputStream.close();
            System.out.println("Write File Successful !");
        } catch (Exception ex) {
            System.err.println("Error Write File !");
        }

    }

    public static boolean menu() {
        System.out.println("======================");
        System.out.println("Household Management: \n");
        System.out.println("1. Input Household");
        System.out.println("2. Remove Household");
        System.out.println("3. Remove All Household");
        System.out.println("4. Output Household");
        System.out.println("5. Exit !");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                input();
                break;
            case 2:
                System.out.println("Enter the Apartment Number To Remove !");
                int apartment = new Scanner(System.in).nextInt();
                if(remove(apartment)) System.out.println("Remove Household Successful !");
                else System.out.println("Remove Household Fail !");
                break;
            case 3:
                if (removeAll()) System.out.println("Remove All Successful !");
                else System.out.println("Remove All Fail !");
                break;
            case 4:
                output();
                break;
            default:
                System.err.println("Exit !");
                return false;
        }
        return true;
    }

    public static void input() {
        System.out.println("Enter the Number Member: ");
        int numMember = new Scanner(System.in).nextInt();
        System.out.println("Enter the Apartment Number:");
        int apartmentNumber = new Scanner(System.in).nextInt();
        System.out.println("Enter the List Person: \n");
        Iterator<Household> itr = listHousehold.iterator();
        while (itr.hasNext()) {
            if (itr.next().getApartmentNumber() == apartmentNumber) {
                System.err.println("Apartment Number is Exist !");
                System.err.println("Input Error !");
                return;
            }
        }
        int size = listHousehold.size();
        listHousehold.add(new Household(numMember, apartmentNumber));
        if (size < listHousehold.size()) System.out.println("Input Successful !");
        else System.err.println("Input Error !");
    }

    public static void output() {
        System.out.println("================");
        System.out.println("List Household: ");
        if (listHousehold.size() <= 0) {
            System.out.println("List is Empty !");
            return;
        }
        Iterator<Household> itr = listHousehold.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            System.out.println("--------------------");
        }
    }

    public static boolean remove(int apartmentNumber) {
        if (listHousehold.size() <= 0) {
            System.out.println("List is Empty !");
            return false;
        }
        Iterator<Household> itr = listHousehold.iterator();
        int index = 0;
        while (itr.hasNext()) {
            if (itr.next().getApartmentNumber() == apartmentNumber) {
                break;
            }
            ++index;
        }
        if (index == listHousehold.size()) {
            System.out.println("Don't find !");
            return false;
        }
        return listHousehold.remove(index) != null;
    }

    public static boolean removeAll() {

        return listHousehold.removeAll(listHousehold);
    }
}
