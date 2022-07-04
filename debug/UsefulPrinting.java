package debug;

public class UsefulPrinting {
    public static <T> void print2DArray(T[][] arr) {
        print2DArray(arr, 0, 0, arr.length, arr.length > 0 ? arr[0].length : 0);
    }

    public static <T> void print2DArray(T[][] arr, int startI, int startJ, int endI, int endJ) {
        for (int i = startI; i < endI && i < arr.length; i++) {
            for (int j = startJ; j < endJ && j < arr[i].length; j++) {
                System.out.printf("[%s][%s]:%s ", i, j, arr[i][j]);
            }
            System.out.println();
        }
    }

    public static <T> void print1DArray(T[] arr) {
        print1DArray(arr, 0, arr.length);
    }

    public static <T> void print1DArray(T[] arr, int start, int end) {
        for (int i = start; i < end && i < arr.length; i++) {
                System.out.printf("[%s]:%s ", i, arr[i]);
        }
        System.out.println();
    }
}
