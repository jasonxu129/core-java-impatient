package ch3;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Scanner;

public class Ch3_11 {
    public static class DirectoryFiler implements FileFilter {
        public boolean accept(File pathName) {
            return pathName.isDirectory();
        }
    }

    public static File[] listSubDirectories(File file, FileFilter ff) {
        return file.listFiles(ff);
    }

    public static void main(String[] args) {
        System.out.println("Input the path: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(path);

        File[] result1 = listSubDirectories(file, new DirectoryFiler());
        System.out.println(Arrays.toString(result1));

        File[] result2 = listSubDirectories(file, p -> p.isDirectory());
        System.out.println(Arrays.toString(result2));

        File[] result3 = listSubDirectories(file, File::isDirectory);
        System.out.println(Arrays.toString(result3));

        File[] result4 = listSubDirectories(file, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        System.out.println(Arrays.toString(result4));
    }
}
