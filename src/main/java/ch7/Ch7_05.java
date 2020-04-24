package ch7;

import java.util.*;

public class Ch7_05 {
    public static void swap(List<?> list, int i, int j) {
        if (list instanceof RandomAccess) {
            randomAccessSwap(list, i, j);
        } else {
            sequentialAccessSwap(list, i, j);
        }
    }
    public static <E> void randomAccessSwap(List<E> list, int i, int j) {
        // Collections.swap(list, i, j);
        list.set(i, list.set(j, list.get(i)));
    }

    public static <E> void sequentialAccessSwap(List<E> list, int i, int j) {
        System.out.println("Entering sequentialAccessSwap");
        if (i > j) {
            throw new IllegalArgumentException("index " + i + " > " + j);
        }

        ListIterator<E> iter = list.listIterator(i);
        E first = iter.next();
        for (int s = i+1; s < j; s++) {
            iter.next();
        }
        E second = iter.next();
        iter.set(first);
        for (int s = j + 1; s > i; s--) {
            iter.previous();
        }
        iter.set(second);
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        swap(list, 2, 5);
        System.out.println(list);
    }
}
