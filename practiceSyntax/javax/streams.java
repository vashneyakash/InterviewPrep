package javax;

import java.util.stream.*;

public class streams {
    /*
    * 1. IntStream
    * 2. Stream
    * */

    public static void main(String[] args) {
        System.out.println("s = " + createStream());

        System.out.println("s.anyMatch(\"apple\"::equals) = " + createStream().anyMatch("apple"::equals));
        System.out.println("s.allMatch(a -> a.matches(\"[a - z] + \")) = " + createStream().allMatch(a -> a.matches("[a-z]+")));
        System.out.println("createStream().count() = " + createStream().count());
        System.out.println("createStream().distinct().collect(Collectors.toList()) = " + createStream().distinct().collect(Collectors.toList()));

        System.out.println("createIntStream().filter(a -> a%2 == 0).boxed().collect(Collectors.toList()) = " + createIntStream().filter(a -> a % 2 == 0).boxed().collect(Collectors.toList()));
        System.out.println("createIntStream().boxed().filter(a -> a%2 == 0).findFirst().get() = " + createIntStream().boxed().filter(a -> a % 2 == 0).findFirst().get());
        System.out.println("createIntStream().boxed().filter(a -> a%2 == 0).findAny().get() = " + createIntStream().boxed().filter(a -> a % 2 == 0).findAny().get());
        System.out.println("createIntStream().boxed().limit(3).collect(Collectors.toList()) = " + createIntStream().boxed().limit(3).collect(Collectors.toList()));

    }

    private static Stream<String> createStream() {
        return Stream.<String>builder()
                .add("apple")
                .add("orange")
                .add("banana")
                .add("banana")
                .add("papaya")
                .add("mango")
                .add("mango")
                .add("cucumber")
                .add("cucumber")
                .build();
    }

    private static IntStream createIntStream() {
        return IntStream.builder()
                .add(1)
                .add(2)
                .add(3)
                .add(4)
                .add(5)
                .add(6)
                .add(7)
                .add(8)
                .add(9)
                .build();
    }
}
