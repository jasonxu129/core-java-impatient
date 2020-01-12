package ch1;

import java.util.*;

public class Ch1_13 {
    public static void main(String[] args) {
        int[] numbers = new int[49];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i+1;
        }

        Random r = new Random();
        List<Integer> result = new ArrayList<>();
        for (int c = 0; c < 6; c++) {
            int idx = r.nextInt(49 - c);
            result.add(numbers[idx]);
            numbers[idx] = numbers[48 - c];
        }

        Collections.sort(result);
        System.out.println("Lottery combination is: " + result);
    }
}
