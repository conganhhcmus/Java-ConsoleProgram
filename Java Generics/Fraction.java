
public class Fraction implements Comparable<Fraction> {
    int numerator;
    int denominator;

    public Fraction(int x, int y) {
        numerator = x;
        denominator = y;
    }

    @Override
    public int compareTo(Fraction value) {
        int d = (this.numerator * value.denominator - this.denominator * value.numerator)
                * (this.denominator * value.denominator);
        if (d > 0)
            return 1;
        else if (d < 0)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}