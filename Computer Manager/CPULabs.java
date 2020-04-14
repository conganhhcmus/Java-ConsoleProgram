import java.util.Scanner;

public class CPULabs {
    int[][] cpuLabs;

    public CPULabs() {
        this.cpuLabs = null;
    }

    public boolean runLabs() {
        System.out.println("Run Labs !");
        System.out.println("Enter the M labs: ");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        this.cpuLabs = new int[m][];
        for (int i = 0; i < m; i++) {
            System.out.printf("Enter the N%d computer stations: ", i + 1);
            int n = sc.nextInt();
            this.cpuLabs[i] = new int[n];
        }
        if (this.cpuLabs == null)
            return false;
        return true;
    }

    public void showLabs() {
        System.out.printf("Lab Room: \n");
        for (int i = 0; i < this.cpuLabs.length; i++) {
            System.out.printf("Labs %d: ", i);
            for (int j = 0; j < this.cpuLabs[i].length; j++) {
                System.out.printf("%d ", cpuLabs[i][j]);
            }
            System.out.println("");
        }
    }

    public boolean signIn() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the UserID: ");
        int userId = sc.nextInt();
        if (userId >= 1000000 || userId < 10000) {
            System.out.println("UserID error because don't or over 5 digits !");
            return false;
        }
        System.out.printf("Enter the Labs number: ");
        int lab = sc.nextInt();
        System.out.printf("Enter the Cpu station: ");
        int cpu = sc.nextInt();
        if (lab < 0 || lab > this.cpuLabs.length) {
            System.out.println("Labs Number not found !");
            return false;
        }
        if (cpu < 0 || cpu > this.cpuLabs[lab].length) {
            System.out.println("Cpu station not found !");
            return false;
        }
        if(this.cpuLabs[lab][cpu] !=0) {
            System.out.println("Sign in error because cpu is using!");
            return false;
        } 

        this.cpuLabs[lab][cpu] = userId;
        return true;
    }

    public boolean signOut() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the Labs number: ");
        int lab = sc.nextInt();
        System.out.printf("Enter the Cpu station: ");
        int cpu = sc.nextInt();
        if (lab < 0 || lab > this.cpuLabs.length) {
            System.out.println("Labs Number not found !");
            return false;
        }
        if (cpu < 0 || cpu > this.cpuLabs[lab].length) {
            System.out.println("Cpu station not found !");
            return false;
        }
        if (this.cpuLabs[lab][cpu] == 0) {
            System.out.println("Sign out error !");
            return false;
        }

        System.out.printf("Sign out successful with UserID: %d !\n", this.cpuLabs[lab][cpu]);
        this.cpuLabs[lab][cpu] = 0;
        return true;
    }

    public boolean search() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the UserID: ");
        int userId = sc.nextInt();
        if (userId >= 1000000 || userId < 10000) {
            System.out.println("UserID error because don't or over 5 digits !");
            return false;
        }
        for (int i = 0; i < this.cpuLabs.length; i++) {
            for(int j = 0;j<this.cpuLabs[i].length;j++){
                if(this.cpuLabs[i][j] == userId) {
                    System.out.printf("The UserID is in CPU station %d of Lab %d !\n",j,i);
                    return true;
                }
            }
        }
        System.out.println("None !");
        return false;
    }
};