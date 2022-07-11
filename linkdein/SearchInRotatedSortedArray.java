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
        int n = arr.length;

        while (lo <= hi) {
            int mid = (lo + hi)/2;
//            System.out.println("mid = " + mid + " " + "lo = " + lo + " " + "hi = " + hi);
            if (arr[(mid - 1 + n)%n] > arr[mid] && arr[mid] < arr[(mid + 1)%n]) {
                return mid;
            } else if (arr[mid] < arr[lo]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return 0;
    }

    public static int findIndexWithOffset(int index, int offset, int n) {
        return (index + offset)%n;
    }
    public static int binarySearchWithOffset(int[] arr, int val, int offset) {
        int lo = 0;
        int hi = arr.length -1;

        while (lo <= hi) {
            int mid = (lo + hi)/2;
            int actualIndex = findIndexWithOffset(mid, offset, arr.length);
//            System.out.println("mid = " + mid + " actualIndex = " + actualIndex + " lo = " + lo + " hi = " + hi);
            if (arr[actualIndex] == val) {
                return actualIndex;
            } else if (arr[actualIndex] > val) {
                hi = mid -1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    public static int findIndex(int[] arr, int val) {
        int offset = offsetRotationIndex(arr);
//        System.out.println("offset = " + offset);
        return binarySearchWithOffset(arr, val, offset);
    }

    public static void main(String[] args) {
        System.out.println(offsetRotationIndex(new int[]{3,4,5,0,1,2}));
        System.out.println(offsetRotationIndex(new int[]{10, 12, 14, 15, 20, 0, 1, 9}));
        System.out.println(offsetRotationIndex(new int[]{10, 12, 14, 15, 20, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));

        System.out.println("---------------");
        System.out.println(findIndex(new int[]{3,4,5,0,1,2}, 3));
        System.out.println(findIndex(new int[]{3,4,5,0,1,2}, 4));
        System.out.println(findIndex(new int[]{3,4,5,0,1,2}, 5));
        System.out.println(findIndex(new int[]{3,4,5,0,1,2}, 0));
        System.out.println(findIndex(new int[]{3,4,5,0,1,2}, 1));
        System.out.println(findIndex(new int[]{3,4,5,0,1,2}, 2));

        System.out.println("++++++++++++++++");
        System.out.println(findIndex(new int[]{10, 12, 14, 15, 20, 0, 1, 9}, 14));
        System.out.println(findIndex(new int[]{10, 12, 14, 15, 20, 0, 1, 9}, 1));
        System.out.println(findIndex(new int[]{10, 12, 14, 15, 20, 0, 1, 9}, 12));
        System.out.println(findIndex(new int[]{10, 12, 14, 15, 20, 0, 1, 9}, 9));
        System.out.println(findIndex(new int[]{10, 12, 14, 15, 20, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 15));
    }
}
