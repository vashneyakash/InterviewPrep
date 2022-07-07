package linkdein;

public class SearchInRotatedSortedArray {
    /*
    * 1. Find if the array is rotated or not by checking start and end elements
    * 2. Find the inflection point by binary search
    * 3. Find the ele using rotation formulae
    * */

    public static int offsetRotationIndex(int[] arr) {
        if (arr[0] < arr[arr.length - 1]) return 0;
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi)/2;
            System.out.println("mid = " + mid + " " + "lo = " + lo + " " + "hi = " + hi);
            if ((mid == 0 || arr[mid - 1] > arr[mid]) && (mid == (arr.length -1) || arr[mid] < arr[mid + 1])) {
                return mid;
            } else if (arr[mid] < arr[lo]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return 0;
    }

    public static int findIndex(int[] arr) {
        int n = arr.length;
        int offset = offsetRotationIndex(arr);

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(offsetRotationIndex(new int[]{3,4,5,0,1,2}));
    }
}
