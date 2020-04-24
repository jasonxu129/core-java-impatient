package ch7;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ch7_07 {
    public static Map<String, Integer> readFile(String path) {
        Map<String, Integer> map = new TreeMap<>();
        try (Scanner sc = new Scanner(Paths.get(path))) {
            while (sc.hasNext()) {
                String word = sc.next();
                // Check whether the word is in the map, and if so, add 1 to the existing value.
                map.merge(word, 1, Integer::sum);
                // or use
                // map.put(word, 1 + map.getOrDefault(word, 0));
            }
        } catch (IOException ex) {
            System.out.println("Failed to create scanner " + ex);
        }
        return map;
    }

    public static void main(String[] args) {
        Map<String, Integer> m = readFile("/tmp/words.txt");
        System.out.println(m);
    }
}
