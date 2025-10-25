import java.util.*;

public class basicCalculator {
    
    public static int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1; // current sign
        Stack<Integer> stack = new Stack<>(); // store previous result and sign

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } 
            else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } 
            else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } 
            else if (ch == '(') {
                // Push current result and sign
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } 
            else if (ch == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // multiply with sign before '('
                result += stack.pop(); // add previous result
            } 
        }

        result += sign * number; // add last number
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        System.out.println(calculate(s));

        sc.close();
    }
}
