package javax;

import java.util.LinkedList;

public class linkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(100);
        linkedList.addFirst(23);
        linkedList.addLast(43);
        System.out.println("linkedList.getFirst() = " + linkedList.getFirst());
        System.out.println("linkedList.getLast() = " + linkedList.getLast());
    }
}
