import java.util.Scanner;

public class Main {
    public static CPULabs cpuLabs = new CPULabs();
    public static void main(String[] args) {
        try {
            if(!cpuLabs.runLabs()) return;
            cpuLabs.showLabs();
            while (menu());
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
        System.out.println("3. Search");
        System.out.println("4. Exit!");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                if(cpuLabs.signIn()) cpuLabs.showLabs();
                break;
            case 2:
                if(cpuLabs.signOut()) cpuLabs.showLabs();
                break;
            case 3:
                cpuLabs.search();
                break;
            default:
                System.err.println("Exit Successful!");
                return false;
        }
        return true;
    }
}