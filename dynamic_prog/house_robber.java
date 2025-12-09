import java.util.Scanner;
import java.util.Arrays;

public class house_robber {
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
        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(parts[i]);
        }

        int result = robMemo(houses);
        System.out.println(result);
    }

    public static int robMemo(int[] houses) {
        int n = houses.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return helper(houses, 0, memo);
    }

    private static int helper(int[] houses, int i, int[] memo) {
        if (i >= houses.length) {
            return 0;  // no houses left
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        // Option 1: rob this house -> then skip next (i+1), so go to i+2
        int robIt = houses[i] + helper(houses, i + 2, memo);
        // Option 2: skip this house -> try from next house (i+1)
        int skipIt = helper(houses, i + 1, memo);

        int ans = Math.max(robIt, skipIt);
        memo[i] = ans;
        return ans;
    }
}
