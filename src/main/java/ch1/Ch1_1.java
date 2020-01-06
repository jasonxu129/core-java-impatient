package ch1;

import java.util.Scanner;

public class Ch1_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input an integer:");
        int v = in.nextInt();
        System.out.println();
        System.out.printf("dec: %d\n", v);
        System.out.printf("hex: %x\n", v);
        System.out.printf("oct: %o\n", v);
        double reciprocal = 1.0 / v;
        System.out.printf("hexdecimal floating-point number: %a\n", reciprocal);
    }
}
