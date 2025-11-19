import java.util.*;

public class getKthLargest {
    public static int findKthLargest(int[] arr, int k) {
        if (k <= 0 || k > arr.length) {
            System.err.println("Error: k must be between 1 and the array size.");
            return -1; // Or throw an exception
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);
            // If the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // The root of the min-heap is the k-th largest element
        return minHeap.peek();
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array (Space Seperated): ");
        String arrStr = sc.nextLine();

        int[] arr = Arrays.stream(arrStr.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.print("Enter K: ");
        int k = sc.nextInt();
        sc.nextLine();

        System.out.print("Kth Largest element is: " + findKthLargest(arr, k));

        sc.close();
    }
}