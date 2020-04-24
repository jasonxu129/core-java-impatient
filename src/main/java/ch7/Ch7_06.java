package ch7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ch7_06 {
    public static void processMap(Map<String, ? extends Set<Integer>> map) {
        System.out.println("Map size: " + map.size());
    }

    public static void main(String[] args) {
        HashMap<String, HashSet<Integer>> m = new HashMap<>();
        processMap(m);
    }
}
