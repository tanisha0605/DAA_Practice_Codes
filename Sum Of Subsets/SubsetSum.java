public class SubsetSum {
    // Function to print the subset
    static void printSubset(int arr[], int n, int sum, int index, int currSum, int[] subset) {
        if (currSum == sum) {
            System.out.print("{");
            for (int i = 0; i < index; i++)
                System.out.print(subset[i]);
            System.out.println("}");
            return;
        }
        if (index == n || currSum > sum)
            return;
        subset[index] = arr[index];
        printSubset(arr, n, sum, index + 1, currSum + arr[index], subset);
        subset[index] = 0;
        printSubset(arr, n, sum, index + 1, currSum, subset);
    }

    // Main function
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        int n = arr.length;
        int[] subset = new int[n];
        printSubset(arr, n, sum, 0, 0, subset);
    }
}

