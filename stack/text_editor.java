import java.util.*;

public class text_editor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder text = new StringBuilder();

        // Undo stack
        Deque<String> history = new ArrayDeque<>();

        while (sc.hasNext()) {
            String cmd = sc.next();
            if (cmd.equals("1")) {
                String value = sc.next();
                history.push(text.toString());
                text.append(value);
            } else if (cmd.equals("2")) {
                // Command "2 k" delete last k characters
                int k = sc.nextInt();
                history.push(text.toString());
                int len = text.length();
                // delete last k (if k > length, delete all)
                if (k <= len) {
                    text.delete(len - k, len);
                } else {
                    text.setLength(0);
                }
            } else if (cmd.equals("3")) {
                // Command "3 k" get/print k-th character (1-based)
                int k = sc.nextInt();
                if (k >= 1 && k <= text.length()) {
                    System.out.println(text.charAt(k - 1));
                } else {
                    // if invalid index, you could print error or ignore per spec
                    System.out.println("");
                }
            } else if (cmd.equals("4")) {
                // Command "4" undo last modification (insert or delete)
                if (!history.isEmpty()) {
                    String prev = history.pop();
                    text = new StringBuilder(prev);
                } 
            } else {
                // Unknown command — skip or break
            }
        }

        sc.close();
    }
}
