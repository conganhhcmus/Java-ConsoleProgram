package conganh.hcmus;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    private static final String FILE_NAME = "University_Exam.dat";
    private static HashMap<Integer,Student> listStudent =new HashMap<Integer, Student>();
    public static void main(String[] args) {
        readFile();
        while(menu());
        writeFile();
    }
    private static boolean menu() {
        return true;
    }
    private static void input() {

    }
    private static void search(){

    }
    private static void output(){

    }
    private static boolean removeAll(){
        Iterator<Integer> itr=listStudent.keySet().iterator();
        while(itr.hasNext()){
            Integer tmp=itr.next();
            if(listStudent.remove(tmp)==null) return false;
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
}
