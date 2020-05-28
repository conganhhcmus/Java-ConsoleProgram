import java.io.*;
import java.util.*;

public class Main {
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    private static Set<Integer> settled = new HashSet<Integer>();
    private static int V;
    private static int[][] matrix;
    private static int dist[];
    private static int[] parents;

    public static void main(String[] args) {
        try {
            // READ FILE
            Scanner sc = new Scanner(new BufferedReader(new FileReader("input.txt")));
            int rows = 0;
            int columns = 0;
            while (sc.hasNextLine()) {
                rows++;
                columns++;
                sc.nextLine();
            }
            sc.close();

            sc = new Scanner(new BufferedReader(new FileReader("input.txt")));
            matrix = new int[rows][columns];
            V = matrix.length;
            while (sc.hasNextLine()) {
                for (int i = 0; i < matrix.length; i++) {
                    String[] line = sc.nextLine().trim().split(" ");
                    for (int j = 0; j < line.length; j++) {
                        matrix[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }
            // Init source and end
            int src = 0;
            int end = 4;

            
            dijkstra(matrix, src);

            // WRITE FILE
            System.out.printf("RESULT: Distance from %d to %d is %d.\n", src, end, dist[end]);
            System.out.println("PATH: ");
            String tmp = "";
            while (end != src) {
                tmp += parents[end] + " -> " + end + " :" + matrix[parents[end]][end] + "\n";
                end = parents[end];
            }
            String path[] = tmp.split("\n");
            for (int i = path.length - 1; i >= 0; i--) {
                System.out.println("\t" + path[i]);
            }
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }

    }

    public static void dijkstra(int[][] matrix, int src) {
        dist = new int[V];
        parents = new int[V];
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        pq.add(src);
        dist[src] = 0;
        parents[src] = -1;

        while (settled.size() != V) {
            // remove the minimum distance node
            // from the priority queue
            int u = pq.remove();
            // adding the node whose distance is
            // finalized
            settled.add(u);

            eNeighbors(u);
        }

    }

    public static void eNeighbors(int u) {
        int edgeDistance = -1;
        int newDistance = -1;
        // All the neighbors of v
        for (int i = 0; i < V; i++) {

            // If current node hasn't already been processed
            if (!settled.contains(i) && matrix[u][i] != 0) {
                edgeDistance = matrix[u][i];
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[i]) {
                    dist[i] = newDistance;
                    parents[i] = u;
                }

                // Add the current node to the queue
                pq.add(i);
            }
        }
    }

}