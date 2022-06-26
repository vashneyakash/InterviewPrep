package linkdein;

import java.util.*;
import java.lang.*;

public class MergeKSortedLists {
    /*
    * To merge K lists
    * 1. Merge 2 at a time Complexity O(K^2 * N)
    * 2. Insert all the 1st elements in priorityQueue. then 1 by 1 O (log(k) * k * n)
    * */

    public static LinkedList<Integer> mergeLists(final LinkedList<Integer> lists[]) {
        if (lists.length == 0) {
            throw new RuntimeException("list should not be empty or null");
        } else if (lists.length == 1) {
            return lists[0];
        } else {
            LinkedList<Integer> mergedList = new LinkedList<>();
        }
    }

    private static LinkedList<Integer> mergetLists(final LinkedList<Integer> first, final LinkedList<Integer> second) {
        LinkedList<Integer> mergedList = new LinkedList<>();

    }

    public static void main(String[] args) {
                    /// busy busy busy
    }
}
