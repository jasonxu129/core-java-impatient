package ch3;

import java.util.*;

public class Ch3_8 {
    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        Random rand = new Random();
        while (!isSorted(strings, comp)) {
            Collections.shuffle(strings, rand);
        }
    }

    public static boolean isSorted(ArrayList<String> strings, Comparator<String> comp) {
        for (int i = 0; i < strings.size()  - 1; i++) {
            if (comp.compare(strings.get(i), strings.get(i+1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("Tom", "Alice", "Bob", "Susan"));
        //luckySort(strings, (a, b) ->  a.compareToIgnoreCase(b) );
        luckySort(strings, String::compareToIgnoreCase);

        System.out.println(strings);
    }
}
