import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> arr = new HashSet<>();
        arr.add("Apple");
        arr.add("Orange");
        arr.add("Banana");
        arr.add("Apple");

        System.out.print("Input:\t");
        for (String str : arr) {
            System.out.print(str + " ");
        }

        DeleteDuplicate(arr);

        System.out.print("\nOutput:\t");
        for (String str : arr) {
            System.out.print(str + " ");
        }
    }

    public static void DeleteDuplicate(HashSet<String> arr) {
        /* Vì HashSet implements từ Set mà Set là một collection nên
        không thể chứa 2 giá trị trùng lặp cho nên nó tự động chuyển đổi */
    }
}