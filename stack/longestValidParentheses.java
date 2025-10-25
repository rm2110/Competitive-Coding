import java.util.*;

public class longestValidParentheses {

    public static int validParentheses(String s) {
        Stack<Integer> st = new Stack<>();

        st.push(-1); // Push -1 to handle edge cases
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                st.push(i);
            } 
            else { // character is ')'
                st.pop();

                if (st.isEmpty()) {
                    // No matching '('. Push current index as a new base
                    st.push(i);
                } 
                else {
                    // Valid pair found. Calculate length and update maxLen
                    maxLen = Math.max(maxLen, i - st.peek());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter input: ");
        String input = sc.nextLine();

        System.out.println(validParentheses(input));

        sc.close();
    }
}