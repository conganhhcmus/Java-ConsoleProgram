package conganh.hcmus;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    private static final String FILE_NAME = "Student_Records_Management.dat";
    private static TreeSet<StudentRecord> studentRecords = new TreeSet<StudentRecord>();
    public static void main(String[] args) {
        readFile();
        while(menu());
        writeFile();
    }

    public static boolean menu() {
        System.out.println("===========================");
        System.out.println("Student Records Management \n");
        System.out.println("1. Input Student");
        System.out.println("2. Search By Year");
        System.out.println("3. Count Student By Year And Home Town");
        System.out.println("4. Output All Student");
        System.out.println("5. Remove Student");
        System.out.println("6. Remove All");
        System.out.println("7. Exit !");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                inputStudent();
                break;
            case 2:
                searchByYear();
                break;
            case 3:
                int size = countStudentByYearAndHomeTown();
                if (size > 0) System.out.println("Number of Student is " + size);
                break;
            case 4:
                outputAllStudent();
                break;
            case 5:
                System.out.println("Enter the name: ");
                String fullName = new Scanner(System.in).nextLine();
                if (removeStudent(new Student(fullName,0,0,null))) {
                    System.out.println("Remove Student is Successful !");
                } else System.err.println("Remove Student is Error !");
                break;
            case 6:
                if (removeAll()) {
                    System.out.println("Remove All Student is Successful !");
                } else System.err.println("Remove All Student is Error !");
                break;
            default:
                System.err.println("Exit !");
                return false;
        }
        return true;
    }

    public static void inputStudent() {
        System.out.println("Enter the class room: ");
        String classRoom = new Scanner(System.in).nextLine();
        System.out.println("Enter the course: ");
        String course = new Scanner(System.in).nextLine();
        System.out.println("Enter the semester: ");
        String semester = new Scanner(System.in).nextLine();
        System.out.println("Enter Student Record:");
        System.out.println("Enter the full name: ");
        String fullName = new Scanner(System.in).nextLine();
        System.out.println("Enter the Age: ");
        int age = new Scanner(System.in).nextInt();
        System.out.println("Enter the year of birth: ");
        int yearOfBirth = new Scanner(System.in).nextInt();
        System.out.println("Enter the home town: ");
        String homeTown = new Scanner(System.in).nextLine();
        int size = studentRecords.size();
        studentRecords.add(new StudentRecord(classRoom, course, semester, new Student(fullName, age, yearOfBirth, homeTown)));
        if (size < studentRecords.size()) {
            System.out.println("Input Student is Successful !");
        } else System.out.println("Input Student is Error !");
    }

    public static void searchByYear() {
        if (studentRecords.size() <= 0) {
            System.out.println("Student Records is Empty !");
            return;
        }
        System.out.println("Enter the Year :");
        int year = new Scanner(System.in).nextInt();
        Iterator<StudentRecord> itr = studentRecords.iterator();
        StudentRecord tmp = null;
        boolean check = false;
        while (itr.hasNext()) {
            tmp = itr.next();
            if (tmp.getStudent().getYearOfBirth() == year) {
                check = true;
                System.out.println(tmp);
            }
        }
        if(!check) System.out.println("Don't Find !");
    }

    public static int countStudentByYearAndHomeTown() {
        System.out.println("Enter the year: ");
        int year = new Scanner(System.in).nextInt();
        System.out.println("Enter the home town: ");
        String homeTown = new Scanner(System.in).nextLine();
        int count = 0;
        if (studentRecords.size() <= 0) {
            System.out.println("File is Empty !");
            return -1;
        }
        Iterator<StudentRecord> itr = studentRecords.iterator();
        StudentRecord tmp = null;
        while (itr.hasNext()) {
            tmp = itr.next();
            if (tmp.getStudent().getYearOfBirth() == year && tmp.getStudent().getHomeTown().compareToIgnoreCase(homeTown) == 0) {
                ++count;
            }
        }
        if (count == 0) System.out.println("Don't Find !");
        return count;
    }

    public static void outputAllStudent() {
        if (studentRecords.size() <= 0) {
            System.out.println("Student Records is Empty !");
            return;
        }
        Iterator<StudentRecord> itr = studentRecords.iterator();
        System.out.println("\nStudent Records is :");
        while (itr.hasNext()) {
            System.out.println("------------------------------");
            System.out.println(itr.next());
        }
    }

    public static boolean removeStudent(Student student) {
        if (studentRecords.size() <= 0) {
            System.out.println("Student Records is Empty !");
            return false;
        }
        Iterator<StudentRecord> itr = studentRecords.iterator();
        StudentRecord tmp = null;
        while (itr.hasNext()) {
            tmp = itr.next();
            if (tmp.getStudent().getFullName().compareToIgnoreCase(student.getFullName()) == 0) {
                studentRecords.remove(tmp);
                return true;
            }
        }
        return false;
    }

    public static boolean removeAll() {
        return studentRecords.removeAll(studentRecords);
    }

    public static void readFile() {
        File file = new File(FILE_NAME);
        boolean isEmpty = !file.exists() || file.length() == 0;
        if (isEmpty) {
            System.out.println("File is Empty !");
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream fin = new ObjectInputStream(fileInputStream);
            boolean isExist=true;
            StudentRecord tmp = null;
            while (isExist) {
                if (fileInputStream.available() != 0) {
                    tmp = (StudentRecord) fin.readObject();
                    if (tmp != null) studentRecords.add(tmp);
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
            if (studentRecords.size() <= 0) {
                fout.writeObject(null);
            } else {
                Iterator<StudentRecord> itr = studentRecords.iterator();
                while (itr.hasNext()) {
                    fout.writeObject(itr.next());
                }
            }
            fout.close();
            fileOutputStream.close();
            System.out.println("Write File is Successful !");
        } catch (Exception ex) {
            System.err.println("Write File is Error !");
        }
    }


}
