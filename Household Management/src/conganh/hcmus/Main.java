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
            //while (menu()) ;
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
                remove(4);
                break;
            case 3:
                removeAll();
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

    }

    public static void output() {

    }

    public static boolean remove(int apartmentNumber) {

        return true;
    }

    public static boolean removeAll() {

        return true;
    }
}
