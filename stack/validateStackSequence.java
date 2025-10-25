import java.util.*;

public class validateStackSequence {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int poppedIndex = 0;

        for (int pushedElement : pushed) {
            st.push(pushedElement);

            while (!st.isEmpty() && st.peek() == popped[poppedIndex]) {
                st.pop();
                poppedIndex++;
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the pushed array elements (space-separated): ");
        String pushedString = sc.nextLine();
        
        System.out.print("Enter the popped array elements (space-separated): ");
        String poppedString = sc.nextLine();

        int[] popped = Arrays.stream(poppedString.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] pushed = Arrays.stream(pushedString.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(validateStackSequences(pushed, popped));
        sc.close();
    }
}
