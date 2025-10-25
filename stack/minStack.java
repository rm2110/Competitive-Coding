import java.util.*;

class MyStacks {
    Stack<Integer> st;
    Stack<Integer> minSt;

    MyStacks() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int element) {
        if (minSt.isEmpty() || element <= minSt.peek()) {
            minSt.push(element);
        }
        st.push(element);
    }

    public void pop() {
        if (st.isEmpty()) {
            System.out.println("EMPTY!");
            return;
        }

        if (st.peek().equals(minSt.peek())) {
            minSt.pop();
        }
        st.pop();
    }

    public int getMin() {
        if (minSt.isEmpty()) {
            System.out.println("Min stack is empty.");
            return -1; 
        }
        return minSt.peek();
    }
}

public class minStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStacks obj = new MyStacks();

        System.out.println("Enter total operations: ");
        int no_of_operation = sc.nextInt();
        sc.nextLine(); 

        String[] commands = new String[no_of_operation];

        System.out.println("Enter operations (e.g., \"push 10\", \"pop\", \"getMin\"):");
        for (int i = 0; i < no_of_operation; i++) {
            commands[i] = sc.nextLine();
        }

        for(int i = 0; i < no_of_operation; i++) {
            String[] parts = commands[i].split(" ");
            String command = parts[0];

            switch (command) {
                case "push": {
                    int value = Integer.parseInt(parts[1]);
                    obj.push(value);
                    break;
                }

                case "pop":
                    obj.pop();
                    break;

                case "getMin": {
                    int min = obj.getMin();
                    if (min != -1) {
                         System.out.println("Min value: " + min);
                    }
                    break;
                }
            }
        }
        sc.close();
    }
}
