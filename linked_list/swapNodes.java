import java.util.*;
public class swapNodes{
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

    static void swap(){
        int temp, k;
        int i = 1;
        Node front = head;
        Node back = tail;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of k: ");
        k = sc.nextInt();

        while(i < k){   
            front = front.next;
            back = back.prev;
            i++;
        }

        temp = front.data;
        front.data = back.data;
        back.data = temp; 
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
        swap();
        printList();
    }
}

class Node{
    int data;
    Node prev;
    Node next;

    Node(int data){
        this.data = data;
        prev = null;
        next = null;
    }
}