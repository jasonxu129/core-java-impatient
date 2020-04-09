package ch5;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class Ch5_3 {
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
                throw new NumberFormatException("not double: " + val);
            }
        }
        return res;
    }

    public static double sumOfValues(String filename) throws IOException, NumberFormatException {
        ArrayList<Double> vals = readValues(filename);
        double sum = 0;
        for (double d : vals) {
            sum += d;
        }
        return sum;
    }

    public static void main(String[] args) {
        try {
            double sum = sumOfValues("/tmp/Numbers.txt");
        } catch (IOException ex) {
            Logger.getGlobal().info("Failed to open file " + ex.getMessage());
        } catch (NumberFormatException ex) {
            Logger.getGlobal().info("Failed to read double: " + ex.getMessage());
        }
    }
}
