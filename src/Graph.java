import java.util.*;

public class Graph {
    LinkedList<Integer>[] vertices;
    int size;
    int edges;
    public Graph(int numVert){
        vertices = new LinkedList[numVert];
        size = numVert;
        edges = 0;

        for (int i = 0; i < vertices.length; i++){
            vertices[i] = new LinkedList<>();
        }
    }

    public void addEdge(int first, int second){
        vertices[first].addFirst(second);
        edges++;
    }

    public Iterable<Integer> connections(int vertex){
        return vertices[vertex];
    }

    public boolean[] knockedDown(int initial, boolean[] visited){
        DepthFirstSearch dfs = new DepthFirstSearch(this, initial, visited);
        return dfs.visited;
    }

    public boolean pathExists(int first, int second){
        DepthFirstSearch dfs = new DepthFirstSearch(this, first);
        return dfs.pathExists(second);
    }

    public String toString(){
        String output = "";
        for (int i = 0; i < vertices.length; i++){
            output += i + " " + vertices[i] + "\n";
        }
        return output;
    }
}
