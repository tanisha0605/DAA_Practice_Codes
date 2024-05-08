
public class MatrixChainMultiplication {
    static int matrixChainOrder(int[] p, int n, int[] bracket) {
        int[][] m = new int[n][n];

        for (int i = 1; i < n; i++)
            m[i][i] = 0;

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        bracket[i * n + j] = k;
                    }
                }
            }
        }
        return m[1][n - 1];
    }

    static void printParenthesis(int i, int j, int n, int[] bracket) {
        if (i == j) {
            System.out.print((char)('A' + i - 1));
            return;
        }
        System.out.print("(");
        printParenthesis(i, bracket[i * n + j], n, bracket);
        printParenthesis(bracket[i * n + j] + 1, j, n, bracket);
        System.out.print(")");
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 2, 1};
        int n = arr.length;
        int[] bracket = new int[n * n];

        System.out.println("Minimum number of multiplications is " + matrixChainOrder(arr, n, bracket));
        System.out.print("Optimal parenthesization is: ");
        printParenthesis(1, n - 1, n, bracket);
        System.out.println();
    }
}

