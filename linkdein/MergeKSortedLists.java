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
            for (LinkedList<Integer> list: lists) {
                mergedList = mergedLists(list, mergedList);
            }
            return mergedList;
        }
    }

    private static LinkedList<Integer> mergedLists(final LinkedList<Integer> first, final LinkedList<Integer> second) {
        LinkedList<Integer> mergedList = new LinkedList<>();

        while (!first.isEmpty() && !second.isEmpty()) {
            if (first.peekFirst() < second.peekFirst()) {
                mergedList.add(first.pollFirst());
            } else {
                mergedList.add(second.pollFirst());
            }
        }

        while (!first.isEmpty()) {
            mergedList.add(first.pollFirst());
        }

        while (!second.isEmpty()) {
            mergedList.add(second.pollFirst());
        }

        return mergedList;
    }

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>(Arrays.asList(1, 4, 7, 10, 40));
        LinkedList<Integer> l2 = new LinkedList<>(Arrays.asList(10, 14, 18, 30, 32));
        LinkedList<Integer> l3 = new LinkedList<>(Arrays.asList(5, 6, 12, 15, 29));
        LinkedList<Integer> l4 = new LinkedList<>(Arrays.asList(7, 13, 17, 45));
        System.out.println(mergeLists(new LinkedList[] {l1, l2, l3, l4}));
    }
}
