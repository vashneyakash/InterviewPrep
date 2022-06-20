package linkdein;

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
    * Semi Optimal solution:
    * find the minimum height
    * maxVolume = Math.max(maxVolume, minHeight * (rightBound - leftBound +1));
    * recurse for left half and right half
    * */
}
