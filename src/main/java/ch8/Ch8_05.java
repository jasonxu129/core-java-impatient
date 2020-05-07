package ch8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ch8_05 {
    public static Stream<String> CodePoints(String s) {
        Stream<Integer> indexStream = Stream.iterate(0,
                i -> i < s.length(),
                i -> s.offsetByCodePoints(i, 1));

        Stream<String> stream = indexStream.map(
                offset -> s.substring(offset, s.offsetByCodePoints(offset, 1)));
        return stream;
    }

    public static void main(String[] args) {
        Stream<String> stream = CodePoints("hello");
        System.out.println(Arrays.toString(stream.toArray()));
    }
}
