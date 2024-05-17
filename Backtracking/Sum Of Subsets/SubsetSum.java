public class SubsetSum {
    // Function to print the subsets that sum up to a given sum
    static void printSubset(int arr[], int n, int sum, int index, int currSum, int[] subset) {
        // If the current sum equals the desired sum, print the subset
        if (currSum == sum) {
            System.out.print("{");
            for (int i = 0; i < index; i++)
                if(subset[i] != 0)
                    System.out.print(subset[i]+" ");
            System.out.println("}");
            return;
        }
        // If the index exceeds the array size or the current sum exceeds the desired sum, return
        if (index == n || currSum > sum)
            return;
        // Include the current element in the subset and recursively search for the next elements
        subset[index] = arr[index];
        printSubset(arr, n, sum, index + 1, currSum + arr[index], subset);
        // Exclude the current element from the subset and recursively search for the next elements
        subset[index] = 0;
        printSubset(arr, n, sum, index + 1, currSum, subset);
    }

    // Main function
    public static void main(String[] args) {
        // Input array and desired sum
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        int n = arr.length;
        // Array to store the current subset
        int[] subset = new int[n];
        // Call the printSubset function to find and print subsets that sum up to the given sum
        printSubset(arr, n, sum, 0, 0, subset);
    }
}


