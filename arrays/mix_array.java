import java.util.Scanner;

public class mix_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();     
        int q = sc.nextInt();     

        long[] diff = new long[n + 2];  

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long k = sc.nextLong();

            diff[a] += k;
            diff[b + 1] -= k;
        }
        sc.close();

        long max = 0;
        long current = 0;
        for (int i = 1; i <= n; i++) {
            current += diff[i];
            if (current > max) {
                max = current;
            }
        }

        System.out.println(max);
    }
}
