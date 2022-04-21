package google.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CountOfSmallerNumbersAfterSelf {

    /*
     * Solution:
     * Solve it as merge sort
     * Recursively divide array into halves and then merge them in correct order
     * When merging count the number of right swaps for an element
     * */

    private final List<Integer> inputs;

    public CountOfSmallerNumbersAfterSelf(final List<Integer> inputs) {
        this.inputs = inputs;
    }

    public List<Integer> computeSmallerNumberCount() {
        List<NumberAndSmallerNumberCount> numberAndSmallerNumberCount = inputs.stream().map(NumberAndSmallerNumberCount::new).collect(Collectors.toList());

        mergeSort(0, inputs.size() -1, numberAndSmallerNumberCount);
        Map<Integer, LinkedList<Integer>> countMap = new HashMap<>();
        numberAndSmallerNumberCount.forEach(a -> {
            countMap.computeIfAbsent(a.number(), __ -> new LinkedList<>()).add(a.smallerNumberCount());
        });
        return inputs.stream().map(a -> countMap.get(a).removeFirst()).collect(Collectors.toList());
    }

    private void mergeSort(int startIndex, int endIndex, List<NumberAndSmallerNumberCount> toBeSorted) {
        if (startIndex == endIndex || endIndex < startIndex) {
            return;
        }
        int mid = (endIndex - startIndex)/2 + startIndex;
//        System.out.println("startIndex = " + startIndex + " endIndex = " + endIndex + " mid = " + mid + " mid+1 = " + (mid+1));
        mergeSort(startIndex, mid, toBeSorted);
        mergeSort(mid + 1, endIndex, toBeSorted);

        List<NumberAndSmallerNumberCount> temp = new ArrayList<>();
        int ptr1 = startIndex;
        int ptr2 = mid+1;
        int secondHalfSize = endIndex - mid;
        while (ptr1 <= mid && ptr2 <= endIndex) {
            if (toBeSorted.get(ptr1).number() <= toBeSorted.get(ptr2).number()) {
                if (toBeSorted.get(ptr1).number() < toBeSorted.get(ptr2).number())
                    toBeSorted.get(ptr1).increment(ptr2 - mid - 1);
                temp.add(toBeSorted.get(ptr1));
                ptr1++;
            } else {
                temp.add(toBeSorted.get(ptr2));
                ptr2++;
            }
        }

        while (ptr1 <= mid) {
            toBeSorted.get(ptr1).increment(secondHalfSize);
            temp.add(toBeSorted.get(ptr1));
            ptr1++;
        }

        while (ptr2 <= endIndex) {
            temp.add(toBeSorted.get(ptr2));
            ptr2++;
        }

//        System.out.println("startIndex = " + startIndex);
//        System.out.println("endIndex = " + endIndex);
//        System.out.println("mid = " + mid);
//        System.out.println("temp = " + temp);

        for (int i = startIndex; i<= endIndex; i++) {
            toBeSorted.set(i, temp.get(i - startIndex));
        }
//        System.out.println("toBeSorted = " + toBeSorted);
//        System.out.println("-------------");
    }


    public static class NumberAndSmallerNumberCount {
        private final int number;
        private int smallerNumberCount;

        public NumberAndSmallerNumberCount(int number) {
            this.number = number;
            this.smallerNumberCount = 0;
        }

        public int number() {
            return number;
        }

        public int smallerNumberCount() {
            return smallerNumberCount;
        }

        public void increment(int count) {
            this.smallerNumberCount = this.smallerNumberCount + count;
        }

        @Override
        public String toString() {
            return String.format("{ number=%s, smallerNumberCount=%s }", this.number, this.smallerNumberCount);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountOfSmallerNumbersAfterSelf(Arrays.asList(5,2,6,1)).computeSmallerNumberCount());
        System.out.println(new CountOfSmallerNumbersAfterSelf(Arrays.asList(-1)).computeSmallerNumberCount());
        System.out.println(new CountOfSmallerNumbersAfterSelf(Arrays.asList(-1, -1)).computeSmallerNumberCount());
    }
}

