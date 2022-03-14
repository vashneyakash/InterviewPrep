package google.java;

import java.util.ArrayList;
import java.util.List;

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

    }

    public int compute() {
        int sum = 0;
        for (int i = 0; i < bars.size(); i++) {
            if (i !=0 && i != (bars.size() - 1)) {
                int leftMax = segmentTree.query(0, 0, );
            }
        }
        return sum;
    }

    class SegmentTree {
        private final int size;
        private final List<Integer> segmentTree;

        SegmentTree(List<Integer> input) {
            this.size = input.size() * 2;
            this.segmentTree = new ArrayList<>();
            build(0, 0, size - 1, input);
        }

        private void build(int index, int si, int se, List<Integer> input) {
            if (si == se) {
                segmentTree.set(index, input.get(si));
            }
            int mid = (si + se) / 2;
            build(2 * index + 1, si, mid, input);
            build(2 * index + 2, mid + 1, se, input);
            segmentTree.set(index, Integer.max(segmentTree.get(2 * index + 1), segmentTree.get(2 * index + 2)));
        }

        public int query(int index, int si, int se, int qs, int qe) {
            if (si <= qs && qe <= se) {
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
