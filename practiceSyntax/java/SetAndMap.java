package java;

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

        Map<String, Student> mapper = new HashMap<>();
        mapper.put("Alice", new Student("Alice", 90, 95,93));
        mapper.put("Jack", new Student("Jack", 60, 75,87));
        mapper.put("Jumbo", new Student("Jumbo", 99, 93,98));
        System.out.println("Does mapper contains : " + mapper.containsKey("Anurag"));
        System.out.println("Does mapper contains : " + mapper.containsKey("Jack"));
        System.out.println("Does mapper contains : " + mapper.get("Jack"));
        System.out.println("Does mapper contains : " + mapper.get("Anurag"));


        System.out.println("Tree Map ========");
        TreeMap<Integer, Integer> valueToIndexMap = new TreeMap<>();
        valueToIndexMap.put(100, 1);
        valueToIndexMap.put(500, 2);
        valueToIndexMap.put(50, 3);
        valueToIndexMap.put(400, 4);
        valueToIndexMap.put(70, 5);
        valueToIndexMap.put(130, 6);
        valueToIndexMap.put(200, 7);
        valueToIndexMap.put(230, 8);

        System.out.println("key is 199 : " + valueToIndexMap.ceilingEntry(199));
        System.out.println("key is 200 : " + valueToIndexMap.ceilingEntry(200));
        System.out.println("key is 201 : " + valueToIndexMap.ceilingEntry(201));
        System.out.println("key is 500 : " + valueToIndexMap.ceilingEntry(500));
        System.out.println("key is 501 : " + valueToIndexMap.ceilingEntry(501));
        System.out.println("key is -100 : " + valueToIndexMap.ceilingEntry(-100));

        System.out.println("Celling keys are ========");
        System.out.println("key is 199 : " + valueToIndexMap.ceilingKey(199));
        System.out.println("key is 200 : " + valueToIndexMap.ceilingKey(200));
        System.out.println("key is 201 : " + valueToIndexMap.ceilingKey(201));
        System.out.println("key is 500 : " + valueToIndexMap.ceilingKey(500));
        System.out.println("key is 501 : " + valueToIndexMap.ceilingKey(501));
        System.out.println("key is -100 : " + valueToIndexMap.ceilingKey(-100));

        System.out.println("Floor entry ===========");
        System.out.println("key is 199 : " + valueToIndexMap.floorEntry(199));
        System.out.println("key is 200 : " + valueToIndexMap.floorEntry(200));
        System.out.println("key is 201 : " + valueToIndexMap.floorEntry(201));
        System.out.println("key is 500 : " + valueToIndexMap.floorEntry(500));
        System.out.println("key is 501 : " + valueToIndexMap.floorEntry(501));
        System.out.println("key is -100 : " + valueToIndexMap.floorEntry(-100));
        System.out.println("key is 50 : " + valueToIndexMap.floorEntry(50));
    }
}
