package conganh.hcmus;

import java.util.Scanner;

public class Fraction {
    protected int numerator;
    protected int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        while (denominator == 0) {
            System.out.println("Enter denominator beacause it is zero !");
            denominator = new Scanner(System.in).nextInt();
        }
        this.denominator = denominator;
    }

    public double getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public  Fraction summation(Fraction ps) {
        Fraction tmp=new Fraction(0,1);
        tmp.numerator = this.numerator * ps.denominator + this.denominator * ps.numerator;
        tmp.denominator = this.denominator * ps.denominator;
        return tmp;
    }

    public Fraction subtraction(Fraction ps) {
        Fraction tmp=new Fraction(0,1);
        tmp.numerator = this.numerator * ps.denominator - this.denominator * ps.numerator;
        tmp.denominator = this.denominator * ps.denominator;
        return tmp;
    }

    public Fraction division(Fraction ps) {
        Fraction tmp=new Fraction(0,1);
        tmp.numerator = this.numerator * ps.denominator;
        tmp.denominator = this.denominator * ps.numerator;
        return tmp;
    }

    public Fraction multiplication(Fraction ps) {
        Fraction tmp=new Fraction(0,1);
        tmp.numerator = this.numerator * ps.numerator;
        tmp.denominator = this.denominator * ps.denominator;
        return tmp;
    }

    public int greatestCommonDivisor() {
        int a = this.numerator;
        int b = this.denominator;
        while (b != 0) {
            a = a % b;
            int tmp = a;
            a = b;
            b = tmp;
        }
        return a;
    }
    public boolean checkIrreducibility() {
        int a = this.numerator;
        int b = this.denominator;

        if (this.greatestCommonDivisor() > 1) {
            return false;
        } else {
            return true;
        }
    }

    public Fraction irreducibility() {
        Fraction tmp=new Fraction(0,1);
        tmp.numerator = this.numerator / this.greatestCommonDivisor();
        tmp.denominator = this.denominator / this.greatestCommonDivisor();
        return tmp;
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}
