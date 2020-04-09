package ch5;

import javafx.util.Pair;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Ch5_4 {
    public static enum ErrCode {
        NONE, FILE_ERR, NUM_PARSE_ERR
    }

    public static Pair<ArrayList<Double>, ErrCode> readValues(String filename) {

        ArrayList<Double> res = new ArrayList<>();
        Path path = Paths.get(filename);

        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    res.add(scanner.nextDouble());
                } else {
                    String val = scanner.next();
                    return new Pair<>(new ArrayList<>(), ErrCode.NUM_PARSE_ERR);
                }
            }
        } catch (IOException ex) {
            return new Pair<>(new ArrayList<>(), ErrCode.FILE_ERR);
        }

        return new Pair<>(res, ErrCode.NONE);
    }

    public static Pair<Double, ErrCode> sumOfValues(String filename) {
        Pair<ArrayList<Double>, ErrCode> r = readValues(filename);
        if (r.getValue() == ErrCode.NONE) {
            double sum = 0;
            for (double d : r.getKey()) {
                sum += d;
            }
            return new Pair<>(sum, ErrCode.NONE);
        }
        return new Pair<>(0.0, r.getValue());
    }

    public static void main(String[] args) {
        Pair<Double, ErrCode> res = sumOfValues("/tmp/Numbers.txt");
        if (res.getValue() == ErrCode.NONE) {
            Logger.getGlobal().info("Sum is " + res.getKey());
        } else if (res.getValue() == ErrCode.FILE_ERR) {
            Logger.getGlobal().warning("Failed to read file");
        } else if (res.getValue() == ErrCode.NUM_PARSE_ERR) {
            Logger.getGlobal().warning("Failed to parse double value");
        }
    }
}
