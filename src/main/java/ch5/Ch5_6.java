package ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ch5_6 {
    public static void readOne(String file) {
        BufferedReader in = null;
        try {
            in = Files.newBufferedReader(Paths.get(file));
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                System.err.println("Failed to close BufferedReader: " + ex.getMessage());
            }
        }
    }

    //
    public static void readTwo(String file) {
        BufferedReader in = null;
        try {
            try {
                in = Files.newBufferedReader(Paths.get(file));
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }

    public static void readThree(String file) {
        try (BufferedReader in = Files.newBufferedReader(Paths.get(file))) {
            String s = in.readLine();
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }

}
