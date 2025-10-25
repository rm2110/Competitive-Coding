import java.util.*;

public class reversePolish {

    public static int evaluatePostfix(String s) {
        Stack<Integer> st = new Stack<>();

        for (int c : s.toCharArray()) {
            if (c == ' ') continue; // ignore whitespace

            if (Character.isDigit(c)) st.push(c - '0'); // Convert char digit to int and push
            
            else {
                int op2 = st.pop(); 
                int op1 = st.pop();

                switch (c) {
                    case '+':
                        st.push(op1 + op2);
                        break;

                    case '-':
                        st.push(op1 - op2);
                        break;

                    case '*':
                        st.push(op1 * op2);
                        break;

                    case '/':
                        st.push(op1 / op2);
                        break;
                }
            }
        }
        return st.pop(); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter postfix (Reverse Polish) expression: ");
        String ans = sc.nextLine();

        System.out.print(evaluatePostfix(ans));

        sc.close();
    }
}