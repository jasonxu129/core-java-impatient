package ch1;

import java.util.Random;

public class Ch1_10 {
    public static void main(String[] args) {
        Long v = new Random().nextLong();
        String str = Long.toString(v, 36);
        System.out.println(v + " to base 36 " + str);
    }
}
