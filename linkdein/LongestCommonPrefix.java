package linkdein;

import java.util.Arrays;
import java.util.stream.*;

public class LongestCommonPrefix {

    public static String computeLongestCommonPrefix(String[] arr) {
        int minValue = Stream.of(arr).map(String::length).min(Integer::compareTo).orElse(0);

        StringBuilder commonSubString = new StringBuilder();
        for (int i = 0; i < minValue; i++) {
            final int x = i;
            if(Stream.of(arr).allMatch(input -> input.charAt(x) == arr[0].charAt(x))) {
                commonSubString.append(arr[0].charAt(i));
            } else {
                return commonSubString.toString();
            }
        }
        return commonSubString.toString();
    }

    public static void main(String[] args) {
        System.out.println(LongestCommonPrefix.computeLongestCommonPrefix(new String[] {"flower", "flow", "flight"}));
    }
}
