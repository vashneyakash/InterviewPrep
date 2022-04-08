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
}
