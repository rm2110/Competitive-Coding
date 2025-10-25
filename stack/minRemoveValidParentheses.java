import java.util.*;

public class minRemoveValidParentheses{
    public static String minRemoveParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for(char c : s.toCharArray()){
            if(c == '(') {
                balance++;
                result.append(c);
            }
            else if(c == ')') {
                if(balance == 0) continue; // skip this invalid ) & read next character
                balance--;
                result.append(c);
            }
            else {
                result.append(c);
            }
        }

        StringBuilder finalResult = new StringBuilder();
        for(int i = result.length() - 1; i >= 0; i--) {
            char c = result.charAt(i);

            if(c == '(' && balance > 0) {
                balance--;
                continue; // skip this invalid ( & read next character
            }
            finalResult.append(c);
        }

        return finalResult.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString;

        System.out.print("Enter input string: ");
        inputString = sc.nextLine();

        System.out.println(minRemoveParentheses(inputString));

        sc.close();
    }
}