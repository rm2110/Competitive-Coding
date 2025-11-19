import java.util.*;

public class FrontMiddleBackQueue {
    private Deque<Integer> frontDeque;
    private Deque<Integer> backDeque;

    public FrontMiddleBackQueue() {
        frontDeque = new ArrayDeque<>();
        backDeque = new ArrayDeque<>();
    }

    private void rebalance() {
        // Ensure backDeque.size() == frontDeque.size() or frontDeque.size()+1 == backDeque.size()
        if (frontDeque.size() > backDeque.size()) {
            backDeque.addFirst(frontDeque.removeLast());
        } else if (backDeque.size() > frontDeque.size() + 1) {
            frontDeque.addLast(backDeque.removeFirst());
        }
    }

    public void pushFront(int val) {
        frontDeque.addFirst(val);
        rebalance();
    }

    public void pushMiddle(int val) {
        if (frontDeque.size() == backDeque.size()) {
            backDeque.addFirst(val);
        } else {
            frontDeque.addLast(val);
        }
        rebalance();
    }

    public void pushBack(int val) {
        backDeque.addLast(val);
        rebalance();
    }

    public int popFront() {
        if (frontDeque.isEmpty() && backDeque.isEmpty()) {
            return -1;
        }
        int val;
        if (!frontDeque.isEmpty()) {
            val = frontDeque.removeFirst();
        } else {
            val = backDeque.removeFirst();
        }
        rebalance();
        return val;
    }

    public int popMiddle() {
        if (frontDeque.isEmpty() && backDeque.isEmpty()) {
            return -1;
        }
        int val;
        if (frontDeque.size() == backDeque.size()) {
            // middle is end of frontDeque
            val = frontDeque.removeLast();
        } else {
            // backDeque has one more => middle is front of backDeque
            val = backDeque.removeFirst();
        }
        rebalance();
        return val;
    }

    public int popBack() {
        if (frontDeque.isEmpty() && backDeque.isEmpty()) {
            return -1;
        }
        int val = backDeque.removeLast();
        rebalance();
        return val;
    }

    // For demonstration
    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1,2]
        q.pushMiddle(3);  // [1,3,2]
        q.pushMiddle(4);  // [1,4,3,2]
        System.out.println(q.popFront());   // returns 1 -> [4,3,2]
        System.out.println(q.popMiddle());  // returns 4 -> [3,2]
        System.out.println(q.popMiddle());  // returns 3 -> [2]
        System.out.println(q.popBack());    // returns 2 -> []
        System.out.println(q.popFront());   // returns -1 -> empty
    }
}
