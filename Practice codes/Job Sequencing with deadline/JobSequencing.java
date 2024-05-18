import java.util.*;
public class JobSequencing {
    static void sequencing(int[] jobs,int[] profits,int[] deadlines,int dmax){
        int n=jobs.length;

        for(int i=0;i< n-1 ;i++){
            for(int j=0;j<n-i-1;j++){
                if(profits[j] < profits[j+1]){
                    int tempProfit= profits[j];
                    profits[j]=profits[j+1];
                    profits[j+1]=tempProfit;

                    int tempJob= jobs[j];
                    jobs[j]=jobs[j+1];
                    jobs[j+1]=tempJob;

                    int tempDeadline= deadlines[j];
                    deadlines[j]=deadlines[j+1];
                    deadlines[j+1]=tempDeadline;
                }
            }
        }
        int[] slot= new int[n];
        Arrays.fill(slot,-1);

        int profit=0;
        int count=0;

        for(int i=0;i<n;i++){
            for(int j = Math.min(dmax-1,deadlines[i]-1);j>=0;j--){
                if(slot[j]==-1){
                    slot[j]=jobs[i];
                    profit += profits[i];
                    count++;
                    break;
                }
            }
            if(count == dmax){
                break;
            }
        }
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

        sequencing(jobs, profits, deadlines, dmax);
    }
    }

