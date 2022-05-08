package javax;

import java.util.HashSet;

public class hashSet {
    public static void main(String[] args) {
        HashSet<Integer> s = new HashSet<>();
        s.add(100);
        s.add(200);
        s.add(300);
        System.out.println("s.contains(200) = " + s.contains(200));
        System.out.println("s.remove(300) = " + s.remove(300));
        System.out.println("s.contains(300) = " + s.contains(300));
    }
}
