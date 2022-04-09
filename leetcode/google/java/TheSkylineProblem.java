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
    * */
}
