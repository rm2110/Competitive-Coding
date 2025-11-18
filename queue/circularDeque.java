import java.util.*;

public class circularDeque {
    int[] data;     
    int capacity;   
    int front;      
    int size;      

    public circularDeque(int k) {
        capacity = k;
        data = new int[k];
        front = 0;
        size = 0;
    }

    public void insertFront(int value) {
        if (isFull()) {
           throw new IllegalStateException("Queue is full");
        }

        front = (front - 1 + capacity) % capacity;
        data[front] = value;
        size++;
        System.out.println("Done");
    }

    public void insertLast(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        int rearIndex = (front + size) % capacity;
        data[rearIndex] = value;
        size++;
        System.out.println("Done");
    }

    public void deleteFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        front = (front + 1) % capacity;
        size--;
        System.out.println("Done");
    }

    public void deleteLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        size--;
        System.out.println("Done");
    }

    public int getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return data[front];
    }

    public int getRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int rearIndex = (front + size - 1) % capacity;
        return data[rearIndex];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        circularDeque deque = new circularDeque(3);

        System.out.println(deque.insertLast(1));   
        System.out.println(deque.insertLast(2));   
        System.out.println(deque.insertFront(3));  
        System.out.println(deque.insertFront(4));  
        System.out.println(deque.getRear());       
        System.out.println(deque.isFull());        
        System.out.println(deque.deleteLast());    
        System.out.println(deque.insertFront(4));  
        System.out.println(deque.getFront());      
    }
}
