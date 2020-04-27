package ch7;

import java.util.HashMap;
import java.util.Map;

public class Ch7_09 {
    public static void main(String[] args) {
        Map<String, Integer> counts = new HashMap<>();

        String s = "word";

        // Use contains
        if (counts.containsKey(s)) {
            counts.put(s, 1 + counts.get(s));
        } else {
            counts.put(s, 1);
        }

        // Use get and null check
        if (counts.get(s) != null) {
            counts.put(s, 1 + counts.get(s));
        } else {
            counts.put(s, 1);
        }

        // Use getOrDefault
        int x = counts.getOrDefault(s, 0);
        counts.put(s, x + 1);

        // Use putIfAbsent
        Integer curr = counts.putIfAbsent(s, 1);
        if (curr != null) {
            counts.put(s, curr + 1);
        }

        System.out.println(counts);
    }
}
