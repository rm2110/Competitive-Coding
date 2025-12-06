import java.util.*;

public class divisible_sum_pairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Read divisor k
        if (!sc.hasNextInt()) {
            System.out.println(0);
            sc.close();
            return;
        }
        int k = sc.nextInt();
        // Read the rest of the line (array elements)
        // We’ll assume the rest of input line contains the array elements
        // separated by whitespace.
        // Alternatively, you could read array length then array elements.
        // Here we read until EOF / no more ints.
        int[] arr = new int[0]; // placeholder
        List<Integer> tmp = new ArrayList<>();
        while (sc.hasNextInt()) {
            tmp.add(sc.nextInt());
        }
        sc.close();
        int n = tmp.size();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = tmp.get(i);
        }

        long result = countDivisibleSumPairs(arr, k);
        System.out.println(result);
    }

    /**
     * Returns the number of pairs (i,j), i < j, such that
     * arr[i] + arr[j] is divisible by k.
     */
    public static long countDivisibleSumPairs(int[] arr, int k) {
        long count = 0;
        // freq[r] = number of elements seen so far with remainder r (mod k)
        long[] freq = new long[k];
        for (int x : arr) {
            int rem = ((x % k) + k) % k;  // remainder in [0..k-1]
            int complement = (k - rem) % k;
            // All previous numbers with remainder = complement will pair
            count += freq[complement];
            // Then add this number to freq
            freq[rem]++;
        }
        return count;
    }
}
