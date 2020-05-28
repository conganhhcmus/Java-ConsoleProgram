import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Orange");
        list.add("Banana");
        list.add("Lemon");

        System.out.print("Input:\t");
        for (String str : list) {
            System.out.print(str + " ");
        }

        System.out.print("\nSwap 1 3");
        Swap(1, 3, list);

        System.out.print("\nOutput:\t");
        for (String str : list) {
            System.out.print(str + " ");
        }
    }

    public static void Swap(int a, int b, LinkedList<String> list) {
        String tmp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, tmp);
    }
}