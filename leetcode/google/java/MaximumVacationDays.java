package google.java;

import java.util.*;
import java.lang.*;

public class MaximumVacationDays {
    /*
Create a adjacency list of all the routes
start dfs traversal from node 0, k
if dp[node][numberOfWeeksLeft] != -1 return dp[node][numberOfWeeksLeft];
traverse all the adjacent nodes i, with weeksLeft k-1
Store the result for current node in dp
    */
    int numberOfCities = 0;
    int[][] dp;
    int[][] flights;
    int[][] days;

    int dfs(int cityNumber, int numberOfWeeksLeft) {
        if (numberOfWeeksLeft == 1) {
            return days[cityNumber][numberOfWeeksLeft - 1];
        }
        if (dp[cityNumber][numberOfWeeksLeft] != -1) {
            return dp[cityNumber][numberOfWeeksLeft];
        }
        int holidaysAtCurrentCity = days[cityNumber][numberOfWeeksLeft - 1];
        int maxHolidays = 0;
        for (int j = numberOfWeeksLeft - 1; j > 0; j --) {
            for (int i = 0; i < numberOfCities; i++) {
                if (flights[cityNumber][i] == 1) {
                        maxHolidays = Math.max(maxHolidays, dfs(i, j) + holidaysAtCurrentCity);
                }
            }
            holidaysAtCurrentCity += days[cityNumber][j - 1];
        }
        maxHolidays = Math.max(maxHolidays, holidaysAtCurrentCity);
        dp[cityNumber][numberOfWeeksLeft] = maxHolidays;
        return maxHolidays;
    }

    public int maxVacationDays(int[][] flights, int[][] days) {
        numberOfCities = flights.length;
        dp = new int[flights.length][days[0].length + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        this.flights = flights;
        this.days = days;
        int maxHolidays = 0;
        for (int i = 0; i < numberOfCities; i++) {
            if (i==0 || flights[0][i] == 1)
                maxHolidays = Math.max(maxHolidays, dfs(i, days[0].length));
        }
        return maxHolidays;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumVacationDays().maxVacationDays(
                new int[][]{{0, 1, 1}, {1, 0, 1}, {1, 1, 0}},
                new int[][]{{1, 3, 1}, {6, 0, 3}, {3, 3, 3}}));

        System.out.println(new MaximumVacationDays().maxVacationDays(
                new int[][]{{0,0,0},{0,0,0},{0,0,0}},
                new int[][]{{1,1,1},{7,7,7},{7,7,7}}));

        System.out.println(new MaximumVacationDays().maxVacationDays(
                new int[][]{{0,1,1},{1,0,1},{1,1,0}},
                new int[][]{{7,0,0},{0,7,0},{0,0,7}}));
    }
}
