import java.util.*;

public class SetAndMap {
    static class Student implements Comparable<Student> {
        public String name;
        public Integer mathScore;
        public Integer physicsScore;
        public Integer chemScore;

        Student(final String name, final Integer mathScore, final Integer physicsScore, final Integer chemScore) {
            this.name = name;
            this.mathScore = mathScore;
            this.physicsScore = physicsScore;
            this.chemScore = chemScore;
        }

        public double percentage() {
            return (mathScore + physicsScore + chemScore)/3.0;
        }

        @Override
        public int compareTo(Student o) {
            return Double.compare(this.percentage(), o.percentage());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof String)) return false;
            return Objects.equals(name, o);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(100);
        integerSet.add(3000);
        integerSet.add(5000);
        if (integerSet.contains(100)) {
            System.out.println("Yes it contains 100");
        }
        integerSet.remove(100);
        System.out.println("Does it contains 100  " + integerSet.contains(100));
        System.out.println("Size of integerSet : " + integerSet.size());
        System.out.println("What is the maximum element in the integerSet : " + integerSet.stream().max(Integer::compare));

        Set<Student> students = new HashSet<>();
        students.add(new Student("Alice", 90, 95,93));
        students.add(new Student("Jack", 60, 75,87));
        students.add(new Student("Jumbo", 99, 93,98));

        if (students.contains("Jumbo")) {
            System.out.println("Yes Jumbo is a student");
        }
        System.out.println("Is Aman is a student? " + students.contains("Aman"));
    }
}
