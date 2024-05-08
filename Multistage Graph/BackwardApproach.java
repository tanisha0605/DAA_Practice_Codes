public class BackwardApproach {
    static final int INFINITY = Integer.MAX_VALUE;

    static void bGraph(int[][] E, int k, int n, int[] P, int[] D, int[] BCOST) {
        BCOST[n] = 0;

        for (int j = n - 1; j >= 2; j--) {
            int minCost = INFINITY;
            int r = -1;
            for (int vertex = 1; vertex <= k; vertex++) {
                if (E[vertex][j] != 0 && BCOST[vertex] + E[vertex][j] < minCost) {
                    minCost = BCOST[vertex] + E[vertex][j];
                    r = vertex;
                }
            }
            BCOST[j] = minCost;
            D[j] = r;
        }

        P[0] = 1;
        P[k - 1] = n;
        for (int j = k - 2; j >= 1; j--) {
            P[j] = D[P[j + 1]];
        }
    }

    public static void main(String[] args) {
        int n = 8; // Number of vertices
        int k = 4; // Number of stages
        int[][] E = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 3, 4, 0, 0, 0, 0}
        };

        int[] P = new int[k]; // Array to store the optimal path
        int[] D = new int[n + 1]; // Array to store the decision vertices
        int[] BCOST = new int[n + 1]; // Array to store the backward minimum cost

        bGraph(E, k, n, P, D, BCOST);

        System.out.println("Optimal Path:");
        for (int vertex : P) {
            System.out.print(vertex + " ");
        }
    }
}

