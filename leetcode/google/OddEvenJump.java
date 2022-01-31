package google;

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
    *       get smallest element in array that in smaller or equal to this number
    *       int x
    *       return check(x)
    *   else:
    *       get just greater than this element in the array
    *       int x
    *       return check(x)
    */

    /*
    * Second approach :
    * We will maintain 2 boolean arrays, 1st array isEndReachableUsingOddJump. that will signify that we can reach to end using odd jump from this index
    * 2nd array isEndReachableUsingEvenJump, that will signify that we can reach to end using even jump from this index
    *
    * We will also maintain nextGreaterOrEqualElement array, that will contain the index of the element that is equal or greater than this element after this element in the array
    * We will also maintain nextSmallerOrEqualElement array, that will contain the index of the element that is equal or smaller than this element after this element in the array
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

    class OddEvenJumpData {
        private final List<Integer> values;
        private final List<Integer> nextGreaterOrEqualElement;
        private final List<Integer> nextSmallerOrEqualElement;
        private final List<Boolean> isEndReachableUsingOddJump;
        private final List<Boolean> isEndReachableUsingEvenJump;

        public OddEvenJumpData(List<Integer> values) {
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
            int cnt = 0;
            for (int index = 0; index < values.size(); index++) {
                cnt = cnt + (algoRun(index, true) ? 1 : 0);
            }
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

        private boolean algoRun(int index, boolean oddJump) {
            if (index >= values.size()-1) {
                return true;
            }
            if (this.isEndReachableUsingOddJump.get(index) != null) {
                return this.isEndReachableUsingOddJump.get(index);
            }

        }
    }
}
