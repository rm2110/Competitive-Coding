import java.util.*;

public class maxProdKincrements {
    public int maximumProduct(int[] nums, int k) {
        final int MOD = 1_000_000_007;

        // min-heap to always pick smallest element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
        }

        // perform k increments
        for (int i = 0; i < k; i++) {
            int smallest = minHeap.poll();
            smallest += 1;
            minHeap.offer(smallest);
        }

        // compute product modulo MOD
        long product = 1;
        while (!minHeap.isEmpty()) {
            product = (product * minHeap.poll()) % MOD;
        }
        return (int) product;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array (Comma Seperated): ");
        String arrStr = sc.nextLine();

        int[] arr = Arrays.stream(arrStr.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.print("Enter K: ");
        int k = sc.nextInt();
        sc.nextLine();

        System.out.print("Maximum product after K Increments is: " + maximumProduct(arr, k));

        sc.close();
    }
}
