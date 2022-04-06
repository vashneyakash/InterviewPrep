package GeekForGeeks.google.java;

import java.util.*;
import java.util.stream.Stream;

public class Transform1StringToAnother {
    /*
    * Since only possible operation is to delete at char at index i and push it to front.
    * We can check if both the strings has same freq of the characters. If yes then first can be transformed into second.
    * To find min operations required ->
    * 1. In n operations we can transform 1 string to another
    * 2.
    * abcdef -> fadecb
    *
    * */

    public static int transformString(String src, String target) {
        if (src.length() == target.length() && hasSameCharacterFreq(src, target)) {
            int srcIndex = src.length() -1;
            int numberOfHops = 0;
            for (int i = target.length() -1; i>=0; i--) {
                if (src.charAt(srcIndex) == target.charAt(i)) {
                    srcIndex--;
                } else {
                    while (src.charAt(srcIndex) != target.charAt(i)) {
                        srcIndex--;
                        numberOfHops++;
                    }
                }
            }
            return numberOfHops;
        } else {
            return -1;
        }
    }

    private static boolean hasSameCharacterFreq(String src, String target) {
        HashMap<Character, Integer> srcCharacterSet = new HashMap<>();
        HashMap<Character, Integer> targetCharacterSet = new HashMap<>();

        for (int i = 0; i < src.length(); i++) {
            srcCharacterSet.put(src.charAt(i), Optional.ofNullable(srcCharacterSet.get(src.charAt(i))).orElse(-1) + 1);
            targetCharacterSet.put(target.charAt(i), Optional.ofNullable(targetCharacterSet.get(target.charAt(i))).orElse(-1) + 1);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (!Objects.equals(srcCharacterSet.get(c), targetCharacterSet.get(c)))
                return false;
        }
        return true;
    }
}
