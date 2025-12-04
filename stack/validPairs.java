import java.util.*;

public class validPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        sc.close();

        String[] parts = line.split(",");

        for (String raw : parts) {
            String s = raw.trim();
            Result res = checkBalanceAndCount(s);
            if (res.isBalanced) {
                System.out.println("YES " + res.pairCount);
            } else {
                System.out.println("NO " + res.pairCount);
            }
        }
    }

    static class Result {
        boolean isBalanced;
        int pairCount;
        Result(boolean b, int p) { isBalanced = b; pairCount = p; }
    }

    public static Result checkBalanceAndCount(String s) {
        Stack<Character> st = new Stack<>();
        int pairs = 0;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (st.isEmpty()) {
                    return new Result(false, pairs);
                }
                char top = st.peek();
                if ((c == ')' && top == '(') ||
                    (c == ']' && top == '[') ||
                    (c == '}' && top == '{')) {
                    st.pop();
                    pairs++;
                } else {
                    return new Result(false, pairs);
                }
            }
        }

        if (!st.isEmpty()) {
            return new Result(false, pairs);
        }

        return new Result(true, pairs);
    }
}
