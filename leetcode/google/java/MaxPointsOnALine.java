package google.java;

import java.util.*;
import java.lang.*;

public class MaxPointsOnALine {
    /*
        get the slope and intercept for every line.
        sort by slope and intercept or find the count of slope and intercepts.
        find the line with maximum points and return the count
    */

    private final List<Point> points;
    public MaxPointsOnALine(List<Point> points) {
        this.points = points;
    }

    public int computeMaxPointsOnSameLine() {
        int count = 0;
//        List<>
        return count;
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
    }

    public static class Line {
        private final double slope;
        private final double yIntercept;
        private final double marginOfError = 0.001;

        public Line(double slope, double yIntercept) {
            this.slope = slope;
            this.yIntercept = yIntercept;
        }

        public double slope() { return slope;}
        public double yIntercept() { return yIntercept; }

        public boolean isSameLine(Line o) {
            return (o.slope() - marginOfError <= slope && slope <= o.slope() + marginOfError);
        }
    }
}
