import java.util.*;

class Job implements Comparable<Job> {
    char id;
    int deadline;
    int profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public int compareTo(Job other) {
        return other.profit - this.profit;
    }
}

public class JobSequencingBranchBound {
    static void printJobSequence(Job[] jobs) {
        Arrays.sort(jobs);
        int maxDeadline = Arrays.stream(jobs).mapToInt(job -> job.deadline).max().getAsInt();
        char[] sequence = new char[maxDeadline];
        boolean[] slots = new boolean[maxDeadline];
        Arrays.fill(slots, false);

        for (Job job : jobs) {
            for (int i = Math.min(maxDeadline, job.deadline) - 1; i >= 0; i--) {
                if (!slots[i]) {
                    sequence[i] = job.id;
                    slots[i] = true;
                    break;
                }
            }
        }

        System.out.println("Job Sequence:");
        for (char jobId : sequence) {
            if (jobId != '\0') {
                System.out.print(jobId + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job('a', 2, 100),
            new Job('b', 1, 19),
            new Job('c', 2, 27),
            new Job('d', 1, 25),
            new Job('e', 3, 15)
        };

        printJobSequence(jobs);
    }
}
