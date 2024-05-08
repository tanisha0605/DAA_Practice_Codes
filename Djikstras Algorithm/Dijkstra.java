import java.util.Arrays;

public class Dijkstra {
    static final int INFINITY = 99999;

    static void shortestPaths(int w, int[][] COST, int[] DIST, int n) {
        boolean[] S = new boolean[n];
        Arrays.fill(S, false);

        for (int i = 0; i < n; i++) {
            DIST[i] = COST[w][i];
        }
        S[w] = true;
        DIST[w] = 0;

        for (int num = 2; num <= n - 1; num++) {
            int u = -1;
            int minDist = INFINITY;
            for (int i = 0; i < n; i++) {
                if (!S[i] && DIST[i] < minDist) {
                    minDist = DIST[i];
                    u = i;
                }
            }
            if (u == -1) break;

            S[u] = true;
            for (int v = 0; v < n; v++) {
                if (!S[v] && COST[u][v] != INFINITY) {
                    DIST[v] = Math.min(DIST[v], DIST[u] + COST[u][v]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // Number of vertices
        int w = 0; // Source vertex
        int[][] COST = {
                {0, 10, 5, INFINITY, INFINITY},
                {INFINITY, 0, 2, 1, INFINITY},
                {INFINITY, 3, 0, 9, 2},
                {INFINITY, INFINITY, INFINITY, 0, 4},
                {7, INFINITY, INFINITY, 6, 0}
        };
        int[] DIST = new int[n];

        shortestPaths(w, COST, DIST, n);

        System.out.println("Shortest distances from vertex " + w + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + ": " + (DIST[i] == INFINITY ? "INF" : DIST[i]));
        }
    }
}

