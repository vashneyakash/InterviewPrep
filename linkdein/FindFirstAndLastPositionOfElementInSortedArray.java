package linkdein;

import debug.UsefulPrinting;

import java.util.AbstractMap;
import java.util.Map;

public class FindFirstAndLastPositionOfElementInSortedArray {
    // Do ceil and floor binary search

    public static int getLowerIndex(Integer[] arr, int val) {
        int lo = 0;
        int hi = arr.length -1;

        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if (arr[mid] == val && (mid == 0 || arr[mid-1] != val)) {
                return mid;
            } else if (arr[mid] < val) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static int getUpperIndex(Integer[] arr, int val) {
        int lo = 0;
        int hi = arr.length -1;

        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if (arr[mid] == val && (mid == (arr.length - 1) || arr[mid + 1] != val)) {
                return mid;
            } else if (arr[mid] > val) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }
    public static Map.Entry<Integer, Integer> findValueInterval(Integer[] arr, int val) {
        UsefulPrinting.print1DArray(arr);
        int lowerIndex = getLowerIndex(arr, val);
        int upperIndex = getUpperIndex(arr, val);

        return new AbstractMap.SimpleEntry<>(lowerIndex, upperIndex);
    }

    public static void main(String[] args) {
        System.out.println(findValueInterval(new Integer[] {2, 3, 3 , 4, 4, 5, 10, 10 , 10 ,10, 10, 13, 14, 15, 15, 20 , 28}, 10));
        System.out.println(findValueInterval(new Integer[] {2, 3, 3 , 4, 4, 5, 10, 10 , 10 ,10, 10, 10, 10, 10, 10, 10 , 10}, 10));
        System.out.println(findValueInterval(new Integer[] {10, 10, 10 , 10, 10, 10, 10, 10 , 10 ,10, 10, 10, 10, 10, 10, 10 , 10}, 10));
    }
}
