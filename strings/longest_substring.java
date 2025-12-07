import java.util.*;

public class longest_substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        sc.close();

        System.out.println(lengthOfLongestSubstring(s));
    }

    // Returns length of longest substring without repeating chars. */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;

        // We can assume ASCII (256 chars) or lowercase only if given
        int[] count = new int[256];  // or [128] for standard ASCII

        int maxLen = 0;
        int left = 0;  // left pointer of window

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            count[c]++;

            // If this char now repeats, move left pointer until no duplicate
            while (count[c] > 1) {
                char leftChar = s.charAt(left);
                count[leftChar]--;
                left++;
            }

            // Now substring s[left..right] is valid (no duplicates)
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
