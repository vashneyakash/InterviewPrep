package javax;

import java.util.*;
import java.util.function.BiFunction;

public class SegmentTree <T> {
    private final int inputSize;
    private final int segmentTreeSize;
    private final List<T> segmentTree;
    private final BiFunction<T, T, T> binaryOperationForSegmentTree;

    public SegmentTree(List<T> inputArray, final BiFunction<T, T, T> binaryOperationForSegmentTree) {
        this.inputSize = inputArray.size();
        this.segmentTreeSize = 2 * inputArray.size();
        this.segmentTree = new ArrayList<>(Collections.nCopies(segmentTreeSize, (T) null));
        this.binaryOperationForSegmentTree = binaryOperationForSegmentTree;
        buildSegmentTree(0, new Segment(0, inputSize - 1), inputArray);
    }

    private T buildSegmentTree(int segmentTreeNodeIndex, Segment segment, List<T> inputArray) {
        if (segment.containSingleElement()) {
            segmentTree.set(segmentTreeNodeIndex, inputArray.get(segment.startIndex()));
        } else {
            T firstHalfSegment = buildSegmentTree(2 * segmentTreeNodeIndex + 1, new Segment(segment.startIndex(), segment.midPoint()), inputArray);
            T secondHalfSegment = buildSegmentTree(2 * segmentTreeNodeIndex + 2, new Segment(segment.midPoint() + 1, segment.endIndex()), inputArray);
            segmentTree.set(segmentTreeNodeIndex, this.binaryOperationForSegmentTree.apply(firstHalfSegment, secondHalfSegment));
        }
        return segmentTree.get(segmentTreeNodeIndex);
    }

    public Optional<T> query(Segment querySegment) {
        return query(0, new Segment(0, inputSize - 1), querySegment);
    }

    private Optional<T> query(int segmentTreeNodeIndex, Segment segment, Segment querySegment) {
        if (querySegment.contains(segment)) {
            return Optional.of(segmentTree.get(segmentTreeNodeIndex));
        } else if (querySegment.isDisjoint(segment)) {
            return Optional.empty();
        } else {
            Optional<T> firstHalfSegment = query(2 * segmentTreeNodeIndex + 1, new Segment(segment.startIndex(), segment.midPoint()), querySegment);
            Optional<T> secondHalfSegment = query(2 * segmentTreeNodeIndex + 2, new Segment(segment.midPoint() + 1, segment.endIndex()), querySegment);
            if (firstHalfSegment.isPresent() && secondHalfSegment.isPresent()) {
                return Optional.of(this.binaryOperationForSegmentTree.apply(firstHalfSegment.get(), secondHalfSegment.get()));
            } else {
                return Optional.ofNullable(firstHalfSegment.orElse(secondHalfSegment.orElse(null)));
            }
        }
    }

    public static class Segment {
        private final int startIndex;
        private final int endIndex;

        public Segment(int startIndex, int endIndex) {
            assert 0 <= startIndex;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public boolean containSingleElement() {
            return this.startIndex() == this.endIndex();
        }

        public int midPoint() {
            return (this.startIndex() + this.endIndex()) / 2;
        }

        public boolean contains(Segment other) {
            return this.startIndex <= other.startIndex() && other.endIndex() <= this.endIndex();
        }

        public boolean isDisjoint(Segment other) {
            return this.endIndex() < other.startIndex() || other.endIndex() < this.startIndex();
        }

        public int startIndex() {
            return startIndex;
        }

        public int endIndex() {
            return endIndex;
        }
    }

    public static void main(String[] args) {
        SegmentTree<Integer> maxSegmentTree = new SegmentTree<>(Arrays.asList(1, 2 ,5, 34, 24, 100, 3, 45, 21, 34), Math::max);

        System.out.println(maxSegmentTree.query(new Segment(0, 3)).orElse(0));
        System.out.println(maxSegmentTree.query(new Segment(2, 5)).orElse(0));
        System.out.println(maxSegmentTree.query(new Segment(6, 8)).orElse(0));
        System.out.println(maxSegmentTree.query(new Segment(1, 7)).orElse(0));
        System.out.println(maxSegmentTree.query(new Segment(4, 6)).orElse(0));
    }
}