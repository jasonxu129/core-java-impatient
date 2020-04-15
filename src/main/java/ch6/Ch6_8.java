package ch6;

public class Ch6_8 {
    public static class Pair<E extends Comparable<E>> {
        private E first;
        private E second;

        public Pair(E first, E second) {
            this.first = first;
            this.second = second;
        }

        public E getFirst() {
            return first;
        }

        public E getSecond() {
            return second;
        }

        public E min() {
            if (first.compareTo(second) < 0) {
                return first;
            }
            return second;
        }

        public E max() {
            if (first.compareTo(second) > 0) {
                return first;
            }
            return second;
        }
    }

    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(20, 100);
        System.out.println("min is :" + p.min());
        System.out.println("max is :" + p.max());
    }
}
