package google.java;

import java.util.*;

public class TheSkylineProblem {
    /*
    * LeetCode - https://leetcode.com/problems/the-skyline-problem/
    * Solution - https://www.youtube.com/watch?v=GSBLe8cKu0s
    * Solution - https://www.geeksforgeeks.org/the-skyline-problem-using-divide-and-conquer-algorithm/
    *
    * BruteForce:
    * 1. Collect all the edge points of the building.
    * 2. Collection all the intersection points of all the buildings.
    * 3. Sort the points based on x, y
    * 4. Start with left most point
    *
    * Point currentPoint = X;
    * for (point: allPoints) {
    *   if (point is right of current) {
    *       add to list
    *       currentPoint = point
    *   } else if (point is directly above of current) {
    *       add to list
     *      currentPoint = point
    *   }
    * }
    *
    * Approach 2:
    * Look from the side.
    * 1. For every building store left and right line. Meaning (start, height, LeftCord) & (end, height, rightCord)
    * 2. sort lines based on coordinate and height.
    *   2.1 If the start of 2 buildings overlap then sort by height (decending)
    *   2.2 If the end of 2 buildings overlap than sort by height (ascending)
    *   2.3 If the start of 1 building overlap with end of other building then start should get preference
    * 3. Iterate through each line
    *   3.1 Determine if some part of the current line will be visible
    *       viewPointHeight <= currentLine.Height
    *       If yes store upper point of the line
    *   OR
    *   Maintain current max height in the TreeMap
    *   When we encounter start of the building add height to the map
    *   When we encounter end of the building remove height from the map
    *   If the current_max is changed then add the current x Value with max height to solution set
    */

    private final List<BuildingCoordinates> buildingCoordinates;
    public TheSkylineProblem(List<BuildingCoordinates> buildingCoordinates) {
        this.buildingCoordinates = buildingCoordinates;
    }

    public List<Coordinates> computeSkyLine() {
        List<BuildingsAxes> buildingsAxesList = buildingCoordinates.stream()
                .map(buildCoord -> new BuildingsAxes(new Coordinates(buildCoord.startXCoordinate)));
        TreeSet<Integer> overlappingBuildingsHeightSet = new TreeSet<>();

    }

    public static class BuildingCoordinates {
        private final Integer startXCoordinate;
        private final Integer endXCoordinate;
        private final Integer height;

        public BuildingCoordinates(Integer startXCoordinate, Integer endXCoordinate, Integer height) {
            this.startXCoordinate = startXCoordinate;
            this.endXCoordinate = endXCoordinate;
            this.height = height;
        }

        public Integer startXCoordinate() {
            return startXCoordinate;
        }

        public Integer endXCoordinate() {
            return endXCoordinate;
        }

        public Integer height() {
            return height;
        }
    }

    public static class BuildingsAxes {
        private final Coordinates coordinates;
        private final boolean isStart;

        public BuildingsAxes(Coordinates coordinates, boolean isStart) {
            this.coordinates = coordinates;
            this.isStart = isStart;
        }

        public Coordinates coordinates() {
            return coordinates;
        }

        public boolean isStart() {
            return isStart;
        }
    }

    public static class Coordinates {
        private final int x;
        private final int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }
    }
}
