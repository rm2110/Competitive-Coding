import java.util.Scanner;

public class tower_breaker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        System.out.println(towerBreakers(n, m));
    }

    public static int towerBreakers(int n, int m) {
        // Special case: only one tower — Player1 wins
        if (n == 1) {
            return 1;
        }
        // Special rule for your variant: multiple towers + height 1 → game ends immediately, Player1 wins
        if (m == 1) {
            return 1;
        }
      
        // Otherwise, standard logic:
        if (n % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }
}
