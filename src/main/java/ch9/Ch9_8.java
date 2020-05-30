package ch9;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Collections;

public class Ch9_8 {
    public static void main(String[] args) throws Exception {
        Path zipPath = Paths.get("files.zip");
        URI uri = new URI("jar", zipPath.toUri().toString(), null);
        try (FileSystem zipfs = FileSystems.newFileSystem(uri,
                Collections.singletonMap("create", "true"))) {
            Path source = Paths.get("resources");
            Files.walk(source).forEach(p -> {
                try {
                    Files.copy(p, zipfs.getPath("/", p.toString()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        }

        System.out.println("list all files in ZIP archive:");
        FileSystem fs = FileSystems.newFileSystem(zipPath, null);
        Files.walk(fs.getPath("/")).forEach(System.out::println);
    }
}
