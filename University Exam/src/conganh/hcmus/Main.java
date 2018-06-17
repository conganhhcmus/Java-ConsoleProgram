package conganh.hcmus;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "University_Exam.dat";
    private static HashMap<Integer,Student> listStudent =new HashMap<Integer, Student>();
    public static void main(String[] args) {
        try {
            readFile();
            while (menu()){
                // clear Screen Console !
            }
            writeFile();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            System.out.println("Thank You !");
        }
    }
    private static boolean menu() {
        System.out.println("=======================");
        System.out.println("University Exam: \n");
        System.out.println("1. Input Student");
        System.out.println("2. Search Student");
        System.out.println("3. Remove All Student");
        System.out.println("4. Output Student");
        System.out.println("5. Exit!");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                input();
                break;
            case 2:
                search();
                break;
            case 3:
                if (removeAll()) System.out.println("Remove All Successful !");
                else System.err.println("Remove All Error !");
                break;
            case 4:
                output();
                break;
            default:
                System.err.println("Exit Successful !");
                return false;
        }
        return true;
    }

    private static void input() {
        System.out.println("==================");
        System.out.println("Enter the Student ID: ");
        int studentID = new Scanner(System.in).nextInt();
        System.out.println("Enter the Full Name");
        String fullName = new Scanner(System.in).nextLine();
        System.out.println("Enter the address:");
        String address = new Scanner(System.in).nextLine();
        System.out.println("Enter the prioritize: ");
        String prioritize = new Scanner(System.in).nextLine();
        System.out.println("\nEnter the block :");
        System.out.println("\n1. Block A");
        System.out.println("2. Block B");
        System.out.println("3. Block C");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                System.out.println("Enter the Block A:\n");
                System.out.println("Enter the Math:");
                String math = new Scanner(System.in).nextLine();
                System.out.println("Enter the Physical:");
                String physical = new Scanner(System.in).nextLine();
                System.out.println("Enter the Chemistry:");
                String chemistry = new Scanner(System.in).nextLine();
                listStudent.put(studentID, new BlockA(studentID, fullName, address, prioritize, math, physical, chemistry));
                System.out.println("Input Block A Successful !");
                break;
            case 2:
                System.out.println("Enter the Block B:\n");
                System.out.println("Enter the Math:");
                math = new Scanner(System.in).nextLine();
                System.out.println("Enter the Chemistry:");
                chemistry = new Scanner(System.in).nextLine();
                System.out.println("Enter the Biological:");
                String biological = new Scanner(System.in).nextLine();
                listStudent.put(studentID, new BlockA(studentID, fullName, address, prioritize, math, chemistry, biological));
                System.out.println("Input Block B Successful !");
                break;
            case 3:
                System.out.println("Enter the Block C:\n");
                System.out.println("Enter the Literature:");
                String literature = new Scanner(System.in).nextLine();
                System.out.println("Enter the History:");
                String history = new Scanner(System.in).nextLine();
                System.out.println("Enter the Geography:");
                String geography = new Scanner(System.in).nextLine();
                listStudent.put(studentID, new BlockA(studentID, fullName, address, prioritize, literature, history, geography));
                System.out.println("Input Block C Successful !");
                break;
            default:
                System.err.println("Input Error !");
                break;
        }
    }

    private static void search(){
        if (listStudent.size() <= 0) {
            System.out.println("List Student is Empty!");
            return;
        }
        System.out.println("Enter the Student ID Search: ");
        int studentID = new Scanner(System.in).nextInt();
        System.out.println("==================");
        System.out.println("Student is: ");
        Student tmp = listStudent.get(studentID);
        if (tmp != null) {
            System.out.println(tmp);
        } else System.out.println("Don't Find !");
    }

    private static void output(){
        if (listStudent.size() <= 0) {
            System.out.println("List Student is Empty!");
            return;
        }
        System.out.println("=================");
        System.out.println("List Student :");
        Iterator<Integer> itr = listStudent.keySet().iterator();
        while (itr.hasNext()) {
            System.out.println(listStudent.get(itr.next()));
        }
    }

    private static boolean removeAll(){
        int[] resultID = new int[listStudent.size()];
        int pos = 0;
        for (int key : listStudent.keySet()) {
            if (listStudent.get(key) == null) {
                return false;
            } else resultID[pos++] = key;
        }
        for (int i = 0; i < pos; ++i) {
            listStudent.remove(resultID[i]);
        }
        return true;
    }

    private static void readFile(){
        File file = new File(FILE_NAME);
        boolean isEmpty = !file.exists() || file.length() == 0;
        if(isEmpty){
            System.out.println("File is Empty!");
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream fin = new ObjectInputStream(fileInputStream);
            boolean isExist=true;
            while (isExist) {
                if (fileInputStream.available() != 0) {
                    Student tmp = (Student) fin.readObject();
                    if (tmp != null) listStudent.put(tmp.studentID, tmp);
                } else isExist = false;
            }
            fin.close();
            fileInputStream.close();
            System.out.println("Read File Successful !");
        } catch (Exception ex) {
            System.err.println("Error read File !");
        }
    }

    private static void writeFile(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream fout = new ObjectOutputStream(fileOutputStream);
            if (listStudent.size() > 0) {
                Iterator<Integer> itr = listStudent.keySet().iterator();
                while (itr.hasNext()) {
                    fout.writeObject(listStudent.get(itr.next()));
                }
            } else fout.writeObject(null);
            fout.close();
            fileOutputStream.close();
            System.out.println("Write File Successful !");
        } catch (Exception ex) {
            System.err.println("Error Write File !");
        }
        
    }
}
