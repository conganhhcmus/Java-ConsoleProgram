public class Main {
    public static void main(String[] args) {
        String path = "input.txt";
        PQDijkstra utils = new PQDijkstra(path);
        utils.dijkstra(0, 4);
    }
}