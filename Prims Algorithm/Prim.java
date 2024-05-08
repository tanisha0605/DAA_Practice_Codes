
public class Prim {
    static void prim(int[][] COST, int n) {
        int[] NEAR = new int[n + 1];
        int[][] T = new int[n][2];
        int mincost = Integer.MAX_VALUE;

        int k = 0, l = 0;
        // Find edge with minimum cost
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (COST[i][j] < mincost) {
                    mincost = COST[i][j];
                    k = i;
                    l = j;
                }
            }
        }
        mincost = COST[k][l];
        T[0][0] = k;
        T[0][1] = l;

        for (int i = 1; i <= n; i++) {
            NEAR[i] = (COST[i][l] < COST[i][k]) ? l : k;
        }
        NEAR[k] = NEAR[l] = 0;

        for (int i = 2; i <= n - 1; i++) {
            int j = 0;
            // Find index j such that NEAR(j) ≠ 0 and COST(j, NEAR(j)) is minimum
            while (NEAR[j] == 0) j++;
            for (int kIndex = j + 1; kIndex <= n; kIndex++) {
                if (NEAR[kIndex] != 0 && COST[kIndex][NEAR[kIndex]] < COST[j][NEAR[j]]) {
                    j = kIndex;
                }
            }
            T[i - 1][0] = j;
            T[i - 1][1] = NEAR[j];
            mincost += COST[j][NEAR[j]];
            NEAR[j] = 0;

            // Update NEAR array
            for (int kIndex = 1; kIndex <= n; kIndex++) {
                if (NEAR[kIndex] != 0 && COST[kIndex][NEAR[kIndex]] > COST[kIndex][j]) {
                    NEAR[kIndex] = j;
                }
            }
        }

        if (mincost == Integer.MAX_VALUE) {
            System.out.println("No spanning tree");
        } else {
            System.out.println("Minimum cost of spanning tree: " + mincost);
            System.out.println("Edges of the minimum spanning tree:");
            for (int i = 0; i < n - 1; i++) {
                System.out.println("(" + T[i][0] + ", " + T[i][1] + ")");
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] COST = {
                {0, 0, 0, 0, 0},
                {0, 0, 2, 3, 4},
                {0, 2, 0, 5, 6},
                {0, 3, 5, 0, 7},
                {0, 4, 6, 7, 0}
        };
        prim(COST, n);
    }
}

