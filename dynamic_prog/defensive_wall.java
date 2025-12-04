import java.util.Scanner;

public class defensive_wall {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // wall height
        int m = sc.nextInt();  // wall width
        sc.close();

        System.out.println(countSolidWalls(n, m));
    }

    /**
     * Returns the number of ways to build a wall of height = n and width = m,
     * using bricks of widths 1..4, with no holes, horizontal bricks only,
     * and no vertical line running through the entire height (i.e. no vertical crack).
     */
    static int countSolidWalls(int n, int m) {
        // Step 1: ways to build a single row of width w
        long[] rowWays = new long[m + 1];
        rowWays[0] = 1;  // base: width 0, one way (empty)
        for (int w = 1; w <= m; w++) {
            long ways = 0;
            for (int brick = 1; brick <= 4; brick++) {
                if (w - brick >= 0) {
                    ways = (ways + rowWays[w - brick]) % MOD;
                }
            }
            rowWays[w] = ways;
        }

        // Step 2: ways to build any wall (ignoring vertical-crack constraint)
        // That is rowWays[m] ^ n  (mod MOD)
        long[] total = new long[m + 1];
        for (int w = 0; w <= m; w++) {
            total[w] = modPow(rowWays[w], n, MOD);
        }

        // Step 3: compute ways to build “solid” walls (no vertical crack)
        long[] solid = new long[m + 1];
        solid[0] = 1;  // width 0: one trivial wall
        for (int w = 1; w <= m; w++) {
            // start with all possible walls
            long valid = total[w];
            // subtract those with a first vertical crack at position i (1..w-1)
            for (int split = 1; split < w; split++) {
                long leftSolid = solid[split];
                long rightAny = total[w - split];
                valid = (valid - (leftSolid * rightAny) % MOD + MOD) % MOD;
            }
            solid[w] = valid;
        }

        // answer: number of solid walls of width m
        return (int) solid[m];
    }

    /**
     * Computes (base^exp) mod modulo using fast exponentiation.
     */
    static long modPow(long base, int exp, int modulo) {
        long result = 1;
        base %= modulo;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % modulo;
            }
            base = (base * base) % modulo;
            exp >>= 1;
        }
        return result;
    }
}
