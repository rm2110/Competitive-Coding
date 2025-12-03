import java.util.*;

public class job_sequencing_deadline {
    static class Job {
        char id;
        int deadline;
        int profit;

        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        int n = sc.nextInt();

        char[] jobIds = new char[n];
        for (int i = 0; i < n; i++) {
            jobIds[i] = sc.next().charAt(0);
        }

        int[] deadlines = new int[n];
        for (int i = 0; i < n; i++) {
            deadlines[i] = sc.nextInt();
        }

        int[] profits = new int[n];
        for (int i = 0; i < n; i++) {
            profits[i] = sc.nextInt();
        }

        sc.close();

        // Build job list
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(jobIds[i], deadlines[i], profits[i]);
        }

        List<Character> schedule = jobSequencing(jobs);

        // Print scheduled job IDs in order
        for (char c : schedule) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    /**
     * Returns a list of job-IDs (in scheduled order) that maximizes profit
     * under given deadlines (unit-time jobs, single slot per unit time).
     */
    public static List<Character> jobSequencing(Job[] jobs) {
        int n = jobs.length;

        // Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));

        // Find maximum deadline to know size of schedule slots
        int maxDeadline = 0;
        for (Job j : jobs) {
            if (j.deadline > maxDeadline) {
                maxDeadline = j.deadline;
            }
        }

        // Slots for the schedule, -1 means empty
        // We'll index slots as 1..maxDeadline, but use array 0..maxDeadline
        char[] slot = new char[maxDeadline + 1];
        boolean[] used = new boolean[maxDeadline + 1];
        // Initialize slots as empty
        for (int i = 0; i <= maxDeadline; i++) {
            slot[i] = 0;
            used[i] = false;
        }

        // Result schedule (job IDs in the order of actual time slots)
        // We'll fill `slot`, then read back non-empty in time order
        for (Job job : jobs) {
            // Try to schedule job at latest possible slot before its deadline
            for (int t = job.deadline; t >= 1; t--) {
                if (!used[t]) {
                    used[t] = true;
                    slot[t] = job.id;
                    break;
                }
            }
        }

        List<Character> result = new ArrayList<>();
        for (int t = 1; t <= maxDeadline; t++) {
            if (used[t]) {
                result.add(slot[t]);
            }
        }

        return result;
    }
}
