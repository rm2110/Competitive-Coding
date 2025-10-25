import java.util.*;

public class validParentheses{
    
    public static boolean isValid(String s){
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                st.push(c);
            }
            else {
                if(st.empty()) return false;

                char top = st.pop();

                if((c == ')' && top != '(') || (c == ']' && top != '[') && (c == '}' && top != '{')) return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String inputString;

        System.out.print("Enter input string: ");
        inputString = sc.nextLine();

        System.out.println(isValid(inputString));
    }
}