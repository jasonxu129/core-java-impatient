package ch8;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Ch8_07 {
    public static String[] first100Words(String pathname) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"), pathname);
        System.out.println(path);
        try (Scanner s = new Scanner(path)) {
            return s.useDelimiter("\\W+")
                    .tokens()
                    .filter(Ch8_06::isOnlyLetters)
                    .limit(100)
                    .toArray(String[]::new);
        }
    }

    public static void main(String[] args) {
        try {
            String[] tokens = first100Words("resources/words.txt");
            System.out.println(Arrays.toString(tokens));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
