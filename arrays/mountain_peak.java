import java.util.*;

public class mountain_peak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        sc.close();

        if (line.isEmpty()) {
            System.out.println("0");
            System.out.println();  
            return;
        }

        String[] parts = line.split("\\s+");
        int n = parts.length;
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(parts[i]);
        }

        // Compute peaks
        // A peak is an element strictly greater than its neighbors
        // We ignore first and last elements (they have only one neighbor)
        int globalMaxPeak = Integer.MIN_VALUE;
        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < n - 1; i++) {
            if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
                int h = heights[i];
                if (h > globalMaxPeak) {
                    // Found a higher peak: reset list
                    globalMaxPeak = h;
                    peaks.clear();
                    peaks.add(h);
                } else if (h == globalMaxPeak) {
                    // Another peak with same highest height
                    peaks.add(h);
                }
                // if h < globalMaxPeak -> ignore (lower peak)
            }
        }

        if (peaks.isEmpty()) {
            // No valid peak found
            System.out.println("0");
            System.out.println();
        } else {
            // Print count of highest peaks
            System.out.println(peaks.size());
            // Print the peak heights (all same, but as many times as count)
            // Or if you want unique heights, you can print only one.
            for (int h : peaks) {
                System.out.print(h + " ");
            }
            System.out.println();
        }
    }
}
