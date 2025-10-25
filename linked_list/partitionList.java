import java.util.*;

public class partitionList {
    static Node head = null;
    static Node tail = null;

    public void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data (-1 to stop)");

        while (true) {
            System.out.print("Enter value: ");
            int val = sc.nextInt();

            if (val == -1) {
                break;
            }

            Node newNode = new Node(val);

            if (head == null) {
                head = tail = newNode;
            } 
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }

    public Node partition(int partition_value) {
        Node lessHead = null;
        Node lessTail = null;
        Node greaterHead = null;
        Node greaterTail = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = null; 

            if (curr.data < partition_value) {
                if (lessHead == null) {
                    lessHead = lessTail = curr;
                } 
                else {
                    lessTail.next = curr;
                    lessTail = curr;
                }
            } else { 
                if (greaterHead == null) {
                    greaterHead = greaterTail = curr;
                } else {
                    greaterTail.next = curr;
                    greaterTail = curr;
                }
            }
            curr = nextNode;
        }

        if (lessHead == null) {
            return greaterHead;
        }

        lessTail.next = greaterHead;
        return lessHead;
    }

    public void printList(Node node) {
        Node curr = node;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        int x;
        partitionList obj = new partitionList();

        Scanner sc = new Scanner(System.in);

        obj.getData();

        System.out.print("Enter partition data value: ");
        x = sc.nextInt();
        Node ans = obj.partition(x);

        obj.printList(ans);
        sc.close();
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