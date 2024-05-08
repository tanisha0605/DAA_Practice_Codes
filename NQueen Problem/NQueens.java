import java.util.Scanner;

public class NQueens {
    static int[] x = new int[20];

    static boolean place(int k, int i) {
        for (int j = 1; j <= k - 1; j++) {
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }

    static void N_queen(int k, int n) {
        for (int i = 1; i <= n; i++) {
            if (place(k, i)) {
                x[k] = i;
                if (k == n) {
                    // If all queens are placed
                    System.out.print("Solution: ");
                    for (int j = 1; j <= n; j++) {
                        System.out.print(x[j] + " ");
                    }
                    System.out.println();
                } else {
                    N_queen(k + 1, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N for N-queen problem: ");
        int n = scanner.nextInt();
        scanner.close();
        
        if (n <= 0) {
            System.out.println("Invalid input. N should be a positive integer.");
            return;
        }
        
        N_queen(1, n); // Start with the first queen
    }
}

