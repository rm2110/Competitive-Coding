import java.util.*;

public class queueUsingStack {
    Stack<Integer> stackIn = new Stack<>();
    Stack<Integer> stackOut = new Stack<>();

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if(empty()) {
            return -1;
        }
        if(stackOut.isEmpty()) {
            while(!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        int poppedValue = stackOut.pop();
        return poppedValue;
    }

    public int peek() {
        if(empty()) {
            return -1;
        }
        if(stackOut.isEmpty()) {
            while(!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queueUsingStack queue = new queueUsingStack();

        System.out.print("Enter number of operations: ");
        int noOfOperations = sc.nextInt();
        sc.nextLine(); 

        String[] commands = new String[noOfOperations];
        System.out.println("Enter commands (e.g., push(10), pop(), peek()):");

        for(int i = 0; i < noOfOperations; i++) {
            commands[i] = sc.nextLine();
        }

        for(String input : commands) {
            String command;
            int value = 0;

            if(input.startsWith("push(")) {
                command = "push";
                String valueString = input.substring(input.indexOf('(') + 1, input.indexOf(')'));
                value = Integer.parseInt(valueString);
            } 
            else if(input.startsWith("pop()")) {
                command = "pop";
            } 
            else if(input.startsWith("peek()")) {
                command = "peek";
            } 
            else {
                command = "empty";
            } 

            switch(command) {
                case "push":
                    queue.push(value);
                    break;

                case "pop":
                    System.out.println(queue.pop());
                    break;

                case "peek":
                    System.out.println(queue.peek());
                    break;

                case "empty":
                    System.out.println(queue.empty());
                    break;
            }
        }
        sc.close();
    }
}
