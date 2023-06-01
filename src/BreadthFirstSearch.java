import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private final WeightedGraph<V> graph;

    public BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }}