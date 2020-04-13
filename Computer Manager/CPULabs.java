import java.util.Arrays;
import java.util.Scanner;

public class CPULabs {
    String[][] cpuLabs;

    public CPULabs() {
        this.cpuLabs = null;
    }

    public boolean Run() {
        System.out.println("Enter the M labs: ");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        this.cpuLabs = new String[m][];
        for (int i = 0; i < m; i++) {
            System.out.printf("Enter the N%d computer stations: ", i + 1);
            int n = sc.nextInt();
            this.cpuLabs[i] = new String[n];
            Arrays.fill(cpuLabs[i], 0);
        }
        if (this.cpuLabs == null)
            return false;
        return true;
    }
};