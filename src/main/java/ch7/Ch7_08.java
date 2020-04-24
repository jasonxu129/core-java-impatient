package ch7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Ch7_08 {
    public static Map<String, Set<Integer>> processFile(String file) {
        Map<String, Set<Integer>> map = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            int line = 0;
            while ((s = br.readLine()) != null) {
                String[] words = s.trim().split("\\s+");
                for (String word : words) {
                    Set<Integer> nums = map.getOrDefault(word, new TreeSet<>());
                    nums.add(line);
                    map.put(word, nums);
                }
                line++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return map;
    }

    public static void main(String[] args) {
        Map<String, Set<Integer>> map = processFile("/tmp/words.txt");
        System.out.println(map);
    }

}
