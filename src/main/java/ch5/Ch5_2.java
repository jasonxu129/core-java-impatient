package ch5;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Ch5_2 {
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

    public static double sumOfValues(String filename)
        throws IOException, NumberFormatException {
        ArrayList<Double> vals = readValues(filename);
        double sum = 0;
        for (double d : vals) {
            sum += d;
        }
        return sum;
    }

    public static void main(String[] args) {
        try {
            double d = sumOfValues("/tmp/Numbers.txt");
            System.out.println("sum is " + d);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
