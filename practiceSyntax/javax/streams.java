package javax;

import java.util.*;
import java.util.stream.*;

public class streams {
    /*
    * 1. IntStream
    * 2. Stream
    * */

    public static void main(String[] args) {
        String[] fruits = {"Apple", "mango", "orange", "papaya", "ginger", "spinich", "coconut", "carrot", "potato", "tomato"};
        System.out.println("s = " + createStream());

        System.out.println("s.anyMatch(\"apple\"::equals) = " + createStream().anyMatch("apple"::equals));
        System.out.println("s.allMatch(a -> a.matches(\"[a - z] + \")) = " + createStream().allMatch(a -> a.matches("[a-z]+")));
        System.out.println("createStream().count() = " + createStream().count());
        System.out.println("createStream().distinct().collect(Collectors.toList()) = " + createStream().distinct().collect(Collectors.toList()));

        System.out.println("createIntStream().filter(a -> a%2 == 0).boxed().collect(Collectors.toList()) = " + createIntStream().filter(a -> a % 2 == 0).boxed().collect(Collectors.toList()));
        System.out.println("createIntStream().boxed().filter(a -> a%2 == 0).findFirst().get() = " + createIntStream().boxed().filter(a -> a % 2 == 0).findFirst().get());
        System.out.println("createIntStream().boxed().filter(a -> a%2 == 0).findAny().get() = " + createIntStream().boxed().filter(a -> a % 2 == 0).findAny().get());
        System.out.println("createIntStream().boxed().limit(3).collect(Collectors.toList()) = " + createIntStream().boxed().limit(3).collect(Collectors.toList()));

        System.out.println("createIntStream().boxed().min(Integer::compare).get() = " + createIntStream().boxed().min(Integer::compare).get());
        System.out.println("createIntStream().min() = " + createIntStream().min().getAsInt());
        System.out.println("createIntStream().boxed().max(Integer::compare).get() = " + createIntStream().boxed().max(Integer::compare).get());
        System.out.println("createIntStream().max() = " + createIntStream().max().getAsInt());
        System.out.println("createIntStream().noneMatch(a -> a > 100) = " + createIntStream().noneMatch(a -> a > 100));

        System.out.println("createIntStream().boxed().map(i -> fruits[i]).collect(Collectors.toList()) = " + createIntStream().boxed().map(i -> fruits[i]).collect(Collectors.toList()));
        System.out.println("createIntStream().map(i -> i *10).collect(Collectors.toList()) = " + createIntStream().map(i -> i * 10).boxed().collect(Collectors.toList()));

        System.out.println("createPersonStream().mapToInt(Person::rating).boxed().collect(Collectors.toList()) = " + createPersonStream().mapToInt(Person::rating).boxed().collect(Collectors.toList()));
        System.out.println("createPersonStream().mapToDouble(Person::average).boxed().collect(Collectors.toList()) = " + createPersonStream().mapToDouble(Person::average).boxed().collect(Collectors.toList()));
        System.out.println("createPersonStream().mapToLong(Person::total).boxed().collect(Collectors.toList()) = " + createPersonStream().mapToLong(Person::total).boxed().collect(Collectors.toList()));

        System.out.println("createPersonStream().flatMap(a -> a.config().map(Person.Config::hobbies).orElse(Collections.emptyList()).stream()).collect(Collectors.toList()) = " + createPersonStream().flatMap(a -> a.config().map(Person.Config::hobbies).orElse(Collections.emptyList()).stream()).collect(Collectors.toList()));
        createPersonStream().map(Person::config).map(a -> a.flatMap(Person.Config::age).orElse(null)).collect(Collectors.toList());
                Arrays.stream(fruits).forEach(a -> System.out.println("a = " + a));

        System.out.println("Stream.generate(UUID::randomUUID).limit(10).collect(Collectors.toList()) = " + Stream.generate(UUID::randomUUID).limit(10).collect(Collectors.toList()));
        System.out.println("Stream.generate(() -> UUID.randomUUID()).limit(10).collect(Collectors.toList()) = " + Stream.generate(() -> UUID.randomUUID()).limit(10).collect(Collectors.toList()));

        System.out.println("Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()) = " + Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()));

