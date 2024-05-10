import java.util.Arrays;
public class JobSequencing {

    public static void jobSequencing(int[] jobs, int[] profits, int[] deadlines, int dmax) {
        int n = jobs.length;

        // Sort jobs based on profits in descending order
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (profits[i] < profits[j]) {
                    int temp = profits[i];
                    profits[i] = profits[j];
                    profits[j] = temp;

                    temp = deadlines[i];
                    deadlines[i] = deadlines[j];
                    deadlines[j] = temp;

                    temp = jobs[i];
                    jobs[i] = jobs[j];
                    jobs[j] = temp;
                }
            }
        }

        // Array to store the sequence of jobs executed
        int[] slot = new int[dmax];
        Arrays.fill(slot, -1);

        // Variables to keep track of total profit and number of jobs executed
        int profit = 0;
        int count = 0;

        // Assign jobs to slots based on deadlines
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(dmax - 1, deadlines[i] - 1); j >= 0; j--) {
                if (slot[j] == -1) {
                    slot[j] = jobs[i];
                    profit += profits[i];
                    count++;
                    break;
                }
            }
            if (count == dmax) {
                break;
            }
        }

        // Output the sequence of jobs executed and total profit
        System.out.print("Jobs Sequence: ");
        for (int i = 0; i < dmax; i++) {
            if (slot[i] != -1) {
                System.out.print(slot[i] + " ");
            }
        }
        System.out.println("\nTotal Profit: " + profit);
    }

    public static void main(String[] args) {
        int[] jobs = {1, 2, 3, 4, 5, 6, 7};
        int[] profits = {3, 5, 20, 18, 2, 7, 30};
        int[] deadlines = {1, 3, 4, 3, 2, 1, 2};
        int dmax = 4;

        jobSequencing(jobs, profits, deadlines, dmax);
    }
}

