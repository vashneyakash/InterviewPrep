package google.java;

import java.util.List;
import java.util.stream.IntStream;

public class DivideChocolate {
    /*
    * Brute Force:
    * there are n elements we can separate them in n C k ways
    * generate all possible partitions and find solution
    * */

    /*
    * Optimal Solution:
    * The lowest sweetness level could be 1 and Highest sweetness level can be 10^5
    * On closer look we can cap the Highest sweetness level to sum(arr)/(k+1) because we this could be the maximum minimum
    * */

    private final List<Integer> sweetnessBar;
    private final int numberOfCuts;

    public DivideChocolate(List<Integer> sweetnessBar, int numberOfCuts) {
        this.sweetnessBar = sweetnessBar;
        this.numberOfCuts = numberOfCuts;
    }

    public int maximumMinimumSweetnessSegmentAfterCutting() {
        int totalSweetnessOfChocolateBar = sweetnessBar.stream().flatMapToInt(IntStream::of).sum();
        int maximumSweetnessThreshold = totalSweetnessOfChocolateBar/(numberOfCuts + 1);
        int minimumSweetnessThreshold = sweetnessBar.stream().flatMapToInt(IntStream::of).min().getAsInt();

    }

    public int maximumMinimumSweetnessSegmentAfterCuttingUsingBinarySearch(int maximumSweetnessThreshold, int minimumSweetnessThreshold) {
        int mid = (maximumSweetnessThreshold + minimumSweetnessThreshold)/2;

        while (mid < ) {

        }
    }
}
