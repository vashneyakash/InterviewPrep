package javax;

import java.util.*;

public class PriorityQueueS {
    public static class Node {
        private final int nodeNumber;
        private int distance;

        public Node(int nodeNumber, int distance) {
            this.nodeNumber = nodeNumber;
            this.distance = distance;
        }

        public void updateDistance(int newDistance) {
            this.distance = newDistance;
        }

        public int distance() {
            return distance;
        }

        @Override
        public String toString() {
            return String.format("{ nodeNumber=%s, distance=%s }", this.nodeNumber, this.distance);
        }
    }

    public static void main(String[] args) {
        Queue<Node> p = new PriorityQueue<>(Comparator.comparingInt(Node::distance).reversed());
        p.add(new Node(1, 100));
        p.add(new Node(2, 200));
        p.add(new Node(3, 300));
        p.add(new Node(43, 120));
        while (!p.isEmpty()) {
            System.out.println("p.peek() = " + p.peek());
            System.out.println("p.poll() = " + p.poll());
        }
    }
}
