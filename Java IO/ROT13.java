import java.util.*;

public class ROT13 {
    public static void Encode(ArrayList<String> src, ArrayList<String> res) {
        for (String str : src) {
            String ans = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    int d = (str.charAt(i) - 'a' + 13) % ('z' - 'a' + 1);
                    ans += Character.toString((char) (97 + d));
                } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                    int d = (str.charAt(i) - 'A' + 13) % ('Z' - 'A' + 1);
                    ans += Character.toString((char) (65 + d));
                } else {
                    ans += str.charAt(i);
                }
            }
            res.add(ans);
        }

    }

    public static void Decode(ArrayList<String> src, ArrayList<String> res) {
        for (String str : src) {
            String ans = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    int d = (str.charAt(i) - 'a' + 26 - 13) % ('z' - 'a' + 1);
                    ans += Character.toString((char) (97 + d));
                } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                    int d = (str.charAt(i) - 'A' + 26 - 13) % ('Z' - 'A' + 1);
                    ans += Character.toString((char) (65 + d));
                } else {
                    ans += str.charAt(i);
                }
            }
            res.add(ans);
        }

    }
}