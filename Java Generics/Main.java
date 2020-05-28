import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Input
        Integer[] intArr = {1,2,3,4,5};
        Double[] doubleArr = {1.2,4.6,7.0,10.2};
        Fraction[] fractionArr = {new Fraction(1,2),new Fraction(3,-2),new Fraction(1,4)};
        Complex[] complexArr = {new Complex(3,4), new Complex(1,2),new Complex(-6,8)};
        String[] strArr = {"cong anh","hello","teacher"};


        // Test
        System.out.println(Utils.FindMax(intArr));
        System.out.println(Utils.FindMax(doubleArr));
        System.out.println(Utils.FindMax(fractionArr));
        System.out.println(Utils.FindMax(complexArr));
        System.out.println(Utils.FindMax(strArr));
    }
}