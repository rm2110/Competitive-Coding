import java.util.*;

public class special_prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        System.out.println(largestSpecialPrimeLessThan(N));
    }

    static int largestSpecialPrimeLessThan(int N) {
        if (N <= 2) return -1;
        boolean[] isPrime = sieve(N);
        for (int p = N - 1; p >= 2; p--) {
            if (!isPrime[p]) continue;
            if (isSpecialPrime(p, isPrime)) {
                return p;
            }
        }
        return -1;
    }

    static boolean[] sieve(int limit) {
        int size = limit + 1;
        boolean[] isPrime = new boolean[size];
        Arrays.fill(isPrime, true);
        if (size > 0) isPrime[0] = false;
        if (size > 1) isPrime[1] = false;
        for (int i = 2; i * i < size; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < size; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    static boolean isSpecialPrime(int p, boolean[] isPrime) {
        int x = p;
        while (x > 0) {
            if (!isPrime[x]) return false;
            x /= 10;
        }
        return true;
    }
}
