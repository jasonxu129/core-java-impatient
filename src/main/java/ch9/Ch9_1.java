package ch9;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class Ch9_1 {
    private static final int BUFFER_SIZE = 100;

    public static void copyStream(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[BUFFER_SIZE];
        while (true) {
            int count = in.read(buffer);
            if (count == -1) {
                break;
            }
            out.write(buffer, 0, count);
        }
    }

    public static void copyStreamWithFile(
            InputStream in, OutputStream out) throws IOException {
        Path path = Files.createTempFile("tmp", "txt");
        Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(path, out);
    }

    public static void main(String[] args) throws IOException {
        byte[] bytes = {-128, -22, 0, 2, 127};
        InputStream in = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // Test method using loop
        copyStream(in, out);
        byte[] result = out.toByteArray();
        System.out.println(Arrays.toString(result));

        InputStream in1 = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        // Test method using tmp file
        copyStreamWithFile(in1, out1);
        result = out1.toByteArray();
        System.out.println(Arrays.toString(result));
    }
}
