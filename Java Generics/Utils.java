public class Utils {
    public static <T extends Comparable<T>> T FindMax(T[] arr) {
        T max = arr[0];
        if (max.getClass() == String.class) {
            for (int i = 1; i < arr.length; i++) {
                if (((String) max).length() < ((String) arr[i]).length()) {
                    max = arr[i];
                }
            }
        } else {
            for (int i = 1; i < arr.length; i++) {
                if (max.compareTo(arr[i]) < 0) {
                    max = arr[i];
                }
            }
        }
        return max;
    }
}