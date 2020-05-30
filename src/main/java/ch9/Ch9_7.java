package ch9;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ch9_7 {
    public static byte[] digest(Path path) throws IOException {
        InputStream input = Files.newInputStream(path);
        byte[] bytes = input.readAllBytes();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(bytes);
            return md.digest();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            char[] hexDigits = new char[2];
            hexDigits[0] = Character.forDigit((b >> 4) & 0xF, 16);
            hexDigits[1] = Character.forDigit(b & 0xF, 16);
            sb.append(hexDigits);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Path path = Paths.get("resources/words.txt").toAbsolutePath();
        try {
            byte[] bytes = digest(path);
            // Compare results with output from shell command "shasum -a512 resources/words.txt"
            String hash = bytesToHex(bytes);
            System.out.println(hash);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
