public class KnapsackDP {
    static int knapsack(int[] p, int[] w, int M, int n) {
        int[][] profit = new int[n + 1][M + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= M; j++) {
                if (i == 0 || j == 0) {
                    profit[i][j] = 0;
                } else if (w[i - 1] <= j) {
                    profit[i][j] = Math.max(profit[i - 1][j], profit[i - 1][j - w[i - 1]] + p[i - 1]);
                } else {
                    profit[i][j] = profit[i - 1][j];
                }
            }
        }

        return profit[n][M];
    }

    public static void main(String[] args) {
        int[] p = {60, 100, 120};
        int[] w = {10, 20, 30};
        int M = 50;
        int n = p.length;

        int maxProfit = knapsack(p, w, M, n);
        System.out.println("Maximum profit: " + maxProfit);
    }
}

