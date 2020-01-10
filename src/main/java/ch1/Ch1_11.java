package ch1;

import java.util.Scanner;

public class Ch1_11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a string:");
        String text = in.nextLine();
        for (int i = 0; i < text.length(); i ++) {
            int v = (int) text.charAt(i);
            if (v > 127) {
                System.out.println(text.charAt(i) + " with value " + v);
            }
        }
    }
}
