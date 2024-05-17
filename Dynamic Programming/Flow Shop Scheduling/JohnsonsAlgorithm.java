import java.util.*;

class Job {
    int id, time1, time2;

    Job(int id, int time1, int time2) {
        this.id = id;
        this.time1 = time1;
        this.time2 = time2;
    }
}

class JobComparator1 implements Comparator<Job> {
    @Override
    public int compare(Job j1, Job j2) {
        return Integer.compare(j1.time1, j2.time1);
    }
}

class JobComparator2 implements Comparator<Job> {
    @Override
    public int compare(Job j1, Job j2) {
        return Integer.compare(j1.time2, j2.time2);
    }
}

public class JohnsonsAlgorithm {
    public static void ja(List<Job> jobs) {

        List<Job> group1 = new ArrayList<>();
        List<Job> group2 = new ArrayList<>();

        for (Job job : jobs) {
            if (job.time1 < job.time2) {
                group1.add(job);
            } else {
                group2.add(job);
            }
        }

        Collections.sort(group1, new JobComparator1());
        Collections.sort(group2, new JobComparator2());

        List<Job> schedule = new ArrayList<>();
        schedule.addAll(group1);
        schedule.addAll(group2);

        System.out.print("schedule: ");
        for (Job job : schedule) {
            System.out.print("job" + job.id + "->");
        }
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 2, 3));
        jobs.add(new Job(2, 4, 5));
        jobs.add(new Job(3, 1, 2));
        jobs.add(new Job(4, 5, 6));

        ja(jobs);
    }
}
