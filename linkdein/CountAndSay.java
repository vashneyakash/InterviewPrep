package linkdein;

import java.util.*;

public class CountAndSay {

    public static String countAndSay(int len) {
        if (len == 1) return "1";
        String res = countAndSay(len - 1);
        ArrayList<Map.Entry<Character, Integer>> freqOfChars = getFreq(res);

        StringBuilder target = new StringBuilder();
        freqOfChars.forEach(entry -> {
            target.append(entry.getValue());
            target.append(entry.getKey());
        });
        System.out.println("target = " + target);
        return target.toString();
    }

    public static ArrayList<Map.Entry<Character, Integer>> getFreq(String arr) {
        ArrayList<Map.Entry<Character, Integer>> freqArr = new ArrayList<>();
        for (int i = 0; i < arr.length();) {
            int j = i;
            int freq = 0;
            while (j < arr.length() && arr.charAt(i) == arr.charAt(j)) {
                freq++;
                j++;
            }
            freqArr.add(new AbstractMap.SimpleEntry<>(arr.charAt(i), freq));
            i = j;
        }

        return freqArr;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(10));
    }
}
