package conganh.hcmus;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static String FILE_NAME = "Salary_Management.dat";
    private static ArrayList<Staff> listStaff = new ArrayList<Staff>();

    public static void main(String[] args) {
        readFile();
        while(menu()) ;
        writeFile();
    }

    public static boolean menu() {
        System.out.println("===================");
        System.out.println("Salary Management\n");
        System.out.println("1. Input");
        System.out.println("2. RemoveStaff");
        System.out.println("3. RemoveAll");
        System.out.println("4. Output");
        System.out.println("5. Exit !");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                input();
                break;
            case 2:
                System.out.println("Enter the full name :");
                String fullName = new Scanner(System.in).nextLine();
                Iterator<Staff> itr = listStaff.iterator();
                Staff tmp = null;
                boolean check = false;
                while (itr.hasNext()) {
                    tmp = itr.next();
                    if (tmp.getPerson().getFullName().compareToIgnoreCase(fullName) == 0) {
                        check = true;
                        break;
                    }
                }
                if (!check) System.out.println("Don't Find !");
                else removeStaff(tmp);
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
        System.out.println("---------------");
        System.out.println("Enter the Staff\n");
        System.out.println("Enter the full name: ");
        String fullName = new Scanner(System.in).nextLine();
        System.out.println("Enter the year of birth: ");
        int yearOfBirth = new Scanner(System.in).nextInt();
        System.out.println("Enter the hometown: ");
        String homeTown = new Scanner(System.in).nextLine();
        System.out.println("Enter the fixed salary: ");
        int fixedSalary = new Scanner(System.in).nextInt();
        System.out.println("Enter the bonus: ");
        int bonus = new Scanner(System.in).nextInt();
        System.out.println("Enter the fine: ");
        int fine = new Scanner(System.in).nextInt();
        Person tmp = new Person(fullName, yearOfBirth, homeTown);
        listStaff.add(new Staff(tmp, fixedSalary, bonus, fine));
    }

    public static void output() {
        if (listStaff.size() <= 0) {
            System.out.println("List is Empty !");
            return;
        }
        Iterator<Staff> itr = listStaff.iterator();
        System.out.println("List Staff Information");
        while (itr.hasNext()) {
            System.out.println(itr.next());
            System.out.println("-----------------------");
        }
    }

    public static boolean removeAll() {
        return listStaff.removeAll(listStaff);
    }

    public static boolean removeStaff(Staff staff) {
        return listStaff.remove(staff);
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
            Staff tmp = null;
            while (isExist) {
                if (fileInputStream.available() != 0) {
                    tmp = (Staff) fin.readObject();
                    if(tmp!=null) listStaff.add(tmp);
                } else isExist = false;
            }
            fin.close();
            fileInputStream.close();
            System.out.println("Read File is Successful !");
        } catch (Exception ex) {
            System.err.println("Read File is Error !");
        }
    }

    private static void writeFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream fout = new ObjectOutputStream(fileOutputStream);
            if (listStaff.size() <= 0) fout.writeObject(null);
            else {
                Iterator<Staff> itr = listStaff.iterator();
                while (itr.hasNext()) fout.writeObject(itr.next());
            }
            fout.close();
            fileOutputStream.close();
            System.out.println("Write File is Successful !");
        } catch (Exception ex) {
            System.err.println("Write File is Error !");
        }

    }
}
