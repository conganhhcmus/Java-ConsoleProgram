package conganh.hcmus;


import java.util.Scanner;

public class Main {
    public static Fraction fraction = new Fraction(0, 1);
    public static void main(String[] args) {
       while(menu());
    }

    public static boolean menu() {
        boolean check = true;
        System.out.println("Fraction management: ");
        System.out.println("1. Init Fraction");
        System.out.println("2. Summation");
        System.out.println("3. Subtraction");
        System.out.println("4. Multiplication");
        System.out.println("5. Division");
        System.out.println("6. Is Irreducibility ?");
        System.out.println("7. Irreducibility Fraction");
        System.out.println("8. Exit");
        System.out.println("----------------------------");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                System.out.println("Enter the  numerator and denominator of Fraction:");
                int numerator = new Scanner(System.in).nextInt();
                int denominator = new Scanner(System.in).nextInt();
                fraction.setNumerator(numerator);
                fraction.setDenominator(denominator);
                System.out.println("Fraction Is: "+fraction);
                break;
            case 2:
                System.out.println("Enter the  numerator and denominator of Fraction Summation:");
                numerator = new Scanner(System.in).nextInt();
                denominator = new Scanner(System.in).nextInt();
                fraction = fraction.summation(new Fraction(numerator, denominator));
                System.out.println("Fraction Is: "+fraction);
                break;
            case 3:
                System.out.println("Enter the  numerator and denominator of Fraction Subtraction:");
                numerator = new Scanner(System.in).nextInt();
                denominator = new Scanner(System.in).nextInt();
                fraction = fraction.subtraction(new Fraction(numerator, denominator));
                System.out.println("Fraction Is: "+fraction);
                break;
            case 4:
                System.out.println("Enter the  numerator and denominator of Fraction Multiplication:");
                numerator = new Scanner(System.in).nextInt();
                denominator = new Scanner(System.in).nextInt();
                fraction = fraction.multiplication(new Fraction(numerator, denominator));
                System.out.println("Fraction Is: "+fraction);
                break;
            case 5:
                System.out.println("Enter the  numerator and denominator of Fraction Division:");
                numerator = new Scanner(System.in).nextInt();
                denominator = new Scanner(System.in).nextInt();
                fraction = fraction.division(new Fraction(numerator, denominator));
                System.out.println("Fraction Is: "+fraction);
                break;
            case 6:
                if(fraction.checkIrreducibility())  System.out.println("Fraction is irreducibility");
                else System.out.println("Fraction is not irreducibility");
                break;
            case 7:
                System.out.println("Fraction Irreducibility Is: "+fraction.irreducibility());
                break;
            default:
                check = false;
                System.err.println("Exit!");
                break;
        }
        return check;
    }
}
