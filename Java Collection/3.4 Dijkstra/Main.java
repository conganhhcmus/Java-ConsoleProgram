import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the directory input file (default: input.txt)");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        File f = new File(path);
        while (!f.exists()){
            System.out.println("File don't exist !");
            System.out.println("Enter the directory input file (default: input.txt)");
            path = sc.nextLine();
            f = new File(path);
        } 
        PQDijkstra utils = new PQDijkstra(path);
        System.out.println("Enter the Start point and End point to calculator distance:");
        int src,end;
        src = sc.nextInt();
        end = sc.nextInt();
        while (!utils.Check(src,end)) {
            System.out.println("Start point or End point isn't valid !");
            System.out.println("Enter the Start point and End point to calculator distance:");
            src = sc.nextInt();
            end = sc.nextInt();
        }
        utils.dijkstra(src, end);
    }
}