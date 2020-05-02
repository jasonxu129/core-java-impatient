package ch8;

import java.util.Optional;
import java.util.stream.Stream;

public class Ch8_03 {
    public static void main(String[] args) {
        int[] values = { 1, 4, 9, 16 };
        Stream<int[]> s = Stream.of(values);
        System.out.println(s.count());
        

    }
}
