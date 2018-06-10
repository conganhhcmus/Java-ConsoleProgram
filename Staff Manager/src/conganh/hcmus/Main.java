package conganh.hcmus;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "Staff_Manager.dat";

    private static ArrayList<Cadres> listCadres = new ArrayList<>();

    public static void main(String[] args) {
        readFile();
        try {
            while (menu()) ;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            writeFile();
        }
    }
    private static boolean menu() {
        boolean check = true;
        System.out.println("-----------------");
        System.out.println("Cadres Manager: ");
        System.out.println("1. Input/Enter the Cadres");
        System.out.println("2. Search by Name");
        System.out.println("3. Delete by Name");
        System.out.println("4. Remove all Cadres");
        System.out.println("5. Output All Cadres");
        System.out.println("6. Exit!");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                inputCadres();
                break;
            case 2:
                searchName();
                break;
            case 3:
                if (deleteCadres()) {
                    System.out.println("Delete Successful!");
                } else {
                    System.err.println("Delete Error!");
                }
                break;
            case 4:
                if (removeAllCadres()) {
                    System.out.println("Remove All Successful!");
                } else {
                    System.err.println("Remove All Error!");
                }
            case 5:
                outputAllCadres();
                break;
            default:
                check = false;
                System.err.println("Exit!");
                break;
        }
        return check;
    }

    private static void inputCadres() {
        System.out.println("Enter the Cadres: ");
        System.out.println("Choose the Cadres:");
        System.out.println("1. Employee");
        System.out.println("2. Engineer");
        System.out.println("3. Service Staff");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                System.out.println("Employee: ");
                System.out.println("Enter the full name:");
                String fullname = new Scanner(System.in).nextLine();
                System.out.println("Enter the birth day:");
                String birthDay = new Scanner(System.in).nextLine();
                System.out.println("Enter the gender:");
                String gender = new Scanner(System.in).nextLine();
                System.out.println("Enter the address:");
                String address = new Scanner(System.in).nextLine();
                System.out.println("Enter the rank:");
                String rank = new Scanner(System.in).nextLine();
                listCadres.add(new Employee(fullname, birthDay, gender, address,rank));
                break;
            case 2:
                System.out.println("Engineer: ");
                System.out.println("Enter the full name:");
                fullname = new Scanner(System.in).nextLine();
                System.out.println("Enter the birth day:");
                birthDay = new Scanner(System.in).nextLine();
                System.out.println("Enter the gender:");
                gender = new Scanner(System.in).nextLine();
                System.out.println("Enter the address:");
                address = new Scanner(System.in).nextLine();
                System.out.println("Enter the training sector:");
                String trainingSector = new Scanner(System.in).nextLine();
                listCadres.add(new Engineer(fullname, birthDay, gender, address, trainingSector));
                break;
            case 3:
                System.out.println("Service Staff: ");
                System.out.println("Enter the full name:");
                fullname = new Scanner(System.in).nextLine();
                System.out.println("Enter the birth day:");
                birthDay = new Scanner(System.in).nextLine();
                System.out.println("Enter the gender:");
                gender = new Scanner(System.in).nextLine();
                System.out.println("Enter the address:");
                address = new Scanner(System.in).nextLine();
                System.out.println("Enter the work:");
                String work = new Scanner(System.in).nextLine();
                listCadres.add(new ServiceStaff(fullname, birthDay, gender, address, work));
                break;
            default:
                System.err.println("You choose wrong!");
                break;
        }
    }

    private static void searchName() {
        System.out.println("Enter the name search:");
        boolean check = false;
        String nameSearch = new Scanner(System.in).nextLine();
        Iterator itr = listCadres.iterator();
        while (itr.hasNext()) {
            Cadres tmp = (Cadres) itr.next();
            if (tmp.fullName.compareToIgnoreCase(nameSearch) == 0) {
                System.out.println(tmp);
                check = true;
            }
        }
        if(!check) System.err.println("Don't Find Cadres!");
    }

    private static void outputAllCadres() {
        Iterator itr = listCadres.iterator();
        if (!itr.hasNext()) {
            System.out.println("List is empty !");
        } else {
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
        }
    }

    private static boolean deleteCadres() {
        boolean check = false;
        System.out.println("Enter the name delete:");
        String nameDelete = new Scanner(System.in).nextLine();
        Iterator itr = listCadres.iterator();
        int pos = 0;
        while (itr.hasNext()) {
            Cadres tmp = (Cadres) itr.next();
            if (tmp.fullName.compareToIgnoreCase(nameDelete) == 0) {
                listCadres.remove(pos);
                check = true;
                return check;
            }
            pos++;
        }
        return check;
    }

    private static boolean removeAllCadres() {
        boolean check = listCadres.removeAll(listCadres);
        return check;
    }
//Deserializable
    private static void readFile() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream filein = new ObjectInputStream(fileInputStream);
            if (filein == null || fileInputStream == null) {
                System.err.println("File is empty!");
                return;
            }
            listCadres.add((Cadres) filein.readObject());
            filein.close();
            fileInputStream.close();
            System.out.println("Successful!");
        } catch (Exception ex) {
            System.err.println("Error");
            ex.printStackTrace();
        }
    }
//Serializable
    private  static void writeFile() {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream fileout = new ObjectOutputStream(fileOutputStream);
            Iterator itr = listCadres.iterator();
            while (itr.hasNext()) {
               fileout.writeObject(itr.next());
            }
            fileout.close();
            fileOutputStream.close();
            System.out.println("Successful!");
        } catch (Exception ex) {
            System.err.println("Error");
            ex.printStackTrace();
        }
    }
}
