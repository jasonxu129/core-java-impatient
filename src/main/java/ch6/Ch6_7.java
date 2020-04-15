package ch6;

public class Ch6_7 {
    public static class Pair<E> {
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
    }
}
