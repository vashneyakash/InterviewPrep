package google.java;

import java.util.*;

public class OddEvenJump {
    /*
     * Brute Force Approach :
     * for each index i:
     *   check if someone can get to last index using Check()
     *
     * check(int start) :
     *   if (start == end):
     *       return true
     *   if (start%2 == 0):
     *       get smallest element in java.array that in smaller or equal to this number
     *       int x
     *       return check(x)
     *   else:
     *       get just greater than this element in the java.array
     *       int x
     *       return check(x)
     */

    /*
     * Second approach :
     * We will maintain 2 boolean arrays, 1st java.array isEndReachableUsingOddJump. that will signify that we can reach to end using odd jump from this index
     * 2nd java.array isEndReachableUsingEvenJump, that will signify that we can reach to end using even jump from this index
     *
     * We will also maintain nextGreaterOrEqualElement java.array, that will contain the index of the element that is equal or greater than this element after this element in the java.array
     * We will also maintain nextSmallerOrEqualElement java.array, that will contain the index of the element that is equal or smaller than this element after this element in the java.array
     *
     * for each index:
     *   if (!visited[index]) {
     *       checkReachability(index, jumpData);
     *   }
     *
     * int cnt = 0
     * for each index:
     *   if (isEndReachableUsingOddJump[index]):
     *       cnt = cnt + 1
     *
     * print(cnt)
     * */

    private final List<Integer> values;
    private final List<Integer> nextGreaterOrEqualElement;
    private final List<Integer> nextSmallerOrEqualElement;
    private final List<Boolean> isEndReachableUsingOddJump;
    private final List<Boolean> isEndReachableUsingEvenJump;

    public OddEvenJump(List<Integer> values) {
        this.values = values;
        this.nextGreaterOrEqualElement = new ArrayList<>(values.size());
        this.nextSmallerOrEqualElement = new ArrayList<>(values.size());
        this.isEndReachableUsingOddJump = new ArrayList<>(values.size());
        this.isEndReachableUsingEvenJump = new ArrayList<>(values.size());

        for (int index = 0; index < values.size(); index++) {
            this.nextGreaterOrEqualElement.add(null);
            this.nextSmallerOrEqualElement.add(null);
            this.isEndReachableUsingOddJump.add(null);
            this.isEndReachableUsingEvenJump.add(null);
        }
        preProcess();
    }

    public int getCnt() {
        int cnt = 0;
        for (int index = 0; index < values.size(); index++) {
            cnt = cnt + (isEndReachableForIndex(index, true) ? 1 : 0);
        }
        return cnt;
    }

    private void preProcess() {
        TreeMap<Integer, Integer> valueToIndexMap = new TreeMap<>();
        for (int index = values.size() - 1; index >= 0; index--) {
            if (valueToIndexMap.ceilingEntry(values.get(index)) != null) {
                this.nextGreaterOrEqualElement.set(index, valueToIndexMap.ceilingEntry(values.get(index)).getValue());
            }
            if (valueToIndexMap.floorEntry(values.get(index)) != null) {
                this.nextSmallerOrEqualElement.set(index, valueToIndexMap.floorEntry(values.get(index)).getValue());
            }
            valueToIndexMap.put(values.get(index), index);
        }
    }

    private boolean isEndReachableForIndex(Integer index, boolean oddJump) {
        if (index >= values.size() - 1) {
            return true;
        }
        if (this.isEndReachableUsingOddJump.get(index) != null) {
            return this.isEndReachableUsingOddJump.get(index);
        }
        boolean isEndReachable = false;
        if (oddJump) {
            if (this.nextGreaterOrEqualElement.get(index) != null || index == values.size() - 1) {
                isEndReachable = isEndReachableForIndex(this.nextGreaterOrEqualElement.get(index), false);
                this.isEndReachableUsingOddJump.set(index, isEndReachable);
            }
        } else {
            if (this.nextSmallerOrEqualElement.get(index) != null || index == values.size() - 1) {
                isEndReachable = isEndReachableForIndex(this.nextSmallerOrEqualElement.get(index), true);
                this.isEndReachableUsingEvenJump.set(index, isEndReachable);
            }
        }
        return isEndReachable;
    }

    public static void main(String[] args) {
        int[] arr = {10,13,12,14,15};
        List<Integer> newArr = new ArrayList<>(arr.length);
        for (int j : arr) {
            newArr.add(j);
        }
        System.out.println(new OddEvenJump(newArr).getCnt());
    }
}
