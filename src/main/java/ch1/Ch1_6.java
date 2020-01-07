package ch1;

import java.math.BigInteger;

public class Ch1_6 {
    public static void main(String[] args) {
        BigInteger result = BigInteger.ONE;
        for (long i = 1; i <= 1000; i ++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.printf("Factorial of 1000 is: %d", result);
    }
}
