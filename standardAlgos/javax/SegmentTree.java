package javax;

import java.util.*;
import java.util.function.BiFunction;

public class SegmentTree <T> {
    private final List<T> segmentTree;
    private final BiFunction<T, T, T> binaryOperationForSegmentTree;

    public SegmentTree(List<T> inputArray, final BiFunction<T, T, T> binaryOperationForSegmentTree) {
        this.segmentTree = new ArrayList<>(Collections.nCopies(2 * inputArray.size(), (T) null));
        this.binaryOperationForSegmentTree = binaryOperationForSegmentTree;
        buildSegmentTree(0, 0, inputArray.size() - 1, inputArray);
    }

    private T buildSegmentTree(int segmentTreeIndex, int segmentStartIndex, int segmentEndIndex, List<T> inputArray) {
        if (segmentStartIndex == segmentEndIndex) {
            segmentTree.set(segmentTreeIndex, inputArray.get(segmentStartIndex));
        } else {
            int midPointOfSegment = (segmentStartIndex + segmentEndIndex) / 2;
            T firstHalfSegment = buildSegmentTree(2 * segmentTreeIndex + 1, segmentStartIndex, midPointOfSegment, inputArray);
            T secondHalfSegment = buildSegmentTree(2 * segmentTreeIndex + 2, midPointOfSegment + 1, segmentEndIndex, inputArray);
            segmentTree.set(segmentTreeIndex, this.binaryOperationForSegmentTree.apply(firstHalfSegment, secondHalfSegment));
        }
        return segmentTree.get(segmentTreeIndex);
    }

//    public T query(int segmentStartIndex, int segmentEndIndex) {
//        return ;
//    }
}