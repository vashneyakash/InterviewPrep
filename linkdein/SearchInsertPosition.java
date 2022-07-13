package linkdein;

import debug.UsefulPrinting;

public class SearchInsertPosition {

    public static int getPositionForInsert(Integer[] arr, int val) {
        UsefulPrinting.print1DArray(arr);
        System.out.println("val = " + val);
        if (val < arr[0]) {
            return 0;
        }
        int lo = 0;
        int hi = arr.length -1;
        while (lo <= hi) {
            int mid = (lo + hi)/2;
            if (arr[mid] <= val && ((mid + 1) == arr.length || arr[mid + 1] > val)) {
                return mid +1;
            } else if (arr[mid] < val) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getPositionForInsert(new Integer[] {1, 4 , 6, 9, 10, 15, 23, 34, 56, 79}, 2));
        System.out.println(getPositionForInsert(new Integer[] {1, 4 , 6, 9, 10, 15, 23, 34, 56, 79}, -1));
        System.out.println(getPositionForInsert(new Integer[] {1, 4 , 6, 9, 10, 15, 23, 34, 56, 79}, 6));
        System.out.println(getPositionForInsert(new Integer[] {1, 4 , 6, 9, 10, 15, 23, 34, 56, 79}, 11));
        System.out.println(getPositionForInsert(new Integer[] {1, 4 , 6, 9, 10, 15, 23, 34, 56, 79}, 43));
        System.out.println(getPositionForInsert(new Integer[] {1, 4 , 6, 9, 10, 15, 23, 34, 56, 79}, 100));
    }
}
