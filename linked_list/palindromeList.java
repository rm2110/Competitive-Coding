import java.util.*;
public class palindromeList{
    static Node head = null;
    static Node tail = null;
    static int size = 1;

    static void getData(){
        Scanner sc = new Scanner(System.in);
        int val = 0;

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

    static boolean checkPalindrome(){
        Node currHead = head;
        Node currTail = tail;
        int currHeadPos = 1;
        int currTailPos = size;
        boolean flag = true;

        while(true){
            if(currHeadPos == currTailPos || currHeadPos > currTailPos){
                break;
            }
            if(currHead.data != currTail.data){
                flag = false;
                return flag;
            }
            currHead = currHead.next;
            currHeadPos++;
            currTail = currTail.prev;
            currTailPos--;
        }
        return flag;
}

    public static void main(String[] args){
        getData();
        String ans = (checkPalindrome()) ? "Its Palindrome!" : "Not a palindrome!";
        System.out.println(ans);
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