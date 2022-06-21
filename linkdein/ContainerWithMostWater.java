package linkdein;

import java.util.*;

public class ContainerWithMostWater {
    /*
    * Question : Find the pair of values such that min(a, b) * math.abs(indexOf(a), indexOf(b))
    * BruteForce:
    *   for (int i = 0; i < n; i++) {
    *       for (int j = 0; j < n; j++) {
    *           maxVolume = Math.max(maxVolume, Math.min(a[i], a[j]) * math.abs(i - j + 1));
    *       }
    *   }
    *
    * Wrong solution:
    * find the minimum height
    * maxVolume = Math.max(maxVolume, minHeight * (rightBound - leftBound +1));
    * recurse for left half and right half
    *
    * Wrong solution:
    * Maintain a stack of all just greater elements from end of queue
    *
    * Correct Approach:
    * Two pointer method
    * */

    public static int maxCapacity(int bars[]) {
        int n = bars.length;
        Stack<Map.Entry<Integer, Integer>> s = new Stack<>();
        int maxRect = 0;
        for (int i = n -1; i >=0; i--) {
            while (!s.isEmpty() && s.peek().getKey() > bars[i]) {
                Map.Entry<Integer, Integer> a = s.pop();
                maxRect = Math.max(maxRect, bars[i] * (Math.abs(a.getValue() - i)));
            }
            s.push(new AbstractMap.SimpleEntry<>(bars[i], i));
            System.out.println("i = " + i + " bars[i] = " + bars[i] + " " + " s = " + s + " " + "maxRect = " + maxRect + "\n");
        }
        while (!s.isEmpty()) {
            Map.Entry<Integer, Integer> a = s.pop();
            maxRect = Math.max(maxRect, a.getKey() * (a.getValue() + 1));
            System.out.println("a = " + a + " maxRect = " + maxRect + " s = " + s + "\n");
        }

        return maxRect;
    }

    public static int maxCapacityV2(int bars[]) {
        int left = 0;
        int right = bars.length - 1;
        int maxRect = 0;

        while(left < right) {
            maxRect = Math.max(maxRect, Math.min(bars[left], bars[right]) * (right - left));
            if (bars[left] < bars[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxRect;
    }

    public static void main(String[] args) {
        System.out.println("ContainerWithMostWater.maxCapacity(new int[] {1,8,6,2,5,4,8,3,7}) = " + ContainerWithMostWater.maxCapacity(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println("ContainerWithMostWater.maxCapacity(new int[] {1,8,6,2,5,4,8,3,7}) = " + ContainerWithMostWater.maxCapacityV2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
