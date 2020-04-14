import java.io.*;
import java.util.Scanner;

public class TicketManager {
    private char[][] ticket = new char[15][30];
    private int[][] ticket_cost = new int[15][30];
    private int total;

    public TicketManager() {
        total = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 30; j++) {
                ticket[i][j] = '#';
                ticket_cost[i][j] = -1;
            }
        }
    }

    public boolean inputHandle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Ticket cost :");
        for (int i = 0; i < 15; i++) {
            System.out.printf("Enter the ticket cost row %d :\n", i + 1);
            for (int j = 0; j < 30; j++) {
                this.ticket_cost[i][j] = sc.nextInt();
            }
        }
        return true;
    }

    public boolean inputFile() throws Exception {
        File file = new File("cost.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String tmp[];
        int index = 0;
        while ((st = br.readLine()) != null) {
            tmp = st.split(" ");
            for(int j = 0; j < tmp.length;j++){
                this.ticket_cost[index][j] = Integer.parseInt(tmp[j]);
            }
            index++;
        }
        return true;
    }

    public void showSeat() {
        // String format = "|%1$-10s|\n";

        System.out.println("Seats");
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 30; j++) {
                System.out.printf("%s ", ticket[i][j]);
            }
            System.out.println("");
        }
    }

    public boolean buyTicket() {
        System.out.println("Enter the row and col Seat :");
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        if (row < 1 || row > 15) {
            System.out.println("Not found row !");
            return false;
        }
        if (col < 1 || col > 30) {
            System.out.println("Not found col !");
            return false;

        }
        if (this.ticket[row - 1][col - 1] == '*') {
            System.out.println("Tickets have been sold !");
            return false;
        }
        this.ticket[row - 1][col - 1] = '*';
        this.total += this.ticket_cost[row - 1][col - 1];
        return true;
    }

    public int totalTicketSales() {
        return total;
    }

    public void showCost() {
        // String format = "|%1$-10s|\n";

        System.out.println("Cost");
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 30; j++) {
                System.out.printf("%d ", ticket_cost[i][j]);
            }
            System.out.println("");
        }
    }
}