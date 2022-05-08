package javax;

import java.util.*;

public class sortedSet {
    public static void main(String[] args) {
        TreeSet<Integer> s = new TreeSet<>();
        Set<streams.Person> personSet = new TreeSet<>(Comparator.comparingInt(streams.Person::rating));
        personSet.add(new streams.Person("A", 100, 2., 120, null));
        s.add(10);
        s.add(10);
        s.add(20);
        s.add(40);
        s.add(99);
        s.add(150);
        s.add(50);
        s.add(20);
        s.add(100);

        System.out.println("s.contains(10) = " + s.contains(10));
        System.out.println("s.contains(50) = " + s.contains(50));
        System.out.println("s.remove(10) = " + s.remove(10));
        System.out.println("s.contains(10) = " + s.contains(10));
        System.out.println("s.floor(100) = " + s.floor(100));
        System.out.println("s.ceiling(100) = " + s.ceiling(100));
        System.out.println("s.higher(100) = " + s.higher(100));
        System.out.println("s.lower(100) = " + s.lower(100));

        SortedSet<Integer> integers = s.subSet(40, 100);

        System.out.println("s.pollFirst() = " + s.pollFirst());
        System.out.println("s.pollLast() = " + s.pollLast());
        System.out.println("s.first() = " + s.first());
        System.out.println("s.last() = " + s.last());

        Iterator<Integer> iter = s.descendingIterator();
        while (iter.hasNext()) {
            System.out.println("iter.next() = " + iter.next());
        }
    }
}
