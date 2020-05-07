package ch5;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class Ch5_4 {
    public enum ErrCode {
        NONE, FILE_ERR, NUM_PARSE_ERR
    }

    public static AbstractMap.SimpleEntry<ArrayList<Double>, ErrCode> readValues(String filename) {

        ArrayList<Double> res = new ArrayList<>();
        Path path = Paths.get(filename);

        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    res.add(scanner.nextDouble());
                } else {
                    String val = scanner.next();
                    return new AbstractMap.SimpleEntry<>(new ArrayList<>(), ErrCode.NUM_PARSE_ERR);
                }
            }
        } catch (IOException ex) {
            return new AbstractMap.SimpleEntry<>(new ArrayList<>(), ErrCode.FILE_ERR);
        }

        return new AbstractMap.SimpleEntry<>(res, ErrCode.NONE);
    }

    public static AbstractMap.SimpleEntry<Double, ErrCode> sumOfValues(String filename) {
        AbstractMap.SimpleEntry<ArrayList<Double>, ErrCode> r = readValues(filename);
        if (r.getValue() == ErrCode.NONE) {
            double sum = 0;
            for (double d : r.getKey()) {
                sum += d;
            }
            return new AbstractMap.SimpleEntry<>(sum, ErrCode.NONE);
        }
        return new AbstractMap.SimpleEntry<>(0.0, r.getValue());
    }

    public static void main(String[] args) {
        AbstractMap.SimpleEntry<Double, ErrCode> res = sumOfValues("/tmp/Numbers.txt");
        if (res.getValue() == ErrCode.NONE) {
            Logger.getGlobal().info("Sum is " + res.getKey());
        } else if (res.getValue() == ErrCode.FILE_ERR) {
            Logger.getGlobal().warning("Failed to read file");
        } else if (res.getValue() == ErrCode.NUM_PARSE_ERR) {
            Logger.getGlobal().warning("Failed to parse double value");
        }
    }
}
