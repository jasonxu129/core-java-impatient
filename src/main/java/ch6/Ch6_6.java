package ch6;

import java.util.ArrayList;
import java.util.Arrays;

public class Ch6_6 {
    public static <E> void appendE(ArrayList<? extends E> src, ArrayList<E> des) {
        for (int i = 0; i < src.size(); i++) {
            E e = src.get(i);
            des.add(e);
        }
    }

    public static <E> void appendS(ArrayList<E> src, ArrayList<? super E> des) {
        for (E e : src) {
            des.add(e);
        }
    }

    public static void main(String[] args) {
        // List.of is available in Java 9, use Arrays.asList here.
        ArrayList<Double> src = new ArrayList<>(Arrays.asList(0.1, 0.2));
        ArrayList<Number> des = new ArrayList<>();

        appendE(src, des);
        System.out.println(des);
        appendS(src, des);
        System.out.println(des);
    }
}
