package ch9;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Ch9_3 {
    public static void main(String[] args) {
        Path path = Paths.get(System.getProperty("user.dir"), "resources/words.txt");
        try {
            // This assume use UTF_8 CharSet, try others if fails.
            Stream<String> lines = Files.lines(path);
            lines.forEach(System.out::println);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
