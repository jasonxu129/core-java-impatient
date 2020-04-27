package ch7;

import java.util.*;

public class Ch7_11 {
    public static void main(String[] args) {
        System.out.println("Input a sentence:");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        List<String> list = Arrays.asList(line.trim().split("\\s+"));

        List<String> view = list.subList(1, list.size() - 1);
        Collections.shuffle(view);
        System.out.println(list);
    }
}
