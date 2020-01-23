package ch3;

import java.util.Iterator;

public class Ch3_7 {
    public static class DigitSequence implements Iterator<Integer> {
        private Integer num = 1;
        public boolean hasNext() {
            return true;
        }

        public Integer next() {
            return num++;
        }

        public void remove() {}
    }

    public static void main(String[] args) {
        DigitSequence sequence = new DigitSequence();
        for (int i = 0; i < 20; i++) {
            System.out.printf("%d ", sequence.next());
        }
    }
}
