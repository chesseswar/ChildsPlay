import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int numCase = in.nextInt();
        for (int i = 0; i < numCase; i++){
            int tiles = in.nextInt();
            int connections = in.nextInt();
            int falls = in.nextInt();
            HashMap<Integer, Integer> tileCodes = new HashMap<>();
            Graph graph = new Graph(tiles);
            int index = 0;
            for (int j = 0; j < connections; j++){
                int first = in.nextInt();
                int second = in.nextInt();

                if (!tileCodes.containsKey(first)){
                    tileCodes.put(first, index);
                    index++;
                }

                if (!tileCodes.containsKey(second)){
                    tileCodes.put(second, index);
                    index++;
                }

                graph.addEdge(tileCodes.get(first), tileCodes.get(second));
            }
            System.out.println(tileCodes);
            System.out.println(graph);
            boolean[] visited = new boolean[tiles];
            for (int j = 0; j < falls; j++) {
                visited = graph.knockedDown(tileCodes.get(in.nextInt()), visited);
            }


            int output = 0;
            for (boolean b : visited){
                if (b){
                    output++;
                }
            }
            System.out.println(output);
        }
    }
}
