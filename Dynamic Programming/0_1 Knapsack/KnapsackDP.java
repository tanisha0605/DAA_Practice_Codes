import java.util.ArrayList;
import java.util.List;

public class KnapsackDP {
    // Class to store the result of the knapsack function
    static class Result {
        int maxProfit; // Maximum profit achieved
        List<Integer> includedWeights; // List of weights included in the knapsack

        Result(int maxProfit, List<Integer> includedWeights) {
            this.maxProfit = maxProfit;
            this.includedWeights = includedWeights;
        }
    }

    // Function to solve the knapsack problem using dynamic programming
    static Result knapsack(int[] p, int[] w, int M, int n) {
        // Create a 2D array to store maximum profit for each weight and item combination
        int[][] profit = new int[n + 1][M + 1];

        // Populate the profit array using dynamic programming
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= M; j++) {
                if (i == 0 || j == 0) {
                    profit[i][j] = 0; // Base case: no items or no capacity
                } else if (w[i - 1] <= j) {
                    // If the current item's weight is less than or equal to the current capacity,
                    // choose the maximum of including or excluding the current item
                    profit[i][j] = Math.max(profit[i - 1][j], profit[i - 1][j - w[i - 1]] + p[i - 1]);
                } else {
                    // If the current item's weight exceeds the current capacity, exclude the item
                    profit[i][j] = profit[i - 1][j];
                }
            }
        }

        // Track which weights are included in the knapsack to achieve the maximum profit
        List<Integer> includedWeights = new ArrayList<>();
        int maxProfit = profit[n][M];
        int remainingWeight = M;
        for (int i = n; i > 0 && maxProfit > 0; i--) {
            if (maxProfit != profit[i - 1][remainingWeight]) {
                includedWeights.add(w[i - 1]); // Include the weight corresponding to the current item
                maxProfit -= p[i - 1]; // Subtract the profit of the included item
                remainingWeight -= w[i - 1]; // Update the remaining capacity
            }
        }

        // Return the result containing the maximum profit and the list of included weights
        return new Result(profit[n][M], includedWeights);
    }

    // Main function to test the knapsack function
    public static void main(String[] args) {
        // Input data
        int[] p = {60, 100, 120}; // Profits of items
        int[] w = {10, 20, 30}; // Weights of items
        int M = 50; // Knapsack capacity
        int n = p.length; // Number of items

        // Call the knapsack function and store the result
        Result result = knapsack(p, w, M, n);

        // Print the maximum profit achieved
        System.out.println("Maximum profit: " + result.maxProfit);
        // Print the list of weights included in the knapsack
        System.out.println("Weights included: " + result.includedWeights);
    }
}



