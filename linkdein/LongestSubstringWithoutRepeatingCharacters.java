package linkdein;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int compute(String letters) {
        int start = 0;
        int end = 0;
        int result = 1;
        HashMap<Character, Integer> mapper = new HashMap<>();
        mapper.put(letters.charAt(0), 0);
        for (int i = 1; i < letters.length(); i++) {
            if (mapper.containsKey(letters.charAt(i))) {
                start = Math.max(start, mapper.get(letters.charAt(i)) + 1);
            }
            mapper.put(letters.charAt(i), i);
            end++;
            result = Math.max(result, end - start + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("LongestSubstringWithoutRepeatingCharacters.compute(\"abcabcbb\") = " + LongestSubstringWithoutRepeatingCharacters.compute("abcabcbb"));
        System.out.println("LongestSubstringWithoutRepeatingCharacters.compute(\"bbbbb\") = " + LongestSubstringWithoutRepeatingCharacters.compute("bbbbb"));
        System.out.println("LongestSubstringWithoutRepeatingCharacters.compute(\"pwwkew\") = " + LongestSubstringWithoutRepeatingCharacters.compute("pwwkew"));
    }
}
