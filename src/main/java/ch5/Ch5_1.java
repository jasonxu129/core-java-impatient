package ch5;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Ch5_1 {
    public static ArrayList<Double> readValues(String filename)
        throws IOException, NumberFormatException {

        ArrayList<Double> res = new ArrayList<>();
        Path path = Paths.get(filename);
        Scanner scanner = new Scanner(path);

        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                res.add(scanner.nextDouble());
            } else {
                String val = scanner.next();
                throw new NumberFormatException("not a float " + val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        try {
            ArrayList<Double> res = readValues("/tmp/Numbers.txt");
            System.out.println(res);
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
        }
    }
}
