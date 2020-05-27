package ch9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ch9_4 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"), "resources/words.txt");

        // Use scanner
        Scanner in = new Scanner(path);
        int num = 0;
        while (in.hasNextLine()) {
            in.nextLine();
            num++;
        }
        System.out.println("Number of lines: " + num);

        // Use BufferedReader
        BufferedReader reader = Files.newBufferedReader(path);
        num = 0;
        while (reader.readLine() != null) {
            num++;
        }
        System.out.println("Number of lines: " + num);

        // Use BufferedReader::lines
        BufferedReader reader1  = Files.newBufferedReader(path);
        long count = reader1.lines().count();
        System.out.println("Number of lines: " + count);
    }
}
