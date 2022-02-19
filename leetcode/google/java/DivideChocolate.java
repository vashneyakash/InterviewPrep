package google.java;

import java.util.Arrays;
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
//        int maximumSweetnessThreshold = totalSweetnessOfChocolateBar/(numberOfCuts + 1);
        int maximumSweetnessThreshold = totalSweetnessOfChocolateBar;
        int minimumSweetnessThreshold = sweetnessBar.stream().flatMapToInt(IntStream::of).min().getAsInt();
        return maximumMinimumSweetnessSegmentAfterCuttingUsingBinarySearch(maximumSweetnessThreshold, minimumSweetnessThreshold);
    }

    public int maximumMinimumSweetnessSegmentAfterCuttingUsingBinarySearch(int maximumSweetnessThreshold, int minimumSweetnessThreshold) {
        int mid;
        int hi = maximumSweetnessThreshold;
        int lo = minimumSweetnessThreshold;
        while (lo < hi) {
            mid = (lo + hi)/2;
            System.out.println(mid + " " + maximumSweetnessThreshold + " " + minimumSweetnessThreshold + " can : " + canDivide(mid));
            if (canDivide(mid) && !canDivide(mid -1)) {
                return mid;
            } else if (canDivide(mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    private boolean canDivide(int thresholdSweetness) {
        int sweetnessSum = 0;
        int cuts = 0;
        for (Integer part : sweetnessBar) {
            if (sweetnessSum + part >= thresholdSweetness) {
                cuts++;
                sweetnessSum = 0;
            } else {
                sweetnessSum += part;
            }
        }
        return cuts == this.numberOfCuts;
    }

    public static void main(String[] args) {
        DivideChocolate divideChocolate = new DivideChocolate(Arrays.asList(1,2,3,4,5,6,7,8,9), 5);
        System.out.println(divideChocolate.maximumMinimumSweetnessSegmentAfterCutting());
        divideChocolate = new DivideChocolate(Arrays.asList(5,6,7,8,9,1,2,3,4), 8);
        System.out.println(divideChocolate.maximumMinimumSweetnessSegmentAfterCutting());
        divideChocolate = new DivideChocolate(Arrays.asList(1,2,2,1,2,2,1,2,2), 2);
        System.out.println(divideChocolate.maximumMinimumSweetnessSegmentAfterCutting());
    }
}
