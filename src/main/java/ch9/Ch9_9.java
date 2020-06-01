package ch9;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Ch9_9 {
    public static void main(String[] args) throws IOException {
        // Use dummy username and password to connect to random site (Google here),
        // Only for demonstration purpose.
        String username = "username";
        String password = "password";
        String input = username + ":" + password;
        String encoding = Base64.getEncoder().encodeToString(
                input.getBytes(StandardCharsets.UTF_8));

        URL url = new URL("http://www.google.com");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("Authorization", "Basic " + encoding);
        connection.connect();
        try (InputStream in = connection.getInputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            reader.lines().forEach(System.out::println);
        }
    }
}
