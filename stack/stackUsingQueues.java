import java.util.*;

class stackUsingQueues {
    Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.add(x);
        int size = q.size();
        for (int i = 1; i < size; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int poppedValue = q.remove();
        return poppedValue;
    }

    public int top() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int peekedValue = q.peek();
        return peekedValue;
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stackUsingQueues stack = new stackUsingQueues();

        System.out.print("Enter number of operations: ");
        int noOfOperations = sc.nextInt();
        sc.nextLine();

        String[] commands = new String[noOfOperations];
        System.out.println("Enter commands (e.g., push(10), pop(), top(), isEmpty()):");

        for (int i = 0; i < noOfOperations; i++) {
            commands[i] = sc.nextLine();
        }

        for (String input : commands) {
            String command;
            int value = 0;

            if (input.startsWith("push(")) {
                command = "push";
                String valueString = input.substring(input.indexOf('(') + 1, input.indexOf(')'));
                value = Integer.parseInt(valueString);
            } 
            else if (input.startsWith("pop()")) {
                command = "pop";
            } 
            else if (input.startsWith("top()")) {
                command = "top";
            } 
            else if (input.startsWith("isempty()")) {
                command = "isempty";
            } 
            else {
                command = "unknown";
            }

            switch (command) {
                case "push":
                    stack.push(value);
                    break;

                case "pop":
                    System.out.println(stack.pop());
                    break;

                case "top":
                    System.out.println(stack.top());
                    break;

                case "isempty":
                    System.out.println(stack.isEmpty());
                    break;
            }
        }
        sc.close();
    }
}
