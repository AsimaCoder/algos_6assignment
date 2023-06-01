# Assignment 6
___
# Weighted Graph Traversals

This project demonstrates different graph traversal algorithms on a weighted graph.

## Project Structure

The project consists of the following Java classes:

- `Main.java`: Contains the main method to execute the graph traversal algorithms.
- `Vertex.java`: Represents a vertex in the graph.
- `WeightedGraph.java`: Represents a weighted graph and provides methods to manipulate the graph.
- `Search.java`: An interface defining the contract for graph traversal algorithms.
- `BreadthFirstSearch.java`: Implements breadth-first search (BFS) algorithm for graph traversal.
- `DijkstraSearch.java`: Implements Dijkstra's algorithm for finding the shortest path in a graph.

## Getting Started

To run the project and see the graph traversal algorithms in action, follow these steps:

1. Clone the repository or download the source code.
2. Import the project into your Java IDE.
3. Run the `Main.java` class.

## Example Usage

Here's an example usage of the graph traversal algorithms:

```java
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

// Perform BFS traversal
Search<String> bfs = new BreadthFirstSearch<>(myGraph);
List<Vertex<String>> bfsTraversal = bfs.traverse(v0);
System.out.println("BFS traversal: " + bfsTraversal);

// Perform Dijkstra's algorithm
Search<String> dijkstra = new DijkstraSearch<>(myGraph);
List<Vertex<String>> dijkstraPath = dijkstra.traverse(v0);
System.out.println("Dijkstra's path from A to E: " + dijkstraPath);
