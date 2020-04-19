package ch6;


import javax.print.attribute.standard.Compression;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class Ch6_12 {
    public static <T> void minmax(List<T> elements,
                                  Comparator<? super T> comp, List<? super T> result) {
        T min = Collections.min(elements, comp);
        T max = Collections.max(elements, comp);
        result.add(min);
        result.add(max);
    }

    // Ch6 exercise 13
    public static <T> void maxmin(List<T> elements,
                                  Comparator<? super T> comp, List<? super T> result) {
        minmax(elements, comp, result);
        swap(result, 0, 1);
    }

    public static <T> void swap(List<T> elements, int i, int j) {
        if (i < 0 || j < 0 || i >= elements.size() || j >= elements.size()) {
            throw new IllegalArgumentException("Index out of bound");
        }
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>(Arrays.asList(2,1,3,4,7,6,5));
        List<Number> res = new ArrayList<>();

        minmax(elements, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }, res);
        System.out.println(res);

        List<Number> res1 = new ArrayList<>();
        maxmin(elements, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }, res1);
        System.out.println(res1);
    }
}
