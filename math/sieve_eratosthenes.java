import java.util.Scanner;

public class sieve_eratosthenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();
        sc.close();

        if (n < 2) {
            System.out.println("No primes available below " + n);
            return;
        }

        boolean[] isPrime = sieveOfEratosthenes(n);

        System.out.println("Primes up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static boolean[] sieveOfEratosthenes(int max) {
        boolean[] isPrime = new boolean[max + 1];

        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= max; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= max; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }

        return isPrime;
    }
}
