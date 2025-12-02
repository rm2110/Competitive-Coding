import java.util.*;

public class chunksSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) {
            sc.close();
            return;
        }
        
        String line = sc.nextLine();
        sc.close();

        String[] parts = line.trim().split("\\s+");
        int n = parts.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        printChunks(arr);
    }

    public static void printChunks(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int chunkStart = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            if (maxSoFar == i) {
                for (int j = chunkStart; j <= i; j++) {
                    System.out.print(arr[j] + (j < i ? " " : ""));
                }
                System.out.println();
                chunkStart = i + 1;
            }
        }
    }
}
