import java.util.*;
public class mergeSortedList{
    static Node head1 = null;
    static Node tail1 = null;
    static Node head2 = null;
    static Node tail2 = null;
    static Node headFinal = null;
    static Node tailFinal = null;

    static Node getData(Node head, Node tail){
        Scanner sc = new Scanner(System.in);
        int val;

        if(head == null){
            System.out.print("Enter value: ");
            val = sc.nextInt();
            Node newNode = new Node(val);
            head = tail = newNode;
        }

        while(true){
            System.out.print("Enter value: ");
            val = sc.nextInt();

            if(val == -1){
                break;
            }

            Node newNode = new Node(val);
            tail.next = newNode;
            tail = newNode;
        }

        return head;
    }

    static Node mergeList(Node head1, Node head2){
        ArrayList<Integer> mergedLL = new ArrayList<>();

        Node curr = head1;
        while(curr != null){
            mergedLL.add(curr.data);
            curr = curr.next;
        }

        curr = head2;
        while(curr != null){
            mergedLL.add(curr.data);
            curr = curr.next;
        }

        Collections.sort(mergedLL);

        curr = headFinal;
        for(int i:mergedLL){
            Node newNode = new Node(i);

            if(headFinal == null){
                headFinal = tailFinal = newNode;
            }
            else {
                tailFinal.next = newNode;
                tailFinal = newNode;
            }
        }
        return headFinal;
    }

    static void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        System.out.println("For Linked List 1");
        Node h1 = getData(head1, tail1);
        System.out.println("For Linked List 2");
        Node h2 = getData(head2, tail2);

        Node hFinal = mergeList(h1, h2);

        printList(hFinal);
    }
}

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        next = null;
    }
}