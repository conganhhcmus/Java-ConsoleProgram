public class Complex implements Comparable<Complex> {
    int real;
    int virtual;

    public Complex(int x, int y) {
        real = x;
        virtual = y;
    }

    @Override
    public int compareTo(Complex value) {
        double d = Math.sqrt(real * real + virtual * virtual)
                - Math.sqrt(value.real * value.real + value.virtual * value.virtual);
        if (d > 0)
            return 1;
        else if (d < 0)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return real + "+" + virtual + "i";
    }
}