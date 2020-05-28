import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(8);
        arr.add(1);
        arr.add(2);
        System.out.print("Input:\t");
        for (Integer i : arr) {
            System.out.print(i + " ");
        }

        Sort(arr);
        
        System.out.print("\nOutput:\t");
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void Sort(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    // swap
                    int tmp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, tmp);
                }
            }
        }
    }
}