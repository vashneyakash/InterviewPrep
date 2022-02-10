package javax;

import java.util.*;

public class DisjointSet {
    private final List<Integer> setIdentifier;
    private final List<Integer> rank;

    public DisjointSet(int collectionSize) {
        this.setIdentifier = new ArrayList<>(Collections.nCopies(collectionSize, null));
        this.rank = new ArrayList<>(Collections.nCopies(collectionSize, 0));
        this.makeSet();
    }

    private void makeSet() {
        for (int index = 0; index < setIdentifier.size(); index++) {
            setIdentifier.set(index, index);
        }
    }

    public int findGroupId(int index) {
        if (setIdentifier.get(index) != index) {
            return setIdentifier.set(index, findGroupId(setIdentifier.get(index)));
        } else {
            return index;
        }
    }

    public void mergeElements(int index1, int index2) {
        assert index1 >=0 && index1 < setIdentifier.size();
        assert index2 >=0 && index2 < setIdentifier.size();

        int groupIdOfIndex1 = findGroupId(index1);
        int groupIdOfIndex2 = findGroupId(index2);
        if (groupIdOfIndex1 != groupIdOfIndex2) {
            if (this.rank.get(groupIdOfIndex1) < this.rank.get(groupIdOfIndex2)) {
                this.setIdentifier.set(index1, groupIdOfIndex2);
            } else {
                this.setIdentifier.set(index2, groupIdOfIndex1);
                if (this.rank.get(groupIdOfIndex1).equals(this.rank.get(groupIdOfIndex2))) {
                    this.rank.set(index1, this.rank.get(index1) + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(5);
        System.out.println(disjointSet.findGroupId(3));
        disjointSet.mergeElements(1, 4);
        disjointSet.mergeElements(2, 3);
        System.out.println(disjointSet.findGroupId(1));
        System.out.println(disjointSet.findGroupId(4));
        System.out.println(disjointSet.findGroupId(2));
        System.out.println(disjointSet.findGroupId(3));
    }

}
