package ch2;

import java.util.ArrayList;
import java.util.Random;

public class Ch2_10 {
    public static class RandomNumbers {
        private static Random random = new Random();
        public static int randomElement(int[] elements) {
            if (elements.length == 0) {
                return 0;
            }
            int idx = random.nextInt(elements.length);
            return elements[idx];
        }

        public static int randomElement(ArrayList<Integer> elements) {
            if (elements.isEmpty()) {
                return 0;
            }
            int idx = random.nextInt(elements.size());
            return elements.get(idx);
        }
    }
}
