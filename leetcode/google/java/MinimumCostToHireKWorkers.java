package google.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumCostToHireKWorkers {

    /*
    * Solution -
    * Lets say quality are [a,b,c,d] and wages are [p,q,r,s]
    * Then effective quality w.r.t to a is [1, b/a, c/a, d,a]
    * Then effective payment w.r.t to a is [p, b/a * p, c/a * p, d/a * p]
    *
    * Let's say we have k people to find the minimum base wage of that group
    * q <= (b/a) * p or a/p <= b/q or q/b <= p/a
    * Either take the element with least quality/wage ratio Or take the highest wage/quality element
    * */

    private final int n;
    private final int k;
    private final List<Worker> workers;
    public MinimumCostToHireKWorkers(int k, List<Integer> qualities, List<Integer> wages) {
        this.n = qualities.size();
        this.k = k;
        this.workers = IntStream.range(0, qualities.size())
                .mapToObj(index -> new Worker(qualities.get(index), wages.get(index)))
                .collect(Collectors.toList());
    }

    public double compute() {
        workers.sort(Comparator.comparingDouble(Worker::qualityToWageRatio));
        double minWage = 100000000;
        for (int i=0; i< n; i++) {
            double minWageForCurrentSeg = workers.get(i).getWage();
            int cnt = 1;
            for (int j = i + 1; cnt != k && j < n; j++) {
                double wageForCurrentWorker = ((double) workers.get(j).getQuality()/workers.get(i).getQuality()) * workers.get(i).getWage();
                if (wageForCurrentWorker >= workers.get(j).getWage()) {
                    cnt++;
                    minWageForCurrentSeg += wageForCurrentWorker;
                }
            }

            if (cnt == k) {
                minWage = Math.min(minWage, minWageForCurrentSeg);
            }
        }
        return minWage;
    }

    class Worker {
        private final Integer quality;
        private final Integer wage;

        Worker(Integer quality, Integer wage) {
            this.quality = quality;
            this.wage = wage;
        }

        public Integer getQuality() {
            return quality;
        }

        public Integer getWage() {
            return wage;
        }

        public double qualityToWageRatio() {
            return (double) getQuality()/getWage();
        }
    }

    public static void main(String[] args) {
        MinimumCostToHireKWorkers a = new MinimumCostToHireKWorkers(3, Arrays.asList(3,1,10,10,1), Arrays.asList(4,8,2,2,7));
        System.out.println(a.compute());
//        MinimumCostToHireKWorkers a = new MinimumCostToHireKWorkers(2, Arrays.asList(10,20,5), Arrays.asList(70,50,30));
//        System.out.println(a.compute());
    }

//    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
//        MinimumCostToHireKWorkers a = new MinimumCostToHireKWorkers(k, IntStream.of(quality).boxed().collect(Collectors.toList()), IntStream.of(wage).stream().boxed().collect(Collectors.toList()));
//        return (a.compute());
//
//    }

}
