package google.java;
import java.util.*;

public class PathWithMaximumProbability {
    public static class Node {
        private final int nodeIndex;
        private final double distance;

        public Node(int nodeIndex, double distance) {
            this.nodeIndex = nodeIndex;
            this.distance = distance;
        }

        public int nodeIndex() { return nodeIndex; }

        public double distance() { return distance; }
    }

    public static class Routes {
        private final int neighbour;
        private final double cost;

        public Routes(int neighbour, double cost) {
            this.neighbour = neighbour;
            this.cost = cost;
        }

        public int neighbour() { return neighbour; }

        public double cost() { return cost; }

    }

    private double[] distance;
    public void dijasktra(int numberOfNodes,
                            int source,
                            List<List<Routes>> adjList) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>(Comparator.comparingDouble(Node::distance));

        distance = new double[numberOfNodes];
        Arrays.fill(distance, 0);

        for (int node = 0; node < numberOfNodes; node++) {
            queue.add(new Node(node, 0));
        }

        distance[source] = 1;
        queue.add(new Node(source, 1));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if (distance[node.nodeIndex()] == Double.MIN_VALUE) continue;

            for (Routes neighbour: adjList.get(node.nodeIndex())) {

                if (distance[neighbour.neighbour()] == 0
                        || (distance[node.nodeIndex()] * neighbour.cost()) > distance[neighbour.neighbour()]) {
                    queue.add(new Node(source, distance[node.nodeIndex()] * neighbour.cost()));

                }
            }
        }
    }

    public double probabilityForEnd(int endNode) {
        return distance[endNode];
    }
}
