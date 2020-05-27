package ch9;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Ch9_5 {
    public static void main(String[] args) {
        Charset[] charSets = new Charset[] {
             StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.ISO_8859_1,
             StandardCharsets.US_ASCII, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE
        };

        Map<Character, List<String>> map = new HashMap<>();

        for (Charset charset : charSets) {
            byte[] replacements = charset.newEncoder().replacement();
            for (byte b : replacements) {
                char c = (char)b;
                List<String> l = map.getOrDefault(c, new ArrayList<>());
                if (l.isEmpty()) {
                    map.put(c, l);
                }
                l.add(charset.name());
            }
        }

        for (Map.Entry<Character, List<String>> entry : map.entrySet()) {
            System.out.println("Char: " + entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
