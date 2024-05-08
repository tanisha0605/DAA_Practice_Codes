import java.util.Arrays;

public class FibonacciMemoization {
    static int fib(int n, int[] lookupTable) {
        if (lookupTable[n] != -1) {
            return lookupTable[n];
        }

        int result;
        if (n <= 1) {
            result = n;
        } else {
            result = fib(n - 2, lookupTable) + fib(n - 1, lookupTable);
        }

        lookupTable[n] = result;
        return result;
    }

    public static void main(String[] args) {
        int n = 10; // Fibonacci number to find
        int[] lookupTable = new int[n + 1];
        Arrays.fill(lookupTable, -1);

        System.out.println("Fibonacci number at position " + n + ": " + fib(n, lookupTable));
    }
}

