package javax;

import java.util.Optional;
import java.util.UUID;
import java.util.function.*;

public class functionalInterfaces {
    public static void main(String[] args) {
        Consumer<streams.Person> personConsumer = person -> {
            System.out.printf("person name : %s, rating %s%n", person.name(), person.rating());
        };

        Consumer<streams.Person> helloConsumer = person -> {
            System.out.printf("Hello %s !!! \n", person.name());
        };

        personConsumer.accept(new streams.Person("Anurag", 100, 100.0, 100L, null));

        personConsumer.andThen(helloConsumer).accept(new streams.Person("Dhoni", 50, 10.0, 10L, null));

        Function<streams.Person, String> personNameExtractor = streams.Person::name;
        Function<String, Integer> strLength = name -> Optional.ofNullable(name).map(String::length).orElse(0);
        Function<Integer, Double> lengthToInchConverter = l -> l/2.0;

        Double lengthInInch = strLength.compose(personNameExtractor).andThen(lengthToInchConverter).apply(new streams.Person("Anurag", 100, 100.0, 100L, null));
        Double alternateWay = personNameExtractor.andThen(strLength).andThen(lengthToInchConverter).apply(new streams.Person("Anurag", 100, 100.0, 100L, null));
        Double extraWay = lengthToInchConverter.compose(strLength.compose(personNameExtractor)).apply(new streams.Person("Anurag", 100, 100.0, 100L, null));
        System.out.println("lengthInInch = " + lengthInInch + "\n" + "alternateWay = " + alternateWay + "\n" + "extraWay = " + extraWay + "\n");

        Supplier<String> uuidSupplier = () -> UUID.randomUUID().toString();

        System.out.println("uuidSupplier.get() = " + uuidSupplier.get());
        System.out.println("uuidSupplier.get() = " + uuidSupplier.get());
        System.out.println("uuidSupplier.get() = " + uuidSupplier.get());

        Predicate<streams.Person> isTopPlayer = p -> p.rating() > 100;
        Predicate<streams.Person> isConsistentPlayer = p -> p.average() > 20.0;

        System.out.println("isTopPlayer.test(new streams.Person(\"Anu\", 200, 100.0, 100, null)) = " + isTopPlayer.test(new streams.Person("Anu", 200, 100.0, 100, null)));
        System.out.println("isTopPlayer.and(isConsistentPlayer).test(new streams.Person(\"Anurag\", 101, 100.0, 100L, null)) = " + isTopPlayer.and(isConsistentPlayer).test(new streams.Person("Anurag", 101, 100.0, 100L, null)));
        System.out.println("isTopPlayer.negate().test(new streams.Person(\"Anurag\", 100, 100.0, 100L, null)) = " + isTopPlayer.negate().test(new streams.Person("Anurag", 100, 100.0, 100L, null)));
    }
}
