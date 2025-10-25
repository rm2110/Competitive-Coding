import java.util.*;
public class removeDuplicate{
    static Node head = null;
    static Node tail = null;

    static void getData(){
        int val;
        Scanner sc = new Scanner(System.in);

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
    }

    static void duplicateNodeRemoval(){
        Node curr = head.next;
        Node prev = head;

        while(curr != null && curr.next != null){
            if(curr.data == curr.next.data){
                while(curr != null && curr.data == curr.next.data){
                    curr = curr.next;
                }
                prev.next = curr.next;
            }
            else {
                prev = prev.next;
            }
            curr = curr.next;
        }
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
        duplicateNodeRemoval();
        printList();
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