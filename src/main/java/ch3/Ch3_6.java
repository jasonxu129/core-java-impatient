package ch3;

import java.math.BigInteger;

public class Ch3_6 {
    public interface Sequence<T> {
        boolean hasNext();
        T next();
    }

    public static class SquareSequence implements Sequence<BigInteger> {
        private static BigInteger num = BigInteger.ONE;

        public boolean hasNext() {
            return true;
        }

        public BigInteger next() {
            BigInteger res = num.multiply(num);
            num = num.add(BigInteger.ONE);
            return res;
        }
    }

    public static void main(String[] args) {
        SquareSequence ss = new SquareSequence();
        for (int i = 0; i < 20; i++) {
            System.out.printf("%s ", ss.next());
        }
    }
}
