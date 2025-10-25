import java.util.Scanner;
import java.util.Stack;

public class removeKD {
    public static String removeKDigits(String s, int k) {
        if (k == s.length()) {
            return "0";
        }

        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            while (k > 0 && !st.isEmpty() && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        for (char c : st) {
            result.append(c);
        }

        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input string: ");
        String input = sc.nextLine();

        System.out.print("Enter k value: ");
        int k = sc.nextInt();

        String ans = removeKDigits(input, k);
        System.out.println(ans);

        sc.close();
    }
}
