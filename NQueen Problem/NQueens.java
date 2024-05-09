import java.util.Scanner;

public class NQueens {
    static int[] x = new int[20]; // Array to store the column positions of queens

    // Function to check if it is safe to place a queen in column i at row k
    static boolean place(int k, int i) {
        // Check if there's any queen in the same column or diagonals
        for (int j = 1; j <= k - 1; j++) {
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false; // Unsafe to place a queen here
            }
        }
        return true; // It is safe to place a queen here
    }

    // Function to find solutions to the N-queens problem using backtracking
    static void N_queen(int k, int n) {
        // Loop through all rows in the current column
        for (int i = 1; i <= n; i++) {
            // Check if it's safe to place a queen in this position
            if (place(k, i)) {
                x[k] = i; // Place the queen in this position
                if (k == n) {
                    // If all queens are placed, print the solution
                    System.out.print("Solution: ");
                    for (int j = 1; j <= n; j++) {
                        System.out.print(x[j] + " "); // Print column positions of queens
                    }
                    System.out.println(); // Move to the next line
                } else {
                    N_queen(k + 1, n); // Move to the next column
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N for N-queen problem: ");
        int n = scanner.nextInt(); // Input the size of the chessboard
        scanner.close(); // Close the scanner
        
        if (n <= 0) {
            System.out.println("Invalid input. N should be a positive integer.");
            return; // Exit the program if input is invalid
        }
        
        N_queen(1, n); // Start with the first queen in the first column
    }
}


