package ch3;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Ch3_12 {
    public static String[] findMatchFiles(File file, FilenameFilter filter) {
        return file.list(filter);
    }

    public static void main(String[] args) {
        File dir = new File("/Users/qxu/tmp/opencsv");

        String[] matches = findMatchFiles(dir, new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        System.out.println(Arrays.toString(matches));

        matches = findMatchFiles(dir, (directory, name) -> name.endsWith(".java"));
        System.out.println(Arrays.toString(matches));
    }
}
