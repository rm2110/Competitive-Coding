import java.util.*;

public class CircularQueue {
    int[] arr;      
    int capacity;   
    int front;      
    int rear;      
    int size;      

    public CircularQueue(int cap) {
        capacity = cap;
        arr = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(int item) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }

        arr[rear] = item;
        rear = (rear + 1) % capacity;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        int item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void display() {
        System.out.print("Queue contents: ");

        for (int i = 0; i < size; i++) {
            int idx = (front + i) % capacity;
            System.out.print(arr[idx] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        System.out.println("Enqueue: 1, 2, 3");
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.display();           

        System.out.println("Dequeue: " + q.dequeue());
        q.display();         

        System.out.println("Enqueue: 4, 5, 6");
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.display();           

        System.out.println("Is full? " + q.isFull()); 

        System.out.println("Dequeue two items: " + q.dequeue() + ", " + q.dequeue());
        q.display();           

        System.out.println("Enqueue: 7");
        q.enqueue(7);
        q.display();          

        System.out.println("Peek front: " + q.peek()); 
    }
}
