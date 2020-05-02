package ch8;

import java.util.stream.Stream;

public class Ch8_04 {
    public static long A = 25214903917L;
    public static long C = 11;
    public static long M = 1 << 48;

    public static Stream<Long> random(long seed) {
        return random(A, C, M, seed);
    }

    private static Stream<Long> random(long a, long c, long m, long seed) {
        return Stream.iterate(seed, n -> (a*n + c) % m);
    };

    public static void main(String[] args) {
        Stream<Long> s = random(7);
        s.limit(10).forEach(System.out::println);
    }
}