        System.out.println("IntStream.range(0, 10).boxed().collect(Collectors.toList()) = " + IntStream.range(0, 10).boxed().collect(Collectors.toList()));
        createStream().peek(a -> System.out.println("a = " + a)).collect(Collectors.toList());
//        String[] arr = (String[]) Stream.of("a", "asdasd", "adsd").toArray();
        System.out.println("createIntStream().skip(3).boxed().collect(Collectors.toList()) = " + createIntStream().skip(3).boxed().collect(Collectors.toList()));
        System.out.println("createPersonStream().sorted(Comparator.comparing(Person::name)).collect(Collectors.toList()) = " + createPersonStream().sorted(Comparator.comparing(Person::name)).collect(Collectors.toList()));

        System.out.println("createStream().reduce((a,b) -> a + b) = " + createStream().reduce((a, b) -> a + b));
        System.out.println("createStream().reduce(\"\", (a,b) -> a+b) = " + createStream().reduce("", (a, b) -> a + "," + b));
        System.out.println("createStream().reduce(\"\", (a,b) -> a + \", \" + b, (a, b) -> a + b) = " + createStream().reduce("", (a, b) -> a + "," + b, (a, b) -> a + b));

        System.out.println("createStream().collect(Collectors.joining(\", \")) = " + createStream().collect(Collectors.joining(",")));
        Stream<String> s1 = Stream.of("ABC", "DEF");
        Stream<Integer> s2 = Stream.of(1, 2, 3);
        System.out.println("Stream.concat(s1, s2).collect(Collectors.toList()) = " + Stream.concat(s1, s2).collect(Collectors.toList()));

        // All the collectors
        createStream().collect(Collectors.toList());
        System.out.println("createPersonStream().collect(Collectors.toSet()) = " + createPersonStream().collect(Collectors.toSet()));
        System.out.println("createPersonStream().<HashSet<Person>>collect(HashSet<Person>::new, HashSet::add, AbstractCollection::addAll) = " +
                createPersonStream().<HashSet<Person>>collect(HashSet<Person>::new, HashSet::add, HashSet::addAll));

        System.out.println("createPersonStream().collect(Collectors.toCollection(LinkedList::new)) = " + createPersonStream().collect(Collectors.toCollection(LinkedList::new)));
        System.out.println("createPersonStream().collect(Collectors.toCollection(streams::priorityQueue)) = " + createPersonStream().collect(Collectors.toCollection(streams::priorityQueue)));

        System.out.println("createPersonStream().collect(Collectors.toMap(p -> p.name, p -> p, (p1, p2) -> p1, TreeMap::new)) = " + createPersonStream().collect(Collectors.toMap(p -> p.name, p -> p, (p1, p2) -> p1, TreeMap::new)));

        System.out.println("createPersonStream().map(Person::rating).reduce(0, Integer::sum) = " + createPersonStream().map(Person::rating).reduce(0, Integer::sum));

        IntSummaryStatistics stats = createIntStream().boxed().collect(Collectors.summarizingInt(i -> i));
        System.out.println("createIntStream().boxed().collect(Collectors.summarizingInt(i -> i)) = " + stats);

        DoubleSummaryStatistics doubleSummaryStatistics = createIntStream().boxed().collect(Collectors.summarizingDouble(i -> i));
        System.out.println("doubleSummaryStatistics = " + doubleSummaryStatistics);

        System.out.println("createIntStream().sum() = " + createIntStream().sum());
        System.out.println("createIntStream().boxed().collect(Collectors.summingInt(i -> i)) = " + createIntStream().boxed().collect(Collectors.summingInt(i -> i)));
        System.out.println("createIntStream().boxed().collect(Collectors.summingDouble(i -> i)) = " + createIntStream().boxed().collect(Collectors.summingDouble(i -> i)));
        System.out.println("createIntStream().boxed().collect(Collectors.summingLong(i -> i)) = " + createIntStream().boxed().collect(Collectors.summingLong(i -> i)));

