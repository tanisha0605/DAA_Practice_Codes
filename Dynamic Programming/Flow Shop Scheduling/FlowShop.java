import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

// Class to represent a Job with its ID, machine time, and machine name
class Job {
    int id; // Job ID
    int mt; // Machine time
    char mn; // Machine name (A or B)

    // Constructor to initialize a Job object
    Job(int id, int mt, char mn) {
        this.id = id;
        this.mt = mt;
        this.mn = mn;
    }
}

public class FlowShop {

    // Function to find the optimal job sequence using Johnson's algorithm
    public static int[] JhonsonJobs(ArrayList<Job> jobs, int n) {
        int[] sequence = new int[n]; // Array to store the final job sequence
        int left = 0; // Pointer for the left side of the sequence
        int right = n - 1; // Pointer for the right side of the sequence

        // Sort the jobs by their machine time in ascending order
        Collections.sort(jobs, Comparator.comparingInt((Job j) -> j.mt));

        // Process jobs one by one
        while (!jobs.isEmpty()) {
            Job currentJob = jobs.get(0); // Get the job with the least time
            jobs.remove(0); // Remove it from the list

            if (currentJob.mn == 'A') {
                // If the job is for machine A, add it to the left side of the sequence
                sequence[left] = currentJob.id;
                left++;
            } else {
                // If the job is for machine B, add it to the right side of the sequence
                sequence[right] = currentJob.id;
                right--;
            }

            // Remove all occurrences of this job ID from the list
            for (int i = 0; i < jobs.size(); i++) {
                if (jobs.get(i).id == currentJob.id) {
                    jobs.remove(i);
                    i--; // Decrement index to stay in bounds after removal
                }
            }
        }
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of jobs:");
        int numberOfJobs = scanner.nextInt();

        ArrayList<Job> jobList = new ArrayList<>();
        System.out.println("Enter job number, Machine 1 time, and Machine 2 time for each job:");
        
        for (int i = 0; i < numberOfJobs; i++) {
            System.out.println("Job " + (i + 1) + ":");
            int jobId = scanner.nextInt();
            int machine1Time = scanner.nextInt();
            int machine2Time = scanner.nextInt();
            jobList.add(new Job(jobId, machine1Time, 'A')); // Add job for machine 1
            jobList.add(new Job(jobId, machine2Time, 'B')); // Add job for machine 2
        }

        int[] optimalSequence = JhonsonJobs(jobList, numberOfJobs);

        System.out.println("The optimal job sequence according to Johnson's algorithm is:");
        for (int jobId : optimalSequence) {
            System.out.print(jobId + " -> ");
        }
        
        scanner.close();
    }
}

