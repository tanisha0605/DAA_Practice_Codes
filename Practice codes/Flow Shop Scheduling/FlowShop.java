import java.util.*;

class Job{

    int id;
    int mt;
    char mn;

    Job(int id,int mt,char mn){
        this.id=id;
        this.mt=mt;
        this.mn=mn;
    }

}
public class FlowShop {
    public static int[] JohnsonJobs(ArrayList<Job> jobs,int n){
        int[] sequence = new int[n];
        int left=0;
        int right=n-1;

        Collections.sort(jobs,Comparator.comparingInt((Job j) -> j.mt));

        while(!jobs.isEmpty()){
            Job currentJob = jobs.get(0);
            jobs.remove(0);

            if(currentJob.mn == 'A'){
                sequence[left]=currentJob.id;
                left++;
            }else{
                sequence[right]=currentJob.id;
                right--;
            }

            for(int i=0; i<jobs.size(); i++){
                if(jobs.get(i).id == currentJob.id){
                    jobs.remove(i);
                    i--;
                }
            }
        }
        return sequence;
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of jobs: ");
        int numberOfJobs=sc.nextInt();

        ArrayList<Job> jobList = new ArrayList<>();
        System.out.println("Enter job number, Machine 1 time, and Machine 2 time for each job:");

        for(int i=0; i<numberOfJobs; i++){
            System.out.println("Job "+(i+1)+":");
            int jobId=sc.nextInt();
            int machine1Time=sc.nextInt();
            int machine2Time=sc.nextInt();
            jobList.add(new Job(jobId, machine1Time, 'A'));
            jobList.add(new Job(jobId, machine2Time, 'B'));
        }
        int[] optimalSequence = new int[numberOfJobs];

        optimalSequence=JohnsonJobs(jobList, numberOfJobs);
        System.out.println("The optimal job sequence according to Johnson's algorithm is:");
        for(int jobId:optimalSequence){
            System.out.print(jobId +" -> ");
        }
        sc.close();
    }
}

