package google.java;

import java.util.Arrays;

public class SplitArrayLargestSum {
    /*
    * Optimal solution:
    * Try binary search.
    * Hi = Total sum of array
    * Lo = 0
    Use floor binary search to check if array can be broken in Mid but cannot be in Mid - 1
    * */

    public static int getMinimumLargestSum(int[] arr, int numberOfSubArrays) {
        int sum = Arrays.stream(arr).sum();
        if (numberOfSubArrays == 1) {
            return sum;
        }

        int lo = 0;
        int hi = sum;

        while(lo <= hi) {
            int mid = (lo + hi)/2;
            boolean canDivide = canDivide(arr, numberOfSubArrays, mid);
            System.out.println("lo = " + lo + " hi = " + hi + " mid = " + mid + " canDivide = " + canDivide);
            if (canDivide && !canDivide(arr, numberOfSubArrays, mid - 1)) {
                return mid;
            } else if (canDivide) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return sum;
    }

    public static boolean canDivide(int[] arr, int numberOfSubArrays, int maxSum) {
        int currentSum = 0;
        int segmentNumber = 1;
        for (int item = 0; item < arr.length; item++) {
            if (currentSum + arr[item] <= maxSum) currentSum = currentSum + arr[item];
            else if (arr[item] <= maxSum) {
                currentSum = arr[item];
                segmentNumber++;
            } else {
                return false;
            }
        }

        return segmentNumber <= numberOfSubArrays;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumLargestSum(new int[]{7,2,5,10,8}, 2));
        System.out.println(getMinimumLargestSum(new int[]{1,2,3,4,5}, 2));
        System.out.println(getMinimumLargestSum(new int[]{1,4,4}, 3));
    }
}