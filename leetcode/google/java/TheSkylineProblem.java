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

    public List<List<Integer>> computeSkyLine() {
        List<BuildingsAxes> buildingsAxesList = new ArrayList<>();
        buildingCoordinates.forEach(buildingCoord -> {
            buildingsAxesList.add(new BuildingsAxes(new Coordinates(buildingCoord.startXCoordinate(), buildingCoord.height()), true));
            buildingsAxesList.add(new BuildingsAxes(new Coordinates(buildingCoord.endXCoordinate(), buildingCoord.height()), false));
        });

        buildingsAxesList.sort((b1, b2) -> {
            if (b1.coordinates().x() == b2.coordinates().x()) {
                if (b1.isStart() && b2.isStart()) {
                    return Integer.compare(b2.coordinates().y(), b1.coordinates().y());
                } else if (!b1.isStart() && !b2.isStart()) {
                    return Integer.compare(b1.coordinates().y(), b2.coordinates().y());
                } else {
                    if (b1.isStart()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            } else {
                return Integer.compare(b1.coordinates().x(), b2.coordinates().x());
            }
        });

//        System.out.println(buildingsAxesList);

        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, Integer> overlappingBuildingsHeightSet = new TreeMap<>();
        overlappingBuildingsHeightSet.put(0, 1);
        buildingsAxesList.forEach(b -> {
            if (b.isStart()) {
                int currentMax = overlappingBuildingsHeightSet.lastKey();
                overlappingBuildingsHeightSet.put(b.coordinates().y(), Optional.ofNullable(overlappingBuildingsHeightSet.get(b.coordinates().y())).orElse(0) + 1);
                int newMax = overlappingBuildingsHeightSet.lastKey();
                if (currentMax != newMax) {
                    result.add(Arrays.asList(b.coordinates().x(), newMax));
                }
            } else {
                int currentMax = overlappingBuildingsHeightSet.lastKey();
                if (overlappingBuildingsHeightSet.get(b.coordinates().y()) > 1) {
                    overlappingBuildingsHeightSet.put(b.coordinates().y(), overlappingBuildingsHeightSet.get(b.coordinates().y()) -1);
                } else {
                    overlappingBuildingsHeightSet.remove(b.coordinates().y());
                }
                int newMax = overlappingBuildingsHeightSet.lastKey();
                if (currentMax != newMax) {
                    result.add(Arrays.asList(b.coordinates().x(), newMax));
                }
            }
        });
        return result;
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

    public static class BuildingsAxes implements Comparator<BuildingsAxes> {
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

        @Override
        public int compare(BuildingsAxes b1, BuildingsAxes b2) {
            if (b1.coordinates().x() == b2.coordinates().x()) {
                if (b1.isStart() && b2.isStart()) {
                    return Integer.compare(b1.coordinates().y(), b2.coordinates().y());
                } else if (!b1.isStart() && !b2.isStart()) {
                    return Integer.compare(b1.coordinates().y(), b2.coordinates().y());
                } else {
                    if (b1.isStart()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            } else {
                return Integer.compare(b1.coordinates().x(), b2.coordinates().x());
            }
        }

        @Override
        public String toString() {
            return String.format("{ coordinates=%s, isStart=%s }", this.coordinates, this.isStart);
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

        @Override
        public String toString() {
            return String.format("{ x=%s, y=%s }", this.x, this.y);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new TheSkylineProblem(Arrays.asList(new BuildingCoordinates(0,2,3),
//                new BuildingCoordinates(2,5,3))).computeSkyLine());

        System.out.println(new TheSkylineProblem(Arrays.asList(
                new BuildingCoordinates(2,9,10),
                new BuildingCoordinates(3,7,15),
                new BuildingCoordinates(5,12,12),
                new BuildingCoordinates(15,20,10),
                new BuildingCoordinates(19,24,8)
        )).computeSkyLine());
    }
}
