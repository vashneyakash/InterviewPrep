package javax;

import java.util.LinkedList;

public class linkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(100);
        linkedList.addLast(43);
        linkedList.addFirst(23);

        System.out.println("linkedList.isEmpty() = " + linkedList.isEmpty());
        System.out.println("linkedList.size() = " + linkedList.size());

        System.out.println("linkedList.pollFirst() = " + linkedList.peekFirst());
        System.out.println("linkedList.pollLast() = " + linkedList.peekLast());

        System.out.println("linkedList.pollFirst() = " + linkedList.pollFirst());
        System.out.println("linkedList.pollLast() = " + linkedList.pollLast());

        System.out.println("linkedList = " + linkedList);
    }
}
