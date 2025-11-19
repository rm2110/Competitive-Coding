import java.util.*;

public class RecentCalls {
    // Queue to store the timestamps of requests
    private Queue<Integer> q;

    public RecentCalls() {
        q = new LinkedList<>();
    }

    /**
     * Records a request at time t (milliseconds) and returns
     * the number of requests that happened in the past 3000 ms (inclusive).
     *
     * @param t the timestamp of the current request (strictly increasing across calls)
     * @return number of recent calls in [t-3000, t]
     */

    public int ping(int t) {
        q.offer(t);

        // remove any timestamp < t-3000
        int threshold = t - 3000;
        while (!q.isEmpty() && q.peek() < threshold) {
            q.poll();
        }

        return q.size();
    }

    public static void main(String[] args) {
        RecentCalls rc = new RecentCalls();

        // Example test sequence
        System.out.println(rc.ping(1));    
        System.out.println(rc.ping(100));  
        System.out.println(rc.ping(3001)); 
        System.out.println(rc.ping(3002));
        System.out.println(rc.ping(6000)); 
    }
}
