package linkdein;

import java.util.*;

public class MedianOfTwoSortedArrays {

    public static double findMedianOfSortedArrays(int[] arr1, int[] arr2) {
        List<Integer> arr = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i< arr1.length || j < arr2.length) {
            if (i< arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    arr.add(arr1[i]);
                    i++;
                } else {
                    arr.add(arr2[j]);
                    j++;
                }
            } else if (i< arr1.length) {
                arr.add(arr1[i]);
                i++;
            } else {
                arr.add(arr2[j]);
                j++;
            }
        }

        if (arr.size() %2 == 0) {
            return (arr.get(arr.size()/2) + arr.get(arr.size()/2 - 1))/2.0;
        } else {
            return arr.get(arr.size()/2);
        }
    }

    public static void main(String[] args) {
        System.out.println("MedianOfTwoSortedArrays.findMedianOfSortedArrays(new int[] {1, 3}, new int[] {2}) = " + MedianOfTwoSortedArrays.findMedianOfSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println("MedianOfTwoSortedArrays.findMedianOfSortedArrays(new int[]{1, 2}, new int[] {3, 4}) = " + MedianOfTwoSortedArrays.findMedianOfSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
