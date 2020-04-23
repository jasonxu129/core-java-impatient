package ch7;

import java.util.*;

public class Ch7_04 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2));
        Iterator<Integer> iter = list.iterator();

        ListIterator<Integer> li = list.listIterator();
        li.add(100);
        try {
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
