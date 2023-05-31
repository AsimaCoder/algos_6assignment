import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data; // Represents the data associated with the vertex
    private Map<Vertex<V>, Double> adjacentVertices; // Stores the adjacent vertices and their corresponding weights

    public Vertex(V data) {
        this.data = data; // Initialize the vertex with the provided data
        this.adjacentVertices = new HashMap<>(); // Create a new HashMap to store the adjacent vertices
    }
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight); // Add an adjacent vertex with its corresponding weight to the map
    }

    public V getData() {
        return data; // Return the data associated with the vertex
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices; // Return the map of adjacent vertices and their weights
    } // Returns the map of adjacent vertices
}
