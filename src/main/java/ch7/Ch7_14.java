package ch7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Ch7_14 {
    public static List<Integer> getImmutableList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(i);
        }
        return Collections.unmodifiableList(list.subList(0, list.size()));
    }

    public static Iterator<Integer> immutableList(int n) {
        return new Iterator<Integer>() {
            private int current;

            public boolean hasNext() {
                return current <= n;
            }

            public Integer next() {
                return current++;
            }
        };
    }

    public static void main(String[] args) {
        List<Integer> list = getImmutableList(20);
        try {
            list.add(21);
        } catch (UnsupportedOperationException ex) {
            ex.printStackTrace();
        }


        Iterator<Integer> iter = immutableList(10);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // Java 8 use Iterator.forEachRemaining() method
        // https://www.baeldung.com/java-convert-iterator-to-list
        List<Integer> list2 = new ArrayList<>();
        Iterator<Integer> iter2 = immutableList(5);
        iter2.forEachRemaining(list2::add);
        System.out.println(list2);
    }
}
