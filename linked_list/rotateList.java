import java.util.*;
public class rotateList{
    static Node head = null;
    static Node tail = null;
    static Node head2 = null;
    static Node tail2 = null;
    static int size = 1;

    static void getData(){
        Node curr = head;
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
            size++;
        }
    }
    
    static Node swapList(int k){
        int i = 1;

        if(k > size){
            System.out.println("Not possible");
            return head;
        }

        Node curr = head;
        while(i < k){
            curr = curr.next;
            i++;
        }
        
        Node temp = curr.next;
        curr.next = null;
        tail2 = tail;
        tail = curr;
        head2 = temp;

        System.out.println("List has been swapped!");

        return head2;
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
        Scanner sc = new Scanner(System.in);
        int k;

        getData();
        
        System.out.print("Enter swap value k: ");
        k = sc.nextInt();

        Node headSwap = swapList(k);

        printList(headSwap);
        printList(head);
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