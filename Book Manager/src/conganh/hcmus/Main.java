package conganh.hcmus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Document> listDocument = new ArrayList<Document>();
    public static void main(String[] args) {
        readFile();
        while (menu());
        writeFile();
    }
    public static boolean menu() {
        System.out.println("-------------------");
        System.out.println("Document Manager: ");
        System.out.println("1. Input Document");
        System.out.println("2. Search By Type");
        System.out.println("3. Output Document");
        System.out.println("4. Exit!");
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
                System.out.println("Enter the auther Name:");
                String autherName = new Scanner(System.in).nextLine();
                System.out.println("Enter the NumPage:");
                int numPage = new Scanner(System.in).nextInt();
                listDocument.add(new Book(documentID,publisher,numPublishing,autherName,numPage));
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
                listDocument.add(new Newspaper(documentID,publisher,numPublishing,releaseDay));
                System.out.println("Successful !");
                break;
            default:
                System.err.println("Error !");
                break;
        }

    }
    public static void outputDocument() {
        Iterator<Document> itr = listDocument.iterator();
        while (itr.hasNext()) {
            Document tmp = itr.next();
            System.out.println(tmp);
        }
    }
    public static void searchType() {

    }
    private static void readFile() {

    }
    private static void writeFile() {
        
    }
}