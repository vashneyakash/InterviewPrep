package GeekForGeeks.google.java;

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
    * */
}
