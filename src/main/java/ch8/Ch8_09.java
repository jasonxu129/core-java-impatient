package ch8;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Ch8_09 {
    private static final char[] VOWELS = {'a', 'e', 'i', 'o'};

    public static String[] getWordsWithFiveVowels(String pathname) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"), pathname);
        System.out.println(path);
        try (Scanner scanner = new Scanner(path)) {
            return scanner.useDelimiter("\\W+")
                    .tokens()
                    .filter(Ch8_09::hasAllVowels)
                    .distinct()
                    .toArray(String[]::new);
        }
    }

    public static boolean hasAllVowels(String word) {
        word = word.toLowerCase();
        for (char c : VOWELS) {
            if (word.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        try {
            String[] words = getWordsWithFiveVowels("resources/words.txt");
            System.out.println(Arrays.toString(words));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
