import java.util.*;
public class reverseList {
    static Node head = null;
    static Node tail = null;
    static int size = 1;

    static void addData(){
        int val;
        Scanner sc = new Scanner(System.in);
        while(true) { 
            if (head == null){
                System.out.print("Enter value: ");
                val = sc.nextInt();
                Node newNode = new Node(val);
                head = tail = newNode;
            }
            else {
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
        System.out.println("Success");
        }
    }

    static void reverse() {
        Node currFirst = head;
        Node currLast = tail;
        int currFirstPos = 1;
        int currLastPos = size;
        int temp;

        while(true){
            if(currFirstPos == currLastPos || currFirstPos > currLastPos){
                break;
            }

            temp = currFirst.data;
            currFirst.data = currLast.data;
            currLast.data = temp;
            currFirst = currFirst.next;
            currFirstPos++;
            currLast = currLast.prev;
            currLastPos--;
        }
        System.out.println("Success");
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
        addData();
        reverse();
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