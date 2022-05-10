package javax;

import java.util.*;

public class treeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> m = new TreeMap<>();
        TreeMap<streams.Person, Integer> mapper = new TreeMap<>(Comparator.comparingInt(streams.Person::rating));

        m.put("Anurag", 100);
        m.put("M", 500);
        m.put("Akash", 300);
        m.put("Anuj", 400);

        Map.Entry<String, Integer> entry = m.ceilingEntry("K");
        System.out.println("entry = " + entry);
        System.out.println("m.ceilingKey(\"K\") = " + m.ceilingKey("K"));

        System.out.println("m.floorEntry(\"K\") = " + m.floorEntry("K"));
        System.out.println("m.floorKey(\"K\") = " + m.floorKey("K"));

        System.out.println("m.containsKey(\"Anurag\") = " + m.containsKey("Anurag"));
    }
}
