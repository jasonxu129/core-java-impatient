package ch1;

import java.util.Scanner;

public class Ch1_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a string:");
        String str = in.nextLine();

        String[] subs = str.trim().split("\\s+");
        System.out.println("non empty substrings: ");
        for (String sub : subs) {
            System.out.println(sub);
        }
    }
}
