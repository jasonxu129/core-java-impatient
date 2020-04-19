package ch6;

import java.util.ArrayList;
import java.util.Arrays;

public class Ch6_11 {
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
    public static <E extends Comparable<? super E>> Pair<E> minMax(ArrayList<E> elements) {
        if (elements.isEmpty()) {
            return new Pair<>(null, null);
        }
        E min = elements.get(0);
        E max = elements.get(0);
        for (E elem : elements) {
            if (min.compareTo(elem) > 0) {
                min = elem;
            }
            if (max.compareTo(elem) < 0) {
                max = elem;
            }
        }
        return new Pair<>(min, max);
    }

    public static void main(String[] args) {
        ArrayList<Double> elements = new ArrayList<Double>(Arrays.asList(1.2, 2.2, 6.2, 5.0, 3.3, 0.0));
        Pair<Double> p = minMax(elements);
        System.out.println("min: " + p.getFirst() + ", max: " + p.getSecond());
    }
}
