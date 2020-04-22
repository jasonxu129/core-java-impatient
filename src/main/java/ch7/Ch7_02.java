package ch7;

import java.util.*;

public class Ch7_02 {
    public static ArrayList<String> toUpperCaseA(ArrayList<String> strings) {
        ListIterator<String> iter = strings.listIterator();
        while (iter.hasNext()) {
            String str = iter.next();
            iter.set(str.toUpperCase());
        }
        return strings;
    }

    public static ArrayList<String> toUpperCaseB(ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            String upper = strings.get(i).toUpperCase();
            strings.set(i, upper);
        }
        return strings;
    }

    public static ArrayList<String> toUpperCaseC(ArrayList<String> strings) {
        strings.replaceAll(e -> e.toUpperCase());
        return strings;
    }


    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("Hello", "world", "Jason"));
        System.out.println(toUpperCaseC(words));
    }
}
