package ch6;

import java.util.Arrays;
import java.util.function.IntFunction;

public class Ch6_18 {
    public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr) {
        T[] res = constr.apply(n);
        for (int i = 0; i < n; i++) {
            res[i] = obj;
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] res = repeat(10, new Integer(42), Integer[]::new);
        System.out.println(Arrays.toString(res));
    }
}
