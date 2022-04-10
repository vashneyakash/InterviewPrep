package google.java;

public class TheSkylineProblem {
    /*
    * LeetCode - https://leetcode.com/problems/the-skyline-problem/
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
    * 1. For every building store left and right line. Meaning (buildingId, height, LeftCord) & (buildingId, height, rightCord)
    * 2. sort lines based on coordinate and height.
    * 3. Iterate through each line
    *   3.1 Determine if some part of the current line will be visible
    *       viewPointHeight <= currentLine.Height
    *       If yes store upper point of the line
    * */
}
