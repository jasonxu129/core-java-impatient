package ch6;

import java.util.Arrays;
import java.util.Collections;

public class Ch6_10 {
    public static <E extends Comparable<? super E>> E min(E[] elements) {
        return Collections.min(Arrays.asList(elements));
        /*
        if (elements.length == 0) {
            return null;
        }

        E currMin = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (currMin.compareTo(elements[i]) > 0) {
                currMin = elements[i];
            }
        }
        return currMin;
        */

    }

    public static <E extends Comparable<? super E>> E max(E[] elements) {
        return Collections.max(Arrays.asList(elements));
        /*
        if (elements.length == 0) {
            return null;
        }

        E currMax = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (currMax.compareTo(elements[i]) < 0) {
                currMax = elements[i];
            }
        }
        return currMax;
         */
    }

    public static void main(String[] args) {
        Double[] list = new Double[]{2.2, 3.3, 5.0};
        Double minVal = min(list);
        Double maxVal = max(list);
        System.out.println("min is: " + minVal);
        System.out.println("max is: " + maxVal);
    }

}
