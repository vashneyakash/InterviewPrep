package GeekForGeeks.google.java;

import debug.UsefulPrinting;

public class CheckIfItIsPossibleToTransformOneStringToAnother {
    /*
    * Question - https://www.geeksforgeeks.org/check-possible-transform-one-string-another/
    *
    * BruteForce Approach:
    * We can check characters in upper-case contains more freq of desired characters
    *
    * dp[i][j] -> x characters matched
    * x row denotes the input array
    * y columns denotes the output array
    * if (input[i] == output[j]) {
    *   dp[i][j] = max(dp[i-1][j], dp[i][j-1], dp[i-1,j-1] + 1);
    * } else if (isUpper(input[i])) {
    *   dp[i][j] = -infinity
    * } else {
    *   dp[i][j] = max(dp[i][j-1], dp[i-1,j-1]);
    * }
    *
    * Correct Approach:
    * dp[i][j] : denotes that first i chars of s1 can be transformed to first j chars of s2
    * dp[-1][-1] is true
    * dp[i][j] is true if dp[i-1][j-1] is true and s1[i].toUpper() == s2[i].toUpper()
    * dp[i][j] is true if dp[i][j-1] is true and s1[is].isLower() == True
    * */

    private final String source;
    private final String target;
    private final Boolean dp[][];
    public CheckIfItIsPossibleToTransformOneStringToAnother(String source, String target) {
        this.source = source;
        this.target = target;
        dp = new Boolean[source.length()][source.length()];
    }

    public boolean isTransformable() {
        for (int i = 0; i < this.source.length(); i++) {
            for (int j = 0; j < this.target.length(); j++) {
                if (isTransformable(i - 1,j - 1)
                        && Character.toUpperCase(this.source.charAt(i)) == Character.toUpperCase(this.target.charAt(j))) {
                    dp[i][j] = true;
                } else if (isTransformable(i - 1, j) && Character.isLowerCase(this.source.charAt(i))) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        UsefulPrinting.print2DArray(dp, 0, 0, source.length(), target.length());
        return dp[this.source.length() - 1][this.target.length() - 1];
    }

    private boolean isTransformable(int i, int j) {
        if (i == -1 && j == -1) {
            return true;
        } else if (i == -1) {
            return false;
        } else if (j == -1) {
            return Character.isLowerCase(this.source.charAt(i));
        } else {
            return dp[i][j];
        }
    }

    public static void main(String[] args) {
        System.out.println(new CheckIfItIsPossibleToTransformOneStringToAnother("daBcd", "ABC").isTransformable());
        System.out.println(new CheckIfItIsPossibleToTransformOneStringToAnother("argaju", "RAJ").isTransformable());
        System.out.println(new CheckIfItIsPossibleToTransformOneStringToAnother("ABcd", "BCD").isTransformable());
    }
}
