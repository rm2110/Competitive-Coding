import java.util.*;

public class sortCharacterFrequency {
    public static String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        // Step 1: Count frequencies of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a list of characters (keys) and sort by frequency descending
        List<Character> chars = new ArrayList<>(freqMap.keySet());
        chars.sort((c1, c2) -> freqMap.get(c2) - freqMap.get(c1));

        // Step 3: Build result string
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            int count = freqMap.get(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter input string: ");
        String input = sc.nextLine();

        System.out.println("Output: " + frequencySort(input));

        return 0;
    }
}
