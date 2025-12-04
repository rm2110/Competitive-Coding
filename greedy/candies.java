import java.util.PriorityQueue;
import java.util.Scanner;

public class candies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the target sweetness level
        long target = sc.nextLong();

        PriorityQueue<Long> pq = new PriorityQueue<>();

        while (sc.hasNextLong()) {
            pq.offer(sc.nextLong());
        }
        sc.close();

        // If no candies, impossible
        if (pq.isEmpty()) {
            System.out.println(-1);
            return;
        }

        int operations = 0;

        // Keep combining until the smallest candy meets or exceeds target
        while (pq.peek() < target) {
            if (pq.size() < 2) {
                // Not enough candies to combine → impossible
                operations = -1;
                break;
            }

            long least = pq.poll();       // smallest
            long second = pq.poll();      // 2nd smallest

            long combined = least + 2 * second;
            pq.offer(combined);
            operations++;
        }

        System.out.println(operations);
    }
}
