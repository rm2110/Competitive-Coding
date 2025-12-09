import java.util.Scanner;

public class pin_generator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        sc.close();

        if (line.isEmpty()) {
            System.out.println("");
            return;
        }
        String[] tokens = line.split("\\s+");
        StringBuilder pin = new StringBuilder();

        for (String tok : tokens) {
            long num;
            try {
                num = Long.parseLong(tok);
            } catch (NumberFormatException e) {
                continue;
            }
            // compute digital root
            int dr = digitalRoot(num);
            // map as per the rule
            if (dr % 2 == 1) {
                // odd -> letter
                char letter = (char)('a' + (dr - 1));
                pin.append(letter);
            } else {
                // even -> digit
                pin.append(dr);
            }
        }

        System.out.println(pin.toString());
    }

    // compute digital root: sum digits repeatedly until single digit 
    public static int digitalRoot(long x) {
        while (x >= 10) {
            long sum = 0;
            while (x > 0) {
                sum += (x % 10);
                x /= 10;
            }
            x = sum;
        }
        return (int)x;
    }
}
