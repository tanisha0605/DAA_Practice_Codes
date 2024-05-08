import java.util.Scanner;

public class MinCoins {
    static int minCoins(int[] coins, int n, int amount) {
        int[] dp = new int[amount + 1];
        int[] coinUsed = new int[amount + 1];

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    int subRes = dp[i - coins[j]];
                    if (subRes != Integer.MAX_VALUE && subRes + 1 < dp[i]) {
                        dp[i] = subRes + 1;
                        coinUsed[i] = coins[j];
                    }
                }
            }
        }

        System.out.print("Coin denominations used: ");
        int remainingAmount = amount;
        while (remainingAmount > 0) {
            System.out.print(coinUsed[remainingAmount] + " ");
            remainingAmount -= coinUsed[remainingAmount];
        }
        System.out.println();

        return dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coins = {1, 5, 10, 25};
        int n = coins.length;

        System.out.print("Enter purchase amount: ");
        int purchaseAmount = scanner.nextInt();

        System.out.print("Enter amount paid: ");
        int amountPaid = scanner.nextInt();

        int changeAmount = amountPaid - purchaseAmount;

        int minCoinsNeeded = minCoins(coins, n, changeAmount);

        System.out.println("Minimum number of coins needed for change: " + minCoinsNeeded);

        scanner.close();
    }
}

