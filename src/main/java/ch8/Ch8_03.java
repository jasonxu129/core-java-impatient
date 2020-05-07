package ch8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ch8_03 {
    public static void main(String[] args) {
        int[] values = { 1, 4, 9, 16 };
        Stream<int[]> s = Stream.of(values);
        s.forEach(x -> System.out.println(Arrays.toString(x)));

        IntStream s1 = Arrays.stream(values);
        s1.forEach(System.out::println);
    }
}
