import java.util.*;

public class RevealCardsIncreasing {
    public static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;

        Arrays.sort(deck);  // sort ascending

        Deque<Integer> deque = new ArrayDeque<>();

        // build backwards from largest to smallest
        for (int i = n - 1; i >= 0; i--) {
            if (!deque.isEmpty()) {
                // move the last card to front (undo the "move top->bottom")
                deque.offerFirst(deque.pollLast());
            }
            // put the current largest card to front (undo the "reveal top")
            deque.offerFirst(deck[i]);
        }

        // convert deque -> array
        int[] result = new int[n];
        int idx = 0;
        for (int val : deque) {
            result[idx++] = val;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array (Space Seperated): ");
        String arrStr = sc.nextLine();

        int[] arr = Arrays.stream(arrStr.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println("Answer: " + deckRevealedIncreasing(arr));

        return 0;
    }
}
