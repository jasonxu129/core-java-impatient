package ch8;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch8_10 {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("hello", "world", "what", "a", "wonderful", "day");
        IntSummaryStatistics summary = words.collect(
                Collectors.summarizingInt(String::length));

        System.out.println("max " + summary.getMax());
        System.out.println("average " + summary.getAverage());
    }
}
