package ch3;

import java.util.Random;

public class Ch3_16 {
    public interface IntSequence {
        boolean hasNext();
        int next();
    }

    // Use nested class, need to provide explicit constructors to stores
    // low, high and generator in instance variables.
    public static class RandomSequence implements IntSequence {
        private static Random generator = new Random();
        private int low;
        private int high;

        public RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean hasNext() {
            return true;
        }
        @Override
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }
    }

    public static IntSequence randomInt(int low, int high) {
        return new RandomSequence(low, high);
    }

    // Use local class, capture three variables: low, high and random
    private static Random random = new Random();
    public static IntSequence randomInt2(int low, int high) {
        class RandomSequence2 implements IntSequence {
            public boolean hasNext() { return true; }
            public int next() {
                return low + random.nextInt(high -  low + 1);
            }
        }

        return new RandomSequence2();
    }

    public static void main(String[] args) {
        IntSequence sequence = randomInt(5, 10);
        for (int i = 0; i < 20; i++) {
            System.out.printf("%4d", sequence.next());
        }
        System.out.println();


        IntSequence sequence2 = randomInt2(2, 5);
        for (int i = 0; i < 20; i++) {
            System.out.printf("%4d", sequence2.next());
        }
    }
}
