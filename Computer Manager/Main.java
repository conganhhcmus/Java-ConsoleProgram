import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            CPULabs cpuLabs = new CPULabs();
            if(!cpuLabs.Run()) return;
            while (menu()) ;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Thank you!");
        }
    }
    // menu
    public static boolean menu() {
        System.out.println("-------------------");
        System.out.println("Computer Manager: \n");
        System.out.println("1. Sign in");
        System.out.println("2. sign out");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("5. Exit!");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            default:
                System.err.println("Exit Successful!");
                return false;
        }
        return true;
    }
}