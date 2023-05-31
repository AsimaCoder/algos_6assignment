import java.util.List;
public interface Search<V> {
    List<Vertex<V>> traverse(Vertex<V> start);
}
