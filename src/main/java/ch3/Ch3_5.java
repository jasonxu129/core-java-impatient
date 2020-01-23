package ch3;

public class Ch3_5 {
    public interface IntSequence {
        boolean hasNext();
        int next();
        public static IntSequence constant(int num) {
            return new ConstantSequence(num);
        }
    }

    public static class ConstantSequence implements IntSequence {
        private final int num;
        public ConstantSequence(int num) {
            this.num = num;
        }
        public boolean hasNext() {
            return true;
        }
        public int next() {
            return num;
        }
    }

    public static void main(String[] args) {
        IntSequence sequence = IntSequence.constant(5);
        for (int i = 0; i < 20; i++) {
            if (sequence.hasNext()) {
                System.out.printf("%4d", sequence.next());
            }
        }
    }
}
