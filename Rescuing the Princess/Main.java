import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the money, power, knowledge of Prince: ");
        Scanner sc = new Scanner(System.in);
        int money, power, knowledge;
        do {
            System.out.println("Notes: input is positive numbers !");
            money = sc.nextInt();
            power = sc.nextInt();
            knowledge = sc.nextInt();
        } while (money < 0 || power < 0 || knowledge < 0);

        Prince price = new Prince(money, power, knowledge);
        // System.out.println(price.toString());
        int n;
        do {
            System.out.println("Enter the number gates of castle: ");
            System.out.println("Notes: input is positive numbers !");
            n = sc.nextInt();
        } while (n < 0);
        ArrayList<Gate> castle = new ArrayList<Gate>();

        System.out.println("Kind of gate (1: business gate, 2: academic gate, 3: power gate)");
        for (int i = 0; i < n; i++) {
            int kind = 0;
            System.out.printf("Enter kind of %dth gate: ", i + 1);
            kind = sc.nextInt();
            switch (kind) {
                case 1:
                    System.out.println("Enter the number and cost:");
                    int numb = 0;
                    int cost = 0;
                    do {
                        System.out.println("Notes: Input is positive numbers");
                        numb = sc.nextInt();
                        cost = sc.nextInt();
                    } while (numb < 0 || cost < 0);
                    castle.add(new Gate1(numb, cost));
                    break;
                case 2:
                    System.out.println("Enter the power:");
                    power = 0;
                    do {
                        System.out.println("Notes: Input is positive numbers");
                        power = sc.nextInt();
                    } while (power < 0);
                    castle.add(new Gate2(power));
                    break;
                case 3:
                    System.out.println("Enter the knowledge:");
                    knowledge = 0;
                    do {
                        System.out.println("Notes: Input is positive numbers");
                        knowledge = sc.nextInt();
                    } while (knowledge < 0);
                    castle.add(new Gate3(knowledge));
                    break;
                default:
                    System.out.println("Invalid input !");
                    i--;
            }
        }
        boolean successful = true;
        System.out.print("\n----------------------\nResult: ");
        for (int i = 0; i < castle.size(); i++) {
            if (!castle.get(i).defeated(price)) {
                System.out.printf("Prince was defeated at %dth gate.\n", i + 1);
                successful = false;
                break;
            }
        }
        if (successful)
            System.out.println("Prince rescues the princess successful");

        sc.close();
    }
}