public class CoinChange {
    
    // Function to find the minimum number of coins needed to make a given amount
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] CCP = new int[n + 1][amount + 1];

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
                        CCP[i][j] = Math.min(1 + CCP[i][j - coins[i - 1]], CCP[i - 1][j]);
                    } else {
                        // If the coin value is greater than the current amount, do not include the coin
                        CCP[i][j] = CCP[i - 1][j];
                    }
                }
            }
        }

        // If the amount cannot be made with the given coins, return -1
        return (CCP[n][amount] >= Integer.MAX_VALUE - 1) ? -1 : CCP[n][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = coinChange(coins, amount);

        if (result != -1) {
            System.out.println("Minimum number of coins needed: " + result);
        } else {
            System.out.println("Amount cannot be made with the given coins.");
        }
    }
}



