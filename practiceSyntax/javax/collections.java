package javax;

import java.util.*;
import java.util.stream.Collectors;

public class collections {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "Akash", "Anurag", "Anuj");
        System.out.println("names = " + names);

        System.out.println("Collections.binarySearch(names, \"Anurag\") = " + Collections.binarySearch(names, "Anurag"));
        System.out.println("Collections.binarySearch(names, \"Anurag\", String::compareTo) = " + Collections.binarySearch(names, "Anurag", String::compareTo));

        List<String> anotherList = Arrays.asList("Prasuk", "Mrinal", "Shikhar", "Anurag", "Akash");
        System.out.println("Collections.disjoint(names, anotherList) = " + Collections.disjoint(names, anotherList));

        System.out.println("Collections.disjoint(Collections.emptySet(), Collections.emptySet()) = " + Collections.disjoint(Collections.emptySet(), Collections.emptySet()));

        List<String> a = new ArrayList<>(10);
        Collections.fill(a, "Anurag");
        Collections.fill(names, "Anurag");
        System.out.println("a = " + a);
        System.out.println("names = " + names);

        Random r = new Random();
        System.out.println("r.nextInt(50) = " + r.nextInt(50));
        System.out.println("r.nextDouble() = " + r.nextDouble());
        System.out.println("r.nextLong() = " + r.nextLong());
        System.out.println("r.ints(10, 100, 200).boxed().collect(Collectors.toList()) = " + r.ints(10, 100, 200).boxed().collect(Collectors.toList()));
    }
}
