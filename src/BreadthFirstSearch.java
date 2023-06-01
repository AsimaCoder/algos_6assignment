import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private final WeightedGraph<V> graph;

    public BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;         // Constructor to initialize the BreadthFirstSearch object with the provided graph

    }

    public List<Vertex<V>> traverse(Vertex<V> start) {
        List<Vertex<V>> traversalOrder = new ArrayList<>();
        Set<Vertex<V>> visited = new HashSet<>();
        Queue<Vertex<V>> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll(); // Retrieve and remove the first vertex from the queue
            traversalOrder.add(currentVertex); // Add the current vertex to the traversal order

            List<Vertex<V>> neighbors = graph.getAdjacencyList().get(currentVertex);
            for (Vertex<V> neighbor : neighbors) {                 // Iterate through each neighbor of the current vertex

                if (!visited.contains(neighbor)) {                    // If the neighbor has not been visited, enqueue it and mark it as visited

                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return traversalOrder;
    }
}