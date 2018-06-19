package conganh.hcmus;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static final String FILENAME = "Book_Manager.dat";
    private static ArrayList<Document> listDocument = new ArrayList<Document>();
    public static void main(String[] args) {
        try {
            readFile();
            while (menu()) ;
            writeFile();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Thank you!");
        }
    }
    public static boolean menu() {
        System.out.println("-------------------");
        System.out.println("Document Manager: \n");
        System.out.println("1. Input Document");
        System.out.println("2. Search By Type");
        System.out.println("3. Output Document");
        System.out.println("4. Remove All");
        System.out.println("5. Exit!");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                inputDocumet();
                break;
            case 2:
                searchType();
                break;
            case 3:
                outputDocument();
                break;
            case 4:
                if(clearAll()) System.out.println("Clear All Successful !");
                else System.err.println("Clear Error !");
                break;
            default:
                System.err.println("Exit Successful!");
                return false;
        }
        return true;
    }
    public static void inputDocumet() {
        System.out.println("-------------------");
        System.out.println("Enter the Document:");
        System.out.println("1. Book");
        System.out.println("2. Magazine");
        System.out.println("3. Newspaper");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                System.out.println("-------------------");
                System.out.println("Enter the Book:");
                System.out.println("\nEnter the DocumentID:");
                String documentID = new Scanner(System.in).nextLine();
                System.out.println("Enter the Publisher:");
                String publisher = new Scanner(System.in).nextLine();
                System.out.println("Enter the NumPublishing");
                int numPublishing = new Scanner(System.in).nextInt();
                System.out.println("Enter the author Name:");
                String authorName = new Scanner(System.in).nextLine();
                System.out.println("Enter the NumPage:");
                int numPage = new Scanner(System.in).nextInt();
                Iterator<Document> itr = listDocument.iterator();
                while (itr.hasNext()) {
                    Document tmp = itr.next();
                    if ((tmp instanceof Book && tmp.documentID.compareToIgnoreCase(documentID) == 0)) {
                        System.out.println("Document ID is Exist !");
                        return;
                    }
                }
                listDocument.add(new Book(documentID,publisher,numPublishing,authorName,numPage));
                System.out.println("Successful !");
                break;
            case 2:
                System.out.println("-------------------");
                System.out.println("Enter the Magazine:");
                System.out.println("\nEnter the DocumentID:");
                documentID = new Scanner(System.in).nextLine();
                System.out.println("Enter the Publisher:");
                publisher = new Scanner(System.in).nextLine();
                System.out.println("Enter the NumPublishing");
                numPublishing = new Scanner(System.in).nextInt();
                System.out.println("Enter the release Month: ");
                String releaseMonth = new Scanner(System.in).nextLine();
                System.out.println("Enter the issue Number:");
                int issueNumber = new Scanner(System.in).nextInt();
                itr = listDocument.iterator();
                while (itr.hasNext()) {
                    Document tmp = itr.next();
                    if ((tmp instanceof Magazine && tmp.documentID.compareToIgnoreCase(documentID) == 0)) {
                        System.out.println("Document ID is Exist !");
                        return;
                    }
                }
                listDocument.add(new Magazine(documentID,publisher,numPublishing,releaseMonth,issueNumber));
                System.out.println("Successful !");
                break;
            case 3:
                System.out.println("-------------------");
                System.out.println("Enter the Newspaper:");
                System.out.println("\nEnter the DocumentID:");
                documentID = new Scanner(System.in).nextLine();
                System.out.println("Enter the Publisher:");
                publisher = new Scanner(System.in).nextLine();
                System.out.println("Enter the NumPublishing");
                numPublishing = new Scanner(System.in).nextInt();
                System.out.println("Enter the release Day:");
                String releaseDay = new Scanner(System.in).nextLine();
                itr = listDocument.iterator();
                while (itr.hasNext()) {
                    Document tmp = itr.next();
                    if ((tmp instanceof Newspaper && tmp.documentID.compareToIgnoreCase(documentID) == 0)) {
                        System.out.println("Document ID is Exist !");
                        return;
                    }
                }
                listDocument.add(new Newspaper(documentID,publisher,numPublishing,releaseDay));
                System.out.println("Successful !");
                break;
            default:
                System.err.println("Error !");
                break;
        }

    }
    public static void outputDocument() {
        System.out.println("===================");
        System.out.println("List Document: ");
        if (listDocument.size() <= 0) {
            System.out.println("Is Empty !");
            return;
        }
        Iterator<Document> itr = listDocument.iterator();
        while (itr.hasNext()) {
            Document tmp = itr.next();
            System.out.println(tmp);
        }
    }
    public static void searchType() {
        System.out.println("Enter the type: \n");
        System.out.println("1. Book");
        System.out.println("2. Magazine");
        System.out.println("3. Newspaper");
        int key = new Scanner(System.in).nextInt();
        System.out.println("Enter the Document ID:");
        String documentID = new Scanner(System.in).nextLine();
        switch (key) {
            case 1:
                for (Document tmp : listDocument) {
                    if (tmp.documentID.compareToIgnoreCase(documentID) == 0 && tmp instanceof Book) {
                        System.out.println(tmp);
                    }
                }
                break;
            case 2:
                for (Document tmp : listDocument) {
                    if (tmp.documentID.compareToIgnoreCase(documentID) == 0 && tmp instanceof Magazine) {
                        System.out.println(tmp);
                    }
                }
                break;
            case 3:
                for (Document tmp : listDocument) {
                    if (tmp.documentID.compareToIgnoreCase(documentID) == 0 && tmp instanceof Newspaper) {
                        System.out.println(tmp);
                    }
                }
                break;
            default:
                System.err.println("Error !");
                break;
        }
    }
    public static boolean clearAll() {
        return listDocument.removeAll(listDocument);
    }
    private static void readFile() {
        File file = new File(FILENAME);
        boolean isEmpty = !file.exists() || file.length() == 0;
        if (isEmpty) {
            System.err.println("File is Empty !");
            return;
        }
        try {
            //conganh
            FileInputStream fileInputStream = new FileInputStream(FILENAME);
            ObjectInputStream fin = new ObjectInputStream(fileInputStream);
            boolean isExist = true;
            Document tmp = null;
            while (isExist) {
                if (fileInputStream.available() != 0) {
                    tmp = (Document) fin.readObject();
                    if (tmp != null) listDocument.add(tmp);
                } else {
                    isExist = false;
                }
            }
            fin.close();
            fileInputStream.close();
            System.out.println("Read Successful !");
        } catch (Exception ex) {
            System.err.println("Error Read File !");
        }
    }
    private static void writeFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
            ObjectOutputStream fout = new ObjectOutputStream(fileOutputStream);
            if (listDocument.size() > 0) {
                Iterator itr = listDocument.iterator();
                while (itr.hasNext()) {
                    fout.writeObject(itr.next());
                }
            } else fout.writeObject(null);
            fout.close();
            fileOutputStream.close();
            System.out.println("Write Successful !");
        } catch (Exception ex) {
            System.err.println("Error Write File !");
        }
    }
}