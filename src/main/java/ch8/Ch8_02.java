package ch8;

import java.util.stream.Stream;

public class Ch8_02 {
    public static void main(String[] args) {
        final int TEST_SIZE = 100000000;

        Stream<String> words = Stream.generate(() -> "loooooooooooong");
        long startTs = System.currentTimeMillis();
        long count = words.limit(TEST_SIZE).filter(w -> w.length() > 10).count();
        long endTs = System.currentTimeMillis();
        System.out.printf("stream takes %d ms, res: %d\n", endTs - startTs, count);

        Stream<String> words2 = Stream.generate(() -> "loooooooooooong");
        startTs = System.currentTimeMillis();
        long count2 = words2.parallel().limit(TEST_SIZE).filter(w -> w.length() > 10).count();
        endTs = System.currentTimeMillis();
        System.out.printf("parallel stream takes %d ms, res: %d\n", endTs - startTs, count2);
    }
}
