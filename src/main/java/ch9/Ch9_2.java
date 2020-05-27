package ch9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Ch9_2 {
    public static Map<String, Set<Integer>> wordMap(Path path) throws IOException {
        Map<String, Set<Integer>> map = new HashMap<>();
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        int lineNum = 0;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.trim().split("\\PL+");
            for (String token : tokens) {
                Set<Integer> set = map.getOrDefault(token, new HashSet<>());
                set.add(lineNum);
                map.put(token, set);
            }
            lineNum++;
        }
        return map;
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"), "resources/words.txt");
        Path fileName = path.getFileName();
        Path out = Paths.get(path.getParent().toString(), path.getFileName() + ".toc");

        Map<String, Set<Integer>> map = wordMap(path);
        List<Map.Entry<String, Set<Integer>>> res = new ArrayList<>(map.entrySet());
        res.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(out, StandardCharsets.UTF_8))) {
            for (Map.Entry<String, Set<Integer>> entry : res) {
                String word = entry.getKey();
                Set<Integer> set = entry.getValue();

                writer.printf("%s: %s\n", word, set.toString());
            }
        }
    }
}
