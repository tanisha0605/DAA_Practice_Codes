public class FloydWarshall {
    static final int V = 4;
    static final int INF = 99999;

    static void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.printf("%7s", "INF");
                else
                    System.out.printf("%7d", dist[i][j]);
            }
            System.out.println();
        }
    }

    static void floydWarshall(int dist[][]) {
        int i, j, k;
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        printSolution(dist);
    }

    public static void main(String[] args) {
        int graph[][] = {
                {0, 8, INF, 1},
                {INF, 0, 1, INF},
                {4, INF, 0, INF},
                {INF, 2, 9, 0}
        };
        floydWarshall(graph);
    }
}

