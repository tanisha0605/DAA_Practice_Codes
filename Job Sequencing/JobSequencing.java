
public class JobSequencing{

    public static void jobSequencing(int[] jobs, int[] profits, int[] deadlines, int dmax){
        for(int i=0; i<jobs.length; i++){
            for(int j=i; j<jobs.length; j++){
                if(profits[i]<profits[j]){
                    int tempProf=profits[i];
                    int tempDeadLine=deadlines[i];
                    int tempJobs=jobs[i];

                    profits[i]=profits[j];
                    deadlines[i]=deadlines[j];
                    jobs[i]=jobs[j];

                    profits[j]=tempProf;
                    deadlines[j]=tempDeadLine;
                    jobs[j]=tempJobs;
                }
            }
        }

        // this part is just for visualisation
       for(int i=0; i<jobs.length; i++){
           System.out.print(jobs[i] + "\t") ;
       }
        System.out.println("");
        for(int i=0; i<jobs.length; i++){
            System.out.print(deadlines[i] + "\t") ;
        }
        System.out.println("");
        for(int i=0; i<jobs.length; i++){
            System.out.print(profits[i] + "\t") ;
        }
        System.out.println("\n");

        int profit=0;
        int[] slot=new int[dmax];
        for(int i=0; i<dmax; i++){
            slot[i]=-1;
        }
        int count=0;

        for(int i=0; i<jobs.length; i++){
            for(int j=deadlines[i]-1; j>=0; j--){
                if (slot[j]==-1){
                    slot[j]=jobs[i];
                    profit=profit+ profits[i];
                    count++;
                    break;
                }
            }
            if(count==dmax){
                break;
            }
        }

        for(int i=0; i<dmax; i++){
            System.out.print(slot[i] + "\t");
        }

        System.out.println("\n\ntotal profit: " + profit);

    }
      public static void main(String[] args) {

        int[] jobs={1,2,3,4,5,6,7};
        int[] profits={3,5,20,18,2,7,30};
        int[] deadlines={1,3,4,3,2,1,2};

        jobSequencing(jobs, profits,deadlines, 4);
    }
}
