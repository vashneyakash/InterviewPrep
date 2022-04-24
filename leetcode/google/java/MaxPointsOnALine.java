package google.java;

import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class MaxPointsOnALine {
    /*
get the slope and intercept for every line.
sort by slope and intercept or find the count of slope and intercepts.
find the line with maximum points and return the count

    Correct Approach
    Obs - if point x3,y3 lie on line y = mx + c (created using point 1 and point 2)
    then, m1 = m2, c is constant and will get cancelled out
    m1 = (y2 - y1)/(x2- x1) = m2 = (y3 - y2)/(x3 - x2)
    Steps:
loop i = 0 to n-1
create an inner loop j from j = i+1 to n-1
check it point j is duplicate of point i
store slope of point j & point i in a map
find the max for point i
    */

    public int computeMaxPointsOnSameLine(List<Point> points) {
        int count = 0;
        for (int i = 0; i < points.size(); i++) {
            int max = 0;
            int duplicate = 0;
            Map<String, Integer> slopeCounter = new HashMap<>();
            for (int j=i+1; j < points.size(); j++) {
                int dx = points.get(j).x() - points.get(i).x();
                int dy = points.get(j).y() - points.get(i).y();

                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }

                int gcd = gcd(dx, dy);
                if (gcd != 0) {
                    dx = dx / gcd;
                    dy = dy / gcd;
                }
                String key = dx + "," + dy;
                slopeCounter.put(key, slopeCounter.getOrDefault(key, 0) + 1);
                max = Math.max(max, slopeCounter.get(key));

            }
            count = Math.max(count, duplicate + max + 1);
        }

        return count;

    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }



    public static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() { return x;}

        public int y() { return y;}

        @Override
        public String toString() {
            return String.format("{ x=%s, y=%s }", this.x, this.y);
        }
    }

    public int maxPoints(int[][] points) {
        List<Point> p = Arrays.stream(points).map(a -> new Point(a[0], a[1])).collect(Collectors.toList());
        return new MaxPointsOnALine().computeMaxPointsOnSameLine(p);
    }

    public static void main(String[] args) {
        System.out.println(new MaxPointsOnALine()
                .computeMaxPointsOnSameLine(Arrays.asList(new Point(1, 1),
                        new Point(3, 2),
                        new Point(5, 3),
                        new Point(4, 1),
                        new Point(2, 3),
                        new Point(1, 4)
                )));
//        System.out.println(new MaxPointsOnALine()
//                .computeMaxPointsOnSameLine(Arrays.asList(new Point(1, 1),
//                        new Point(2, 2),
//                        new Point(3, 3)
//                )));
    }

}
