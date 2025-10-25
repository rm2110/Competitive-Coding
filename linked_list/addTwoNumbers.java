import java.util.*;

public class addTwoNumbers {

    public static Node getData() {
        Node head = null;
        Node tail = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value (-1 to stop)");

        int val;
        while(true) {
            val = sc.nextInt();
            
            if(val == -1) break;
            
            Node newnode = new Node(val);
            if(head == null) {
                head = tail = newnode;
            }
            else {
                tail.next = newnode;
                tail = newnode;
            }
        }
        
        return head;
    }

    public static void printList(Node node) {
        Node curr = node;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

    public static Node add(Node head1, Node head2) {
        int sum, carry = 0;
        Node dummyHead = new Node(0);
        Node current = dummyHead;

        while(head1 != null  || head2 != null) {
            int x = (head1 != null) ? head1.val : 0;
            int y = (head2 != null) ? head2.val : 0;
            
            sum = x + y + carry;
            carry = sum / 10;

            current.next = new Node(sum % 10);
            current = current.next;

            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        if(carry > 0) current.next = new Node(carry);

        return dummyHead.next;
    }

    public static void main(String[] args) {
        System.out.println("Enter list 1 data: ");
        Node list_1 = getData();

        System.out.println("Enter list 2 data: ");
        Node list_2 = getData();

        Node list_ans = add(list_1, list_2);

        printList(list_ans);
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}
