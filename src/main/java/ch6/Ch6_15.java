package ch6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class Ch6_15 {
    public static <T, R> ArrayList<R> map(ArrayList<T> elems, Function<T, R> fun) {
        ArrayList<R> res = new ArrayList<>(elems.size());
        for (T elem : elems) {
            res.add(fun.apply(elem));
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> elems = new ArrayList<>(Arrays.asList(2, 3, 5, 6));
        ArrayList<Double> res = map(elems, new Function<Integer, Double>() {
            @Override
            public Double apply(Integer t) {
                return 10.0 + t;
            }
        });
        System.out.println(res);
    }
}
