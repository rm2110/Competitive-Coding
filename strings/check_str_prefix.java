import java.util.Scanner;

public class check_str_prefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) {
            System.out.println("BAD PASSWORD");
            return;
        }

        String line = sc.nextLine().trim();
        String[] pwds = line.split("\\s+");

        boolean good = true;

        int n = pwds.length;
        for (int i = 0; i < n && good; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                String a = pwds[i];
                String b = pwds[j];
                if (b.startsWith(a)) {
                    good = false;
                    break;
                }
            }
        }

        if (good) {
            System.out.println("GOOD PASSWORD");
        } else {
            System.out.println("BAD PASSWORD");
        }
    }
}
