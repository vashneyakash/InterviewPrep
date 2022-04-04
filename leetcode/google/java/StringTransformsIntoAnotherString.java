package google.java;

import java.util.*;
import java.util.stream.Stream;

public class StringTransformsIntoAnotherString {
    /*
    * if the input string has all 26 letters then answer will be no as we cannot transform letters without side effect
    * Eg: aabbcc to ccbbaa and we can use only a,b,c
    * Then if (a -> c and c -> a) we can never produce the correct output string
    *
    * Alternate, create a directed graph for transformations from input to output string
    * If the graph contains a cycle then no solution exists
    * */

    public static Boolean checkStringTransformation(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        } else if (str1.length() != str2.length()) {
            return false;
        }
        HashSet<Character> mp = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            mp.add(str1.charAt(i));
        }
        if (mp.size() == 26) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (map.get(str1.charAt(i)) == null) {
                map.put(str1.charAt(i), str2.charAt(i));
            } else if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
