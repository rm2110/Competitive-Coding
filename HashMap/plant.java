import java.util.*;

public class plant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read all integers from input until end — these are plant IDs
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        sc.close();

        if (list.isEmpty()) {
            System.out.println("");  // or some default — no input
            return;
        }

        // Count frequencies using a HashMap: id → count
        Map<Integer, Integer> freq = new HashMap<>();
        for (int id : list) {
            freq.put(id, freq.getOrDefault(id, 0) + 1);
        }

        // Determine the most frequent ID; on tie, choose smallest ID
        int bestId = Integer.MAX_VALUE;
        int bestCount = 0;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int id = entry.getKey();
            int cnt = entry.getValue();
            // if this ID has higher count, or same count but smaller ID
            if (cnt > bestCount || (cnt == bestCount && id < bestId)) {
                bestCount = cnt;
                bestId = id;
            }
        }

        System.out.println(bestId);
    }
}
