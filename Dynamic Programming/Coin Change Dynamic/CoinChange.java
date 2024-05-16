import java.util.ArrayList;
import java.util.List;

public class CoinChange {
    
    public static void coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] CCP = new int[n + 1][amount + 1];
        int[][] coinUsed = new int[n + 1][amount + 1]; // Array to keep track of coins used

        // Initialize the table for the base case: 0 amount
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    // If amount is 0, no coins are needed
                    CCP[i][j] = 0;
                } else if (i == 0) {
                    // If no coins are available and amount is not 0, set to infinity (or a large number)
                    CCP[i][j] = Integer.MAX_VALUE - 1;
                } else {
                    if (coins[i - 1] <= j) {
                        // If the coin value is less than or equal to the current amount
                        // Take the minimum of including the coin or not including it
                        if (CCP[i - 1][j] > 1 + CCP[i][j - coins[i - 1]]) {
                            CCP[i][j] = 1 + CCP[i][j - coins[i - 1]];
                            coinUsed[i][j] = coins[i - 1];
                        } else {
                            CCP[i][j] = CCP[i - 1][j];
                            coinUsed[i][j] = coinUsed[i - 1][j];
                        }
                    } else {
                        // If the coin value is greater than the current amount, do not include the coin
                        CCP[i][j] = CCP[i - 1][j];
                        coinUsed[i][j] = coinUsed[i - 1][j];
                    }
                }
            }
        }

        if (CCP[n][amount] >= Integer.MAX_VALUE - 1) {
            System.out.println("Amount cannot be made with the given coins.");
        } else {
            System.out.println("Minimum number of coins needed: " + CCP[n][amount]);
            System.out.print("Coins used: ");
            printCoins(coinUsed, coins, n, amount);
            System.out.println();
        }
    }

    // Helper function to print the coins used
    private static void printCoins(int[][] coinUsed, int[] coins, int n, int amount) {
        List<Integer> coinsList = new ArrayList<>();
        int i = n;
        int j = amount;

        while (j > 0 && i > 0) {
            if (coinUsed[i][j] != 0) {
                coinsList.add(coinUsed[i][j]);
                j -= coinUsed[i][j];
            } else {
                i--;
            }
        }

        for (int coin : coinsList) {
            System.out.print(coin + " ");
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 50};
        int amount = 121;

        coinChange(coins, amount);
    }
}




