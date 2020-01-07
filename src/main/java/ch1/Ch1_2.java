package ch1;

import java.util.Scanner;

public class Ch1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input angle:");
        int v = in.nextInt();
        int normalized = (v + 360) % 360;
        System.out.printf("Normalized value: %d\n", normalized);

        System.out.printf("Math.floorMod: %d", Math.floorMod(v, 360));
    }
}
