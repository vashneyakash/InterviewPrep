package linkdein;

public class RemoveDuplicatesFromSortedArray {
    /*
     *
     * */

    public static int removeDuplicates(Integer[] arr) {
        int current = 0;
        int n = arr.length;
        int i = 0;

        while (i < n)  {
            if (i == 0) {
                i++;
            } else if (i != 0 && arr[i] == arr[current]) {
                i++;
            } else {
                current++;
                arr[current] = arr[i];
                i++;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new Integer[] {1,1,1,2,2,3,4,4,5,5,5,6,6,6,6,6}));
    }
}
