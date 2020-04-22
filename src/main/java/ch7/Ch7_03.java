package ch7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ch7_03 {
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> res = new HashSet<E>(s1);
        res.addAll(s2);
        return res;
    }

    public static <E> Set<E> intersaction(Set<E> s1, Set<E> s2) {
        Set<E> res = new HashSet<E>(s1);
        res.retainAll(s2);
        return res;
    }

    public static <E> Set<E> difference(Set<E> s1, Set<E> s2) {
        Set<E> res = new HashSet<E>(s1);
        res.removeAll(s2);
        return res;
    }

    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>(Arrays.asList("one", "two"));
        Set<String> s2 = new HashSet<>(Arrays.asList("two", "three"));

        System.out.println(union(s1, s2));
        System.out.println(intersaction(s1, s2));
        System.out.println(difference(s1, s2));
    }
}
