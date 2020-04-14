import java.util.Scanner;

public class Main {
    public static TicketManager ticket_manager = new TicketManager();

    public static void main(String[] args) {
        try {
            while (menu())
                ;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Thank you!");
        }
    }

    // menu
    public static boolean menu() {
        System.out.println("-------------------");
        System.out.println("Ticket Manager: \n");
        System.out.println("1. Input Ticket Cost Handle");
        System.out.println("2. Input Ticket Cost File");
        System.out.println("3. Show Seats");
        System.out.println("4. Buy Ticket");
        System.out.println("5. Total Ticket Sales");
        System.out.println("6. Exit!");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:

                break;
            case 2:
                try {
                    ticket_manager.inputFile();
                } catch (Exception e) {
                    System.out.println("Read file error!");

                }

                ticket_manager.showCost();
                break;
            case 3:
                ticket_manager.showSeat();
                break;
            case 4:
                if (ticket_manager.buyTicket()) {
                    System.out.println("Buy done !");
                    ticket_manager.showSeat();
                }
                break;
            case 5:
                System.out.printf("Total Ticket Sales: %d \n", ticket_manager.totalTicketSales());
                break;
            default:
                System.err.println("Exit Successful!");
                return false;
        }
        return true;
    }

}