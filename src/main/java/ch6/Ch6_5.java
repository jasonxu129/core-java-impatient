package ch6;

import java.util.Arrays;

public class Ch6_5 {
    // array supplied with varargs.
    @SuppressWarnings("unchecked")
    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

    public static void main(String[] args) {
        // Varvargs provides are not of type Double, it's ? extend Number.
        // Double[] doubles = swap(0, 1, 1.5, 2, 3);
        Double[] doubles = swap(0, 1, 1.5, 2.0, 3.0);
        System.out.println(Arrays.toString(doubles));
        // Double[] doubles1 = Ch6_5.<Double>swap(0, 1, 1.5, 2.0, 3.0); also works
    }
}
