import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<String> source = new ArrayList<>();
    public static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Menu
        System.out.println("Encode - Decode Programing");
        System.out.println("1.Encode");
        System.out.println("2.Decode");
        System.out.println("Other.Exit !");
        int mode = sc.nextInt();
        sc.nextLine();
        if (mode < 1 || mode > 2) {
            System.out.println("Good Bye !");
            sc.close();
            return;
        }
        System.out.println("-----INPUT-----");
        System.out.println("1.Keyboard");
        System.out.println("2.File");
        System.out.println("Other.Exit !");
        int in = sc.nextInt();
        sc.nextLine();
        if (in < 1 || in > 2) {
            System.out.println("Good Bye !");
            sc.close();
            return;
        }

        if (in == 1) {
            System.out.println("Enter data:");
            String str = sc.nextLine();
            source.add(str);
        } else {
            System.out.println("Enter the directory input file:");
            String input = sc.nextLine();
            while (!ReadFile(input)) {
                System.out.println("Please enter again the directory input file:");
                input = sc.nextLine();
            }
        }

        // code here
        System.out.println("-----ALGORITHMS-----");
        System.out.println("1.Ceasar");
        System.out.println("2.ROT13");
        System.out.println("Other.Exit !");
        int k = sc.nextInt();
        sc.nextLine();
        if (k < 1 || k > 2) {
            System.out.println("Good Bye !");
            sc.close();
            return;
        }
        if (k == 1) {
            if (mode == 1) {
                Ceasar.Encode(source,result);
            }
            else {
                Ceasar.Decode(source,result);
            }
        }
        else {
            if (mode == 1) {
                ROT13.Encode(source,result);
            }
            else {
                ROT13.Decode(source,result);
            }
        }

        System.out.println("-----OUTPUT-----");
        System.out.println("1.Screen");
        System.out.println("2.File");
        System.out.println("Other.Exit !");
        int out = sc.nextInt();
        sc.nextLine();
        if (out < 1 || out > 2) {
            System.out.println("Good Bye !");
            sc.close();
            return;
        }
        if (out == 1) {
            System.out.println("Result: ");
            for (String str : result) {
                System.out.println(str);
            }
        } else {
            System.out.println("Enter the directory output file:");
            String output = sc.nextLine();
            while (!WriteFile(output)) {
                System.out.println("Please enter again the directory output file:");
                output = new Scanner(System.in).nextLine();
            }
        }

        sc.close();
    }

    // read file
    public static boolean ReadFile(String filePath) {
        File f = new File(filePath);
        if (f.exists()) {
            // code here
            try {
                Scanner myReader = new Scanner(f);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    // encode
                    source.add(data);
                }
                System.out.println("Successfully read to the file.");
                myReader.close();
            } catch (IOException e) {
                System.out.print("Error!");
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            System.out.println("File don't exist !!!");
            return false;
        }
    }

    // write file
    public static boolean WriteFile(String filePath) {
        File f = new File(filePath);
        if (f.exists()) {
            System.out.println("File already exist !!!");
            System.out.println("You want overwriting file ? Yes/No: 1/0");
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            if (choose == 1) {
                try {
                    FileWriter myWriter = new FileWriter(filePath);
                    for (String str : result) {
                        myWriter.write(str + "\n");
                    }
                    System.out.println("Successfully wrote to the file.");
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("Error !");
                    e.printStackTrace();
                    return false;
                }
                return true;
            } else
                return false;
        } else {
            // code here
            try {
                FileWriter myWriter = new FileWriter(filePath);
                for (String str : result) {
                    myWriter.write(str + "\n");
                }
                System.out.println("Successfully wrote to the file.");
                myWriter.close();
            } catch (IOException e) {
                System.out.println("Error !");
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }
}