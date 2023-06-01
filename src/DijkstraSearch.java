import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private final WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public List<Vertex<V>> traverse(Vertex<V> start) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> previousVertices = new HashMap<>();
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        // Initialize distances and previousVertices
        for (Vertex<V> vertex : graph.getAdjacencyList().keySet()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
            previousVertices.put(vertex, null);
        }
        distances.put(start, 0.0);

        pq.offer(start);

        while (!pq.isEmpty()) {
            Vertex<V> currentVertex = pq.poll();

            List<Vertex<V>> neighbors = graph.getAdjacencyList().get(currentVertex);
            for (Vertex<V> neighbor : neighbors) {
                double edgeWeight = currentVertex.getAdjacentVertices().get(neighbor);
                double distanceThroughCurrent = distances.get(currentVertex) + edgeWeight;

                if (distanceThroughCurrent < distances.get(neighbor)) {
                    distances.put(neighbor, distanceThroughCurrent);
                    previousVertices.put(neighbor, currentVertex);
                    pq.offer(neighbor);
                }
            }
        }

        List<Vertex<V>> path = new ArrayList<>();
        Vertex<V> current = start;
        while (current != null) {
            path.add(current);
            current = previousVertices.get(current);
        }
        Collections.reverse(path);

        return path;
    }
}

