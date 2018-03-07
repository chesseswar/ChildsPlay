import java.util.*;

public class DepthFirstSearch {
    boolean[] visited;
    int origin;
    int[] connections;

    public DepthFirstSearch(Graph g, int o, boolean[] v){
        origin = o;
        connections = new int[g.vertices.length];
        visited = v;
        search(g, o);
    }

    public DepthFirstSearch(Graph g, int o){
        origin = o;
        connections = new int[g.vertices.length];
        visited = new boolean[g.vertices.length];
        search(g, o);
    }

    public void search(Graph g, int vertex){
        visited[vertex] = true;
        for (int v : g.connections(vertex)){
            if (!visited[v]){
                connections[v] = vertex;
                search(g, v);
            }
        }
    }

    public boolean pathExists(int destination){
        return visited[destination];
    }

    public boolean[] knockedOver(){
        return visited;
    }

}
