package ch6;

import java.util.ArrayList;
import java.util.Arrays;

public class Ch6_9 {
    public static class Pair<E> {
        private E first;
        private E second;
        public Pair(E first, E second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public String toString() {
            return String.format("(%s, %s)", first, second);
        }
    }

    public static <E> Pair<E> firstLast(ArrayList<? extends E> a) {
        if (a.isEmpty()) {
            throw  new IllegalArgumentException("input array list is empty");
        }
        E first = a.get(0);
        E last = a.get(a.size() - 1);
        return new Pair<>(first, last);
    }

    public static void main(String[] args) {
        ArrayList<Double> doubles = new ArrayList<>(Arrays.asList(2.0, 3.0, 5.5));
        Pair<Number> pair = firstLast(doubles);
        System.out.println(pair);
    }
}
