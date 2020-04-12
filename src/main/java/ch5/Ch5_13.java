package ch5;

import java.util.Random;

public class Ch5_13 {
    public static int min(int[] values) throws IllegalArgumentException {
        if (values.length == 0) {
            throw new IllegalArgumentException("empty array");
        }
        int res = Integer.MAX_VALUE;
        for (int x : values) {
            if (x < res) {
                res = x;
            }
        }
        checkMin(values, res);
        return res;
    }

    public static void checkMin(int[] values, int min) {
        for (int x : values) {
            assert x >= min : String.format("Not valid x >= min (%d >= %d)", x, min);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            nums[i] = random.nextInt(1000) + 1;
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            min(nums);
        }
        long endTime = System.nanoTime();
        long durationInNano = endTime - startTime;
        System.out.println("Runtime in nano seconds: " + durationInNano);
    }
}
