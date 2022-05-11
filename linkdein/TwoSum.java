package linkdein;

import java.util.*;

public class TwoSum {
    public static List<Integer> compute(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach(set::add);
        int num = Arrays.stream(arr)
                .filter(a -> ((target - a) != a && set.contains(target - a)))
                .findAny()
                .orElse(-1);
        if (num == -1) {
            return Arrays.asList(-1, -1);
        }
        return Arrays.asList(num, target - num);
    }

    public static void main(String[] args) {
        System.out.println("TwoSum.compute(new int[] {2, 7, 11, 15}, 9) = " + TwoSum.compute(new int[]{2, 7, 11, 15}, 9));
    }
}
