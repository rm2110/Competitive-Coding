import java.util.*;

public class KpairsSmallest {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }
        
        // Min-heap storing entries: (sum, index in nums1, index in nums2)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        // Initialize by pairing each of the first min(k, nums1.length) elements of nums1 with nums2[0]
        int len1 = nums1.length, len2 = nums2.length;
        for (int i = 0; i < Math.min(len1, k); i++) {
            minHeap.offer(new int[]{ nums1[i] + nums2[0], i, 0 });
        }
        
        // Extract k pairs
        while (k > 0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int i = cur[1];
            int j = cur[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;
            
            // If there is a next element in nums2 for this i, push that pair
            if (j + 1 < len2) {
                minHeap.offer(new int[]{ nums1[i] + nums2[j+1], i, j+1 });
            }
        }
        
        return result;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st array (Comma Seperated): ");
        String arrStr1 = sc.nextLine();

        System.out.print("Enter 2nd array (Comma Seperated): ");
        String arrStr2 = sc.nextLine();

        int[] arr1 = Arrays.stream(arrStr1.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(arrStr2.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.print("Enter K: ");
        int k = sc.nextInt();
        sc.nextLine();

        List<List<Integer>> ans = kSmallestPairs(arr1, arr2, k);

        System.out.println("The " + k + " pairs with the smallest sums are:");
        for (List<Integer> pair : ans) {
            System.out.println("(" + pair.get(0) + ", " + pair.get(1) + ")");
        }

        sc.close();

        return 0;
    }
}
