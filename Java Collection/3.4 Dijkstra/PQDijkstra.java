import java.io.*;
import java.util.*;

public class PQDijkstra {
    private EdgeComparator comparator = new EdgeComparator();
    private PriorityQueue<Edge> pq = new PriorityQueue<>(11, comparator);
    private Set<Integer> settled = new HashSet<Integer>();
    private int V;
    private int[][] matrix;
    private int dist[];
    private int[] parents;

    public PQDijkstra(String path) {
        try {
            // READ FILE
            Scanner sc = new Scanner(new BufferedReader(new FileReader(path)));
            int rows = 0;
            int columns = 0;
            while (sc.hasNextLine()) {
                rows++;
                columns++;
                sc.nextLine();
            }
            sc.close();

            sc = new Scanner(new BufferedReader(new FileReader(path)));
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
            // System.out.println(Arrays.deepToString(matrix));
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }

    }

    public boolean Check(int src, int end){
        if (src < 0 || end < 0 || src >= V || end >= V) return false;
        return true;
    }

    public void show(int src, int end) {
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
    }

    public void dijkstra(int src , int end) {
        dist = new int[V];
        parents = new int[V];
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        pq.add(new Edge(src, 0));
        dist[src] = 0;
        parents[src] = -1;

        while (settled.size() != V) {
            // remove the minimum distance Edge
            // from the priority queue
            int u = pq.remove().node;
            // adding the Edge whose distance is
            // finalized
            settled.add(u);

            eNeighbors(u);
        }
        show(src, end);
    }

    public void eNeighbors(int u) {
        int edgeDistance = -1;
        int newDistance = -1;
        // All the neighbors of v
        for (int i = 0; i < V; i++) {

            // If current Edge hasn't already been processed
            if (!settled.contains(i) && matrix[u][i] != 0) {
                edgeDistance = matrix[u][i];
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[i]) {
                    dist[i] = newDistance;
                    parents[i] = u;
                }

                // Add the current Edge to the queue
                pq.add(new Edge(i, dist[i]));
            }
        }
    }

    class Edge{

        public int node;
        public int cost;
    
        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    
        
    }
    class EdgeComparator implements Comparator <Edge> {
        @Override
        public int compare(Edge a, Edge b) {
            if (a.cost < b.cost)
                return -1;
            if (a.cost > b.cost)
                return 1;
            return 0;
        }
    } 
}
