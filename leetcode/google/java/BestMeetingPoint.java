package google.java;

import java.util.ArrayList;
import java.util.List;

public class BestMeetingPoint {
    /*
    * Solution:
    * 1. Store row indices and col indices where arr[i][j] == 1
    * 2. sort rows and columns
    * 3. Find the median points r/2 and c/2
    * 4. Find distance of the points from median point
    * */

    public static int findMinTotalDistance(int[][] arr) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for(int i=0;i < arr.length; i++) {
            for (int j=0;j< arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        rows.sort(Integer::compare);
        cols.sort(Integer::compare);
        int dist = 0;

        for (int r : rows) {
            dist += Math.abs(r - rows.get(rows.size()/2));
        }

        for (int c : cols) {
            dist += Math.abs(c - cols.get(cols.size()/2));
        }

        return dist;
    }

    public static void main(String[] args) {
        int grid[][] = {{1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0}};
        System.out.println(findMinTotalDistance(grid));
        int g[][] = {{1, 0, 1, 0, 1},
            {0, 1, 0, 0, 0},
            {0, 1, 1, 0, 0}};
        System.out.println(findMinTotalDistance(g));

    }
}
