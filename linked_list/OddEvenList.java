import java.util.*;
public class OddEvenList{
    static Node head = null;
    static Node tail = null;
    static Node oddHead = null;
    static Node oddTail = null;
    static Node evenHead = null;
    static Node evenTail = null;

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
            tail = newNode;
        }
    }

    static void oddEven(){
        int i = 1;
        Node curr = head;

        while(curr != null){
            if(i % 2 == 0){
                if(evenHead == null){
                    Node newNode = new Node(curr.data);
                    evenHead = evenTail = newNode;    
                    i++;
                    curr = curr.next;
                }
                else{
                    Node newNode = new Node(curr.data);
                    evenTail.next = newNode;
                    evenTail = newNode;
                    i++;
                    curr = curr.next;
                }
            }
            else {
                if(oddHead == null){
                    Node newNode = new Node(curr.data);
                    oddHead = oddTail = newNode;
                    i++;
                    curr = curr.next;
                }
                else{
                    Node newNode = new Node(curr.data);
                    oddTail.next = newNode;
                    oddTail = newNode;
                    i++;
                    curr = curr.next;
                }
            }
        }

        curr = oddHead;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

        curr = evenHead;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args){
        getData();
        oddEven();
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