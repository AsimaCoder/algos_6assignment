import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> adjacencyList;

    public WeightedGraph() {
        // Initialize the adjacency list as a HashMap
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        // Add a vertex to the graph by putting an empty list in the adjacency list map
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        // Add an edge between two vertices by updating the adjacency list and the source vertex's adjacency map
        validateVertex(source);
        validateVertex(destination);
        adjacencyList.get(source).add(destination);
        source.addAdjacentVertex(destination, weight);
    }

    public boolean hasEdge(Vertex<V> source, Vertex<V> destination) {
        // Check if an edge exists between two vertices by searching the adjacency list
        validateVertex(source);
        validateVertex(destination);
        List<Vertex<V>> neighbors = adjacencyList.get(source);
        return neighbors.contains(destination);
    }

    public List<Vertex<V>> getNeighbors(Vertex<V> vertex) {
        // Get the neighbors of a given vertex from the adjacency list
        validateVertex(vertex);
        return adjacencyList.get(vertex);
    }

    public void DFS(Vertex<V> startVertex) {
        // Perform depth-first search traversal starting from the specified vertex
        validateVertex(startVertex);
        // Implement DFS traversal logic here
    }

    private void validateVertex(Vertex<V> vertex) {
        // Validate if a vertex is present in the graph before performing operations on it
        if (!adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " is not in the graph.");
        }
    }

    public Map<Vertex<V>, List<Vertex<V>>> getAdjacencyList() {
        // Get the adjacency list representing the graph
        return adjacencyList;
    }
}
