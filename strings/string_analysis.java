import java.util.Scanner;
import java.text.DecimalFormat;

public class string_analysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        int total = input.length();
        if (total == 0) {
            System.out.println("0.000%");
            System.out.println("0.000%");
            System.out.println("0.000%");
            System.out.println("0.000%");
            return;
        }

        int upper = 0, lower = 0, digits = 0, others = 0;

        for (int i = 0; i < total; i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                upper++;
            } else if (Character.isLowerCase(c)) {
                lower++;
            } else if (Character.isDigit(c)) {
                digits++;
            } else {
                others++;
            }
        }

        double pUpper = 100.0 * upper / total;
        double pLower = 100.0 * lower / total;
        double pDigits = 100.0 * digits / total;
        double pOthers = 100.0 * others / total;

        // format to 3 decimal places
        DecimalFormat df = new DecimalFormat("0.000");

        System.out.println(df.format(pUpper) + "%");
        System.out.println(df.format(pLower) + "%");
        System.out.println(df.format(pDigits) + "%");
        System.out.println(df.format(pOthers) + "%");
    }
}
