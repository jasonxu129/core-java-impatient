package ch8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ch8_01 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "Hello", "World", "!", "Software", "Engineer", "Programming", "Distributed", "System");
        //Stream<String> words = Stream.generate(() -> "looooooong");

        long count = words.stream().filter(w -> {
           System.out.println("filtering " + w);
           return w.length() > 4;
        }).limit(5).count();
    }
}
