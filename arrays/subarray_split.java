import java.util.Scanner;

public class subarray_split {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        sc.close();

        if (line.isEmpty()) {
            System.out.println(0);
            return;
        }

        String[] parts = line.split("\\s+");
        int n = parts.length;
        long[] arr = new long[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(parts[i]);
            total += arr[i];
        }

        // If array size < 2, no valid split (since both parts must be non-empty)
        if (n < 2) {
            System.out.println(0);
            return;
        }

        long leftSum = 0;
        int validSplits = 0;

        // Iterate through possible split points:
        // split after index i -> left = arr[0..i], right = arr[i+1..n-1]
        // So i ranges from 0 to n-2 (so right part non-empty)
        for (int i = 0; i < n - 1; i++) {
            leftSum += arr[i];
            long rightSum = total - leftSum;

            if (leftSum >= rightSum) {
                validSplits++;
            }
        }

        System.out.println(validSplits);
    }
}
