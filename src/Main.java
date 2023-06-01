import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) {

        // Create vertices
        Vertex<String> v0 = new Vertex<>("A");
        Vertex<String> v1 = new Vertex<>("B");
        Vertex<String> v2 = new Vertex<>("C");
        Vertex<String> v3 = new Vertex<>("D");
        Vertex<String> v4 = new Vertex<>("E");

        // Create weighted graph
        WeightedGraph<String> myGraph = new WeightedGraph<>();
        myGraph.addVertex(v0);
        myGraph.addVertex(v1);
        myGraph.addVertex(v2);
        myGraph.addVertex(v3);
        myGraph.addVertex(v4);

        myGraph.addEdge(v0, v1, 1.0);
        myGraph.addEdge(v1, v2, 2.0);
        myGraph.addEdge(v2, v4, 3.0);
        myGraph.addEdge(v2, v0, 4.0);
        myGraph.addEdge(v3, v4, 5.0);

        // Print the graph
        for (Map.Entry<Vertex<String>, List<Vertex<String>>> entry : myGraph.getAdjacencyList().entrySet()) {
            Vertex<String> vertex = entry.getKey();
            List<Vertex<String>> neighbors = entry.getValue();
            System.out.print("Vertex " + vertex.getData() + " is connected to: ");
            for (Vertex<String> neighbor : neighbors) {
                System.out.print(neighbor.getData() + " ");
            }
            System.out.println();
        }

        // Check if there is an edge between two vertices
        System.out.println(myGraph.hasEdge(v0, v4));

        // Get the neighbors of a vertex
        System.out.println(myGraph.getNeighbors(v1));

        // Perform DFS traversal
        myGraph.DFS(v2);

        // Perform BFS traversal
        Search<String> bfs = new BreadthFirstSearch<>(myGraph);
        List<Vertex<String>> bfsTraversal = bfs.traverse(v0);
        System.out.println("BFS traversal: " + bfsTraversal);

        // Perform Dijkstra's algorithm
        Search<String> dijkstra = new DijkstraSearch<>(myGraph);
        List<Vertex<String>> dijkstraPath = dijkstra.traverse(v0);
        System.out.println("Dijkstra's path from A to E: " + dijkstraPath);
    }
}
