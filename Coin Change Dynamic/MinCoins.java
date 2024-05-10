import java.util.Scanner;

public class MinCoins {
    // Function to find the minimum number of coins needed to make change for a given amount
    static int minCoins(int[] coins, int n, int amount) {
        // Array to store the minimum number of coins needed for each amount
        int[] dp = new int[amount + 1];
        // Array to store the coin denomination used for each amount
        int[] coinUsed = new int[amount + 1];

        // Base case: 0 coins needed to make change for 0 amount
        dp[0] = 0;

        // Fill dp array iteratively for each amount from 1 to 'amount'
        for (int i = 1; i <= amount; i++) {
            // Initialize dp[i] to infinity
            dp[i] = Integer.MAX_VALUE;

            // Iterate through each coin denomination
            for (int j = 0; j < n; j++) {
                // If the current coin denomination can be used to make change for the current amount 'i'
                if (coins[j] <= i) {
                    // Calculate the minimum number of coins needed for amount 'i' using the current coin denomination
                    int subRes = dp[i - coins[j]];
                    // If subResult is not infinity and adding one coin of current denomination reduces the number of coins needed for 'i'
                    if (subRes != Integer.MAX_VALUE && subRes + 1 < dp[i]) {
                        // Update dp[i] and coinUsed[i]
                        dp[i] = subRes + 1;
                        coinUsed[i] = coins[j];
                    }
                }
            }
        }

        // Print the coin denominations used to make change for the given amount
        System.out.print("Coin denominations used: ");
        int remainingAmount = amount;
        while (remainingAmount > 0) {
            System.out.print(coinUsed[remainingAmount] + " ");
            remainingAmount -= coinUsed[remainingAmount];
        }
        System.out.println();

        // Return the minimum number of coins needed for the given amount
        return dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array representing available coin denominations
        int[] coins = {1, 5, 10, 25};
        int n = coins.length;

        // Input purchase amount and amount paid
        System.out.print("Enter purchase amount: ");
        int purchaseAmount = scanner.nextInt();
        System.out.print("Enter amount paid: ");
        int amountPaid = scanner.nextInt();

        // Calculate the change amount
        int changeAmount = amountPaid - purchaseAmount;

        // Find the minimum number of coins needed for change
        int minCoinsNeeded = minCoins(coins, n, changeAmount);

        // Output the result
        System.out.println("Minimum number of coins needed for change: " + minCoinsNeeded);

        scanner.close();
    }
}


