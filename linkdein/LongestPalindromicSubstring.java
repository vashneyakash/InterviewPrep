package linkdein;

import debug.UsefulPrinting;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LongestPalindromicSubstring {
    public static String compute(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, 0));
        IntStream.range(0, s.length()).forEach(i -> dp[i][i] = 1);
        for (int i = 0; i < s.length(); i++) {
            for (int length = 1; length < s.length() - i - 1; length++) {
                if (s.charAt(i) == s.charAt(i + length)) {
                    dp[i][i + length] = 2 + (((i+1) < s.length() && (i+length -1) > 0) ? dp[i + 1][i + length - 1] : 0);
                }
            }
        }
        Pair<Integer, Integer> res = new Pair<>(0, 0);
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (max < dp[i][j]) {
                    max = dp[i][j];
                    res = new Pair<>(i, j);
                }
            }
        }
        return s.substring(res.getKey(), res.getValue() + 1);
    }

    public static void main(String[] args) {
        System.out.println("LongestPalindromicSubstring.compute(\"babad\") = " + LongestPalindromicSubstring.compute("babad"));
        System.out.println("LongestPalindromicSubstring.compute(\"cbbd\") = " + LongestPalindromicSubstring.compute("cbbd"));
    }
}
