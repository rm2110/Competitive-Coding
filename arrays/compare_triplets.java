import java.util.Scanner;

public class compare_triplets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String lineA = sc.nextLine().trim();
        String[] partsA = lineA.split("\\s+");
        int n = partsA.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(partsA[i]);
        }
        
        String lineB = sc.nextLine().trim();
        String[] partsB = lineB.split("\\s+");
        int m = partsB.length;
        if (m != n) {
            System.out.println("Invalid input");  
            return;
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(partsB[i]);
        }
        
        int first = 0, second = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > b[i]) first++;
            else if (a[i] < b[i]) second++;
        }
        
        System.out.println(first + " " + second);
        sc.close();
    }
}
