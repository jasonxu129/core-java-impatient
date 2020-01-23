package ch3;

public class Ch3_4 {
    public interface IntSequence {
        boolean hasNext();
        int next();
        static IntSequence of(int... vals) {
            return new NumSequence(vals);
        }
    }

    public static class NumSequence implements IntSequence {
        private int[] vals;
        private int index;

        public NumSequence(int[] vals) {
            this.vals = vals;
        }

        public boolean hasNext() {
            return index < vals.length;
        }
        public int next() {
            return vals[index++];
        }
    }

    public static void main(String[] args) {
        IntSequence sequence = IntSequence.of(3, 2, 4, 1, 6, 5);
        System.out.println("Sequence generated by static of method: ");
        while (sequence.hasNext()) {
            System.out.printf("%4d", sequence.next());
        }
    }
}
