import java.util.*;
public class removeNfromEnd{
    static Node head = null;
    static Node tail = null;
    static int size = 1;

    static void getData(){
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
            newNode.prev = tail;
            tail = newNode;
            size++;
        }

    }

    static void removeFromNthEnd(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Nth Node (1 to N): ");
        int n = sc.nextInt();

        if(n > size){
            System.out.println("Out of bounds");
            return;
        }

        if(n == size){
            Node curr = tail;
            curr = curr.prev;
            tail = curr;
            return;
        }

        if(n == 1){
            Node curr = head;
            curr = curr.next;
            head = curr;
            return;
        }

        int i = 0;
        Node curr = tail;
        while(i < n){
            curr = curr.prev;
            i++;
        }

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    static void printList(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        getData();
        removeFromNthEnd();
        printList();
    }
}

class Node{
    int data;
    Node next;
    Node prev;

    Node(int data){
        this.data = data;
        next = null;
        prev = null;
    }
}