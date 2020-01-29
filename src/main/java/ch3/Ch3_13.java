package ch3;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Ch3_13 {
    public static void main(String[] args) {
        File[] files = {
                new File("/Users/qxu/tmp/opencsv/ReadCSV.java"),
                new File("/Users/qxu/tmp/opencsv"),
                new File("/Users/qxu/tmp"),
                new File("/Users/qxu/go"),
        };

        Arrays.sort(files, (a, b) -> {
            if (a.isDirectory() ^ b.isDirectory() == true) {
                return a.getPath().compareTo(b.getPath());
            }
            return a.isDirectory() ? -1 : 1;
        });

        System.out.println(Arrays.toString(files));
    }
}
