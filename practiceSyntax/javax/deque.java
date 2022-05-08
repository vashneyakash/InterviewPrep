package javax;

import java.util.ArrayDeque;
import java.util.Deque;

public class deque {
    public static void main(String[] args) {
        Deque<Integer> a = new ArrayDeque<>();
        a.addFirst(100);
        a.addFirst(120);
        a.addLast(200);
        a.addLast(230);

        System.out.println("a.peekFirst() = " + a.peekFirst());
        System.out.println("a.peekLast() = " + a.peekLast());
        System.out.println("a.isEmpty() = " + a.isEmpty());
        System.out.println("a.pollFirst() = " + a.pollFirst());
        System.out.println("a.pollLast() = " + a.pollLast());
        System.out.println("a.peekFirst() = " + a.peekFirst());
        System.out.println("a.peekLast() = " + a.peekLast());
        System.out.println("a.isEmpty() = " + a.isEmpty());

    }
}
