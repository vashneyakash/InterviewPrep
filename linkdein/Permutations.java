package linkdein;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private final List<String> allPermutations = new ArrayList<>();

    public void listAllPossiblePermutations(int index, int n, boolean[] visited, StringBuilder perm) {
        if (index == n) {
            allPermutations.add(perm.toString());
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    perm.append(i);
                    listAllPossiblePermutations(index+1, n, visited, perm);
                    perm.deleteCharAt(perm.length() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    public List<String> allPermutations() {
        return allPermutations;
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        p.listAllPossiblePermutations(0, 5, new boolean[]{false, false, false, false, false}, new StringBuilder());
        System.out.println(p.allPermutations());
    }
}
