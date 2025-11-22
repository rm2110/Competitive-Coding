import java.util.*; 

public class subsequenceKlargestSum {
    public static List<Integer> maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        
        // Pair value + index
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new int[]{ nums[i], i });
        }

        // Sort pairs by value ascending
        pairs.sort(Comparator.comparingInt(a -> a[0]));

        // Pick the last k pairs (largest values)
        List<int[]> selected = new ArrayList<>();
        for (int i = n - k; i < n; i++) {
            selected.add(pairs.get(i));
        }

        // Sort selected by original index so as to preserve order
        selected.sort(Comparator.comparingInt(a -> a[1]));

        // Build result
        List<Integer> result = new ArrayList<>();
        for (int[] p : selected) {
            result.add(p[0]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array (Comma Seperated): ");
        String arrStr = sc.nextLine();

        int[] arr = Arrays.stream(arrStr.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.print("Enter K: ");
        int k = sc.nextInt();
        sc.nextLine();

        List<Integer> subseq = maxSubsequence(nums, k);

        System.out.println("A subsequence of length " + k + " with the largest sum is:");
        System.out.println(subseq);

        // Optionally compute sum
        int sum = subseq.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum = " + sum);

        return 0;
    }   
}