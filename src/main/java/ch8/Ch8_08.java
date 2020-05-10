package ch8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch8_08 {

    public static Optional<Integer> generate(int n) {
        if (n % 2 == 0) {
            return Optional.of(n);
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        List<Integer> s = Stream.of(1,2,3,4,5,6,7,8,9,12)
                .map(Ch8_08::generate)
                .collect(Collectors.flatMapping(
                        l -> l.stream(),
                        Collectors.toList()
                ));

        System.out.println(s);
    }
}
