package linkdein;

public class MaximumSubarray {
    /*
    * Find the maximum subarray
    * Referred solution - https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
    * */

    public static int findMaximumSubArray(int[] arr) {
        int maxSoFar = 0;
        int res = Integer.MIN_VALUE;
        for (int val : arr) {
            maxSoFar = maxSoFar + val;
            if (res < maxSoFar) {
                res = maxSoFar;
            }
            if (maxSoFar < 0) {
                maxSoFar = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMaximumSubArray(new int[] {1, 5, -10, 12, 4, -5, -6, 2, -10}));
        System.out.println(findMaximumSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(findMaximumSubArray(new int[] {-2, -3, 4, -1, -2, 1, 5, -3}));
    }
}
