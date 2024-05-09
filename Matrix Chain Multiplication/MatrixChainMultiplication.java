public class MatrixChainMultiplication {
    // Function to find the minimum number of multiplications needed for matrix chain multiplication
    static int matrixChainOrder(int[] p, int n, int[] bracket) {
        // Create a 2D array to store minimum number of multiplications
        int[][] m = new int[n][n];

        // Initialize diagonal elements to 0 (no multiplication needed for single matrix)
        for (int i = 1; i < n; i++)
            m[i][i] = 0;

        // Build the table to store minimum number of multiplications needed for different chain lengths
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                // Try all possible split points and find the one that minimizes the number of multiplications
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        bracket[i * n + j] = k; // Store the split point for optimal parenthesization
                    }
                }
            }
        }
        // Return the minimum number of multiplications needed for the entire chain
        return m[1][n - 1];
    }

    // Function to print the optimal parenthesization
    static void printParenthesis(int i, int j, int n, int[] bracket) {
        if (i == j) {
            System.out.print((char)('A' + i - 1)); // Print single matrix
            return;
        }
        System.out.print("("); // Print opening parenthesis
        printParenthesis(i, bracket[i * n + j], n, bracket); // Recursively print left subexpression
        printParenthesis(bracket[i * n + j] + 1, j, n, bracket); // Recursively print right subexpression
        System.out.print(")"); // Print closing parenthesis
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 2, 1}; // Dimensions of matrices
        int n = arr.length; // Number of matrices
        int[] bracket = new int[n * n]; // Array to store split points for optimal parenthesization

        // Find the minimum number of multiplications and print the optimal parenthesization
        System.out.println("Minimum number of multiplications is " + matrixChainOrder(arr, n, bracket));
        System.out.print("Optimal parenthesization is: ");
        printParenthesis(1, n - 1, n, bracket);
        System.out.println();
    }
}

