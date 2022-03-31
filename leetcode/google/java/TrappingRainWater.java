package google.java;

import java.util.*;

public class TrappingRainWater {
    /*
     * Find left and right min and max for the bar using segment tree
     * find the water it can hold
     * */

    private final List<Integer> bars;
    private final SegmentTree segmentTree;
    public TrappingRainWater(List<Integer> bars) {
        this.bars = bars;
        segmentTree = new SegmentTree(bars);
    }

    public static void main(String[] args) {
        TrappingRainWater a = new TrappingRainWater(Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1));
        System.out.println(a.compute());
    }

    public int compute() {
        int sum = 0;
        for (int i = 0; i < bars.size(); i++) {
            if (i !=0 && i != (bars.size() - 1)) {
                int leftMax = segmentTree.query(0, 0, bars.size() - 1, 0, i -1);
                int rightMax = segmentTree.query(0, 0, bars.size() - 1, i +1, bars.size() - 1);
                int maxOverrflow = Math.max(Math.min(leftMax, rightMax) - bars.get(i), 0);
                sum = sum + (maxOverrflow);
            }
        }
        return sum;
    }

    class SegmentTree {
        private final int size;
        private final List<Integer> segmentTree;

        SegmentTree(List<Integer> input) {
            this.size = (int) Math.pow(2, Math.ceil(Math.log(input.size())/Math.log(2))) * 2;
            this.segmentTree = new ArrayList<>(Collections.nCopies(this.size, 0));
            build(0, 0, input.size() - 1, input);
        }

        private void build(int index, int si, int se, List<Integer> input) {
            System.out.println("index = " + index + ", si = " + si + ", se = " + se + ", input = " + input);
            if (si == se) {
                segmentTree.set(index, input.get(si));
                return;
            }
            int mid = (si + se) / 2;
            build(2 * index + 1, si, mid, input);
            build(2 * index + 2, mid + 1, se, input);
            segmentTree.set(index, Integer.max(segmentTree.get(2 * index + 1), segmentTree.get(2 * index + 2)));
        }

        public int query(int index, int si, int se, int qs, int qe) {
            if (qs <= si && se <= qe) {
                return segmentTree.get(index);
            } else if (se < qs || qe < si) {
                return -1;
            }
            int mid = (si + se) / 2;
            int a = query(2 * index + 1, si, mid, qs, qe);
            int b = query(2 * index + 2, mid + 1, se, qs, qe);
            return Integer.max(a, b);
        }
    }
}
