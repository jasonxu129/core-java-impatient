package ch1;

import java.util.Scanner;

public class Ch1_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input two integers (between 0 and 4294967295):");
        // 4294967295 = 2 ^ 32 - 1;  1 for 32 bits.
        int a = (int) in.nextLong();
        int b = (int) in.nextLong();
        System.out.printf("Unsigned sum: %d\n", Integer.toUnsignedLong(a) + Integer.toUnsignedLong(b));
        System.out.printf("Difference: %d\n", Integer.toUnsignedLong(a) - Integer.toUnsignedLong(b));
        System.out.printf("Product: %d\n", Integer.toUnsignedLong(a) * Integer.toUnsignedLong(b));
        System.out.printf("Quotient: %d\n", Integer.divideUnsigned(a, b));
        System.out.printf("Reminder: %d\n", Integer.remainderUnsigned(a, b));
        System.out.printf("Integer max: %d\n", Integer.MAX_VALUE);
    }
}