package ch8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Ch8_11 {
    public static void main(String[] args) {
        String[] words = {"hello", "world", "what", "a", "wonderful", "day"};
        Supplier<Stream<String>> wordsSupplier = () -> Stream.of(words);

        // or use wordsSupplier.get().map(String::length).reduce(Integer::max);
        Optional<Integer> size = wordsSupplier.get().map(String::length).max(Comparator.naturalOrder());

        String[] longWords = wordsSupplier.get()
                .filter(w -> w.length() == size.orElse(0))
                .toArray(String[]::new);

        System.out.println(Arrays.toString(longWords));
    }
}
