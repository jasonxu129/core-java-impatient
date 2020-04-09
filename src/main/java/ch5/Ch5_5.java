package ch5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ch5_5 {
    public static void copyFile(String srcFile, String destFile) {

        Scanner in = null;
        PrintWriter out = null;

        try {
            in = new Scanner(Paths.get(srcFile));
            out = new PrintWriter(destFile);

            while (in.hasNext()) {
                out.println(in.nextLine().toLowerCase());
            }
        } catch (FileNotFoundException ex) {
            System.err.printf("Failed to open dest file %s", destFile);
        } catch (IOException ex) {
            System.err.printf("Failed to open or write to src file %s", srcFile);
        } finally {
            if (in != null) {
                // Invoke ioException() to check exception in close().
                in.close();
            }
            if (out != null) {
                // Methods in PrinterWrite never throw I/O exceptions, although some of its
                // constructors may.  The client may inquire as to whether any errors have
                // occurred by invoking {@link #checkError checkError()}.
                out.close();
            }
        }
    }

    public static void main(String[] args) {
        copyFile("/tmp/test.txt", "output.txt");
    }

}
