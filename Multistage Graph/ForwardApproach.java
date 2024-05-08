public class ForwardApproach {
    static final int INFINITY = Integer.MAX_VALUE;

    static void fGraph(int[][] E, int k, int n, int[] P, int[] D, int[] COST) {
        COST[n] = 0;

        for (int j = n - 1; j >= 1; j--) {
            int minCost = INFINITY;
            int r = -1;
            for (int vertex = 1; vertex <= k; vertex++) {
                if (E[j][vertex] != 0 && E[j][vertex] + COST[vertex] < minCost) {
                    minCost = E[j][vertex] + COST[vertex];
                    r = vertex;
                }
            }
            COST[j] = minCost;
            D[j] = r;
        }

        P[0] = 1;
        P[k - 1] = n;
        for (int j = 1; j <= k - 2; j++) {
            P[j] = D[P[j - 1]];
        }
    }

    public static void main(String[] args) {
        int n = 8; // Number of vertices
        int k = 4; // Number of stages
        int[][] E = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 1, 3, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 3, 0, 0},
                {0, 0, 0, 0, 6, 7, 0, 0},
                {0, 0, 0, 0, 0, 0, 5, 6},
                {0, 0, 0, 0, 0, 0, 3, 2},
                {0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        int[] P = new int[k]; // Array to store the optimal path
        int[] D = new int[n + 1]; // Array to store the decision vertices
        int[] COST = new int[n + 1]; // Array to store the minimum cost

        fGraph(E, k, n, P, D, COST);

        System.out.println("Optimal Path:");
        for (int vertex : P) {
            System.out.print(vertex + " ");
        }
    }
}
