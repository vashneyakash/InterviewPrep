package google.java;

import java.util.*;

class kEmptySlots {

    public static void main(String[] args) {
        int n = 3;
        List<Integer> bloomingFlowerCoordinate = Arrays.asList(1, 3, 2);
        int k = 1;

        List<Integer> flowersBloomingDay = new ArrayList<>(n);
        for (int i = 0; i < n ; i++) {
            flowersBloomingDay.add(null);
        }
        for (int i = 0; i < bloomingFlowerCoordinate.size(); i++) {
            flowersBloomingDay.set(bloomingFlowerCoordinate.get(i), i);
        }

        int left = 0, right = k + 1, ans = 100000;
        for (int i = 0; right < n; i++) {
           if (i == right) {
               ans = Math.min(ans, Math.max(flowersBloomingDay.get(left), flowersBloomingDay.get(right)));
           } else if (flowersBloomingDay.get(i) < flowersBloomingDay.get(left) || flowersBloomingDay.get(i) < flowersBloomingDay.get(right)) {
               left = i;
               right = i + k + 1;
           }
        }

        System.out.println( (ans == 100000) ? -1 : ans);
    }
}