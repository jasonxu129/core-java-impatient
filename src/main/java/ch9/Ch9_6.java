package ch9;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.*;
import java.util.Collections;

public class Ch9_6 {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("resources/w3c_home.bmp").toAbsolutePath();

        // BMP format http://www.ece.ualberta.ca/~elliott/ee552/studentAppNotes/2003_w/misc/bmp_file_format/bmp_file_format.htm
        try (RandomAccessFile file = new RandomAccessFile(path.toString(), "r")) {
            System.out.println("Length of the file: " + file.length());
            file.seek(2);
            byte[] bytes = new byte[4];
            file.read(bytes, 0, 4);
            int fileSize = readLittleEndian(bytes);
            System.out.println("File size by header: " + fileSize);

            file.seek(18);
            file.read(bytes);
            int width = readLittleEndian(bytes);
            file.read(bytes);
            int length = readLittleEndian(bytes);
            System.out.printf("Width: %d, Length: %d\n", width, length);

            file.seek(28);
            byte[] bytes1 = new byte[2];
            file.read(bytes1);
            ByteBuffer bb = ByteBuffer.wrap(bytes1);
            short bitsPerPixel = bb.order(ByteOrder.LITTLE_ENDIAN).getShort();
            System.out.printf("Bits per pixel: %d\n", bitsPerPixel);

            // Skip reading real pixels...
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int readLittleEndian(byte[] bytes) {
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        return bb.order(ByteOrder.LITTLE_ENDIAN).getInt();
    }
}
