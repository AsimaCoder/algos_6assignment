import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> adjacencyList;

    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        validateVertex(source);
        validateVertex(destination);
        adjacencyList.get(source).add(destination);
        source.addAdjacentVertex(destination, weight);
    }

    public boolean hasEdge(Vertex<V> source, Vertex<V> destination) {
        validateVertex(source);
        validateVertex(destination);
        List<Vertex<V>> neighbors = adjacencyList.get(source);
        return neighbors.contains(destination);
    }

    public List<Vertex<V>> getNeighbors(Vertex<V> vertex) {
        validateVertex(vertex);
        return adjacencyList.get(vertex);
    }

    public void DFS(Vertex<V> startVertex) {
        validateVertex(startVertex);
        // Implement DFS traversal logic here
    }

    private void validateVertex(Vertex<V> vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " is not in the graph.");
        }
    }

    public Map<Vertex<V>, List<Vertex<V>>> getAdjacencyList() {
        return adjacencyList;
    }
}
