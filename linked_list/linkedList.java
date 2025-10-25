import java.util.*;

public class linkedList {
    static Node head = null;
    static Node tail = null;

    static void addAtBeginning(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = tail = newNode;
        } 
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    static void addAtEnd(int val) {
        Node newNode = new Node(val);

        if (tail == null) {
            head = tail = newNode;
        } 
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    static void addAtPosition(int val, int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            addAtBeginning(val);
            return;
        }

        Node newNode = new Node(val);
        Node current = head;
        
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    static void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    static void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }

        current.next = null;
        tail = current;
    }

    static void deleteFromPosition(int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            deleteFromBeginning();
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Position out of bounds");
            return;
        }

        current.next = current.next.next;
        if (current.next == null) {
            tail = current;
        }
    }

    static void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("0. Exit");
        System.out.println("1. Add at Beginning");
        System.out.println("2. Add at End");
        System.out.println("3. Add at Position");
        System.out.println("4. Delete from Beginning");
        System.out.println("5. Delete from End");
        System.out.println("6. Delete from Position");
        System.out.println("7. Print List");
        
        while (true) {
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting");
                    sc.close();
                    System.exit(0);
                    break;

                case 1:
                    System.out.print("Enter value: ");
                    int val1 = sc.nextInt();
                    addAtBeginning(val1);
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    int val2 = sc.nextInt();
                    addAtEnd(val2);
                    break;

                case 3:
                    System.out.print("Enter value: ");
                    int val3 = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos3 = sc.nextInt();
                    addAtPosition(val3, pos3);
                    break;

                case 4:
                    deleteFromBeginning();
                    break;

                case 5:
                    deleteFromEnd();
                    break;

                case 6:
                    System.out.print("Enter position: ");
                    int pos6 = sc.nextInt();
                    deleteFromPosition(pos6);
                    break;

                case 7:
                    printList();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
