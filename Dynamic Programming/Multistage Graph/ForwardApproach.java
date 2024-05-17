public class ForwardApproach {
    static final int INFINITY = Integer.MAX_VALUE;

    // Function to find the minimum cost path in a multi-stage graph
    static void fGraph(int[][] E, int k, int n, int[] P, int[] D, int[] COST) {
        // Initialize the cost of the last vertex to 0 as the destination has no further cost
        COST[n] = 0;

        // Calculate the minimum cost for each vertex from the second last to the first vertex
        for (int j = n - 1; j >= 1; j--) {
            int minCost = INFINITY;
            int r = -1;
            
            // Traverse through the stages to find the minimum cost path
            for (int vertex = 1; vertex <= k; vertex++) {
                // If there is a valid edge and the cost through this vertex is less than the current minimum
                if (E[j][vertex] != 0 && E[j][vertex] + COST[vertex] < minCost) {
                    minCost = E[j][vertex] + COST[vertex];
                    r = vertex;
                }
            }
            // Update the minimum cost and the decision vertex
            COST[j] = minCost;
            D[j] = r;
        }

        // Initialize the optimal path with the start and end vertices
        P[0] = 1; // Start at vertex 1
        P[k - 1] = n; // End at vertex n
        
        // Fill in the intermediate vertices in the optimal path
        for (int j = 1; j <= k - 2; j++) {
            P[j] = D[P[j - 1]];
        }
    }

    public static void main(String[] args) {
        int n = 8; // Number of vertices
        int k = 4; // Number of stages
        // Adjacency matrix representing the graph
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

        // Call the function to calculate the optimal path and cost
        fGraph(E, k, n, P, D, COST);

        // Print the optimal path
        System.out.println("Optimal Path:");
        for (int vertex : P) {
            System.out.print(vertex + " ");
        }
    }
}