        System.out.println("createIntStream().boxed().collect(Collectors.averagingInt(i -> i)) = " + createIntStream().boxed().collect(Collectors.averagingInt(i -> i)));
        System.out.println("createIntStream().average() = " + createIntStream().average());

        System.out.println("createIntStream().max().equals(0) = " + createIntStream().max().orElse(0));

        int i = createIntStream().max().orElse(0);
        int j = createIntStream().min().orElse(0);
        long l = createIntStream().count();
        long p = createIntStream().sum();
        double k = createIntStream().average().orElse(0.0);

        System.out.println("createPersonStream().collect(Collectors.maxBy(Comparator.comparingInt(Person::rating))) = " + createPersonStream().collect(Collectors.maxBy(Comparator.comparingInt(Person::rating))));
        System.out.println("createPersonStream().collect(Collectors.maxBy(Comparator.comparingInt(Person::rating))) = " + createPersonStream().max(Comparator.comparingInt(Person::rating)));

        System.out.println("createPersonStream().collect(Collectors.groupingBy(Person::name, Collectors.toList())) = " + createPersonStream().collect(Collectors.groupingBy(Person::name, Collectors.toList())));
        Map<String, List<Person>> stringListMap = createPersonStream().collect(Collectors.groupingBy(Person::name));
        System.out.println("createPersonStream().collect(Collectors.groupingBy(Person::name, Collectors.toSet())) = " + createPersonStream().collect(Collectors.groupingBy(Person::name, Collectors.toSet())));
        System.out.println("createPersonStream().collect(Collectors.groupingBy(Person::name, Collectors.toCollection(LinkedList::new))) = " + createPersonStream().collect(Collectors.groupingBy(Person::name, Collectors.toCollection(LinkedList::new))));
    }

    private static PriorityQueue<Person> priorityQueue() {
        return new PriorityQueue<Person>(Comparator.comparingInt(Person::rating));
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

    private static Stream<Person> createPersonStream() {
        return Stream.<Person>builder()
                .add(new Person("Anurag", 100, 500.0, 7000L, null))
                .add(new Person("Sachin", 50, 40.0, 70000L,
                        new Person.Config(Arrays.asList("cricket", "football", "golf"), null)))
                .add(new Person("Sachin2", 50, 40.0, 70000L,
                        new Person.Config(Arrays.asList("cricket", "football", "golf"), null)))
                .add(new Person("Dhoni", 25, 30.0, 8000L,
                        new Person.Config(Arrays.asList("cricket", "cp games", "chess"), 84)))
                .add(new Person("Dhoni", 34, 60.0, 19000L,
                        new Person.Config(Arrays.asList("cricket", "cp games", "chess"), 84)))
                .build();
    }

    public static class Person {
        private final String name;
        private final int rating;
        private final double average;
        private final long total;
        private final Config config;

        public Person(String name, int rating, double average, long total, Config config) {
            this.name = name;
            this.rating = rating;
            this.average = average;
            this.total = total;
            this.config = config;
        }

        public Optional<Config> config() {
            return Optional.ofNullable(config);
        }

        public static class Config {
            private final List<String> hobbies;
            private final Integer age;

            public Config(List<String> hobbies, Integer age) {
                this.hobbies = hobbies;
                this.age = age;
            }

            public List<String> hobbies() {
                return hobbies;
            }

            public Optional<Integer> age() {
                return Optional.ofNullable(age);
            }
        }

        public String name() {
            return name;
        }

        public int rating() {
            return rating;
        }

        public double average() {
            return average;
        }

        public long total() {
            return total;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, average);
        }

        @Override
        public String toString() {
            return String.format("{ name=%s, rating=%s, average=%s, total=%s }", this.name, this.rating, this.average, this.total);
        }
    }
}
