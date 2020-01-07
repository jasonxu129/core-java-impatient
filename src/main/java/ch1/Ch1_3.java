package ch1;

import java.util.Scanner;

public class Ch1_3 {
    public static void main(String[] args) {
        System.out.println("Input 3 integers:");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int maximum = a > b ? a : b;
        maximum = maximum > c ? maximum : c;
        System.out.printf("Max is : %d\n", maximum);

        int max2 = Math.max(a, Math.max(b, c));
        System.out.printf("Max from Math.max(): %d", max2);
    }
}
