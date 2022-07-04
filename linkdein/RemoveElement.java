package linkdein;

import debug.UsefulPrinting;

public class RemoveElement {

    public static int removeElement(Integer[] arr, int val) {
        int n = arr.length;
        int current = -1;
        for (int i =0; i< n;i++) {
            if (current == -1 && arr[i] == val) {
                 current = i;
            } else if (current != -1 && arr[i] != val) {
                arr[current] = arr[i];
                arr[i] = val;
                if (arr[current + 1] == val) {
                    current++;
                } else {
                    current = i;
                }
            }
        }

        UsefulPrinting.print1DArray(arr);
        return current - 1;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new Integer[]{0,2,3,1,2,4,1,1,4,5,6,1,1}, 1));
        System.out.println(removeElement(new Integer[]{1,1,1,1,1,1}, 1));
        System.out.println(removeElement(new Integer[]{1,1,1,1,1,1,2}, 1));
        System.out.println(removeElement(new Integer[]{1,1,1,1,1,1,2,3,4,5}, 1));
        System.out.println(removeElement(new Integer[]{1,2,3, 1, 1, 1,4,5}, 1));
    }
}
