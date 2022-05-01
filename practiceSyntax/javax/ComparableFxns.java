package javax;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;

public class ComparableFxns {

    public static class Player implements Comparable<Player>, Comparator<Player> {
        private final String name;
        private final int rating;

        public Player(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        public int rating() {
            return rating;
        }

        public String name() {
            return name;
        }

        @Override
        public int compareTo(Player o) {
            if (rating() == o.rating()) return 0;
            return rating() < o.rating() ? -1 : 1;
        }

        @Override
        public int compare(Player o1, Player o2) {
            if (o1.rating() == o2.rating()) return 0;
            return o1.rating() < o2.rating() ? -1 : 1;
        }

        @Override
        public String toString() {
            return String.format("{ name=%s, rating=%s }", this.name, this.rating);
        }
    }

    public static class PlayerComparator implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            if (o1.rating() == o2.rating()) return 0;
            return o1.rating() < o2.rating() ? -1 : 1;
        }
    }

    public static void main(String[] args) {

        List<Player> players = new ArrayList<>();
        players.add(new Player("Ram", 100));
        players.add(new Player("Ghanshyam", 22));
        players.add(new Player("Sita", 150));
        players.add(new Player("BalRam", 150));
        players.add(new Player("Shyam", 50));

        // Will only work when you implement Comparable
        System.out.println(players.stream().sorted().collect(Collectors.toList()));

        // Works with comparators
        System.out.println(players.stream().sorted((o1, o2) -> Integer.compare(o1.rating(), o2.rating())).collect(Collectors.toList()));
        System.out.println(players.stream().sorted((o1, o2) -> o1.name().compareTo(o2.name())).collect(Collectors.toList()));
        System.out.println(players.stream().sorted(Comparator.comparingInt(Player::rating)).collect(Collectors.toList()));

        // You can define a comparator
        System.out.println(players.stream().sorted(new PlayerComparator()).collect(Collectors.toList()));

        System.out.println("----- In reverse order ------");
        System.out.println(players.stream().sorted((o1, o2) -> Integer.compare(o2.rating(), o1.rating())).collect(Collectors.toList()));
        System.out.println(players.stream().sorted(Comparator.comparingInt(Player::rating).reversed().thenComparing(Player::name)).collect(Collectors.toList()));

        System.out.println("------- NUll First ---------");
        players.add(new Player(null, 150));
        players.add(new Player(null, 100));
        System.out.println(players.stream().sorted(Comparator.nullsFirst(Comparator.comparing(Player::name, Comparator.nullsFirst(Comparator.naturalOrder())))).collect(Collectors.toList()));
        System.out.println("------- NUll Last ---------");
        System.out.println(players.stream().sorted(Comparator.nullsLast(Comparator.comparing(Player::name, Comparator.nullsLast(Comparator.naturalOrder())))).collect(Collectors.toList()));

//        Integer.compare();
//        Double.compare();
//        new String().compareTo();
//        Long.compare();
//        new BigDecimal().compareTo();
//        Character.compare();
//        new BigInteger().compareTo()
    }
}
