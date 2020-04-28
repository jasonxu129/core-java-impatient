package ch7;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ch7_13 {
    public static class Cache<K, V> extends LinkedHashMap<K,V> {
        private final int maxEntries;

        public Cache(int maxEntries) {
            super(maxEntries, 0.75f, true);
            this.maxEntries = maxEntries;
        }

        @Override
        public boolean removeEldestEntry(Map.Entry<K,V> entry) {
            return size() > maxEntries;
        }
    }


    public static void main(String[] args) {
        Cache<String, Integer> cache = new Cache<>(3);

        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);

        System.out.println(cache);

        cache.put("D", 4);
        cache.get("B");
        cache.put("E", 5);
        System.out.println(cache);
    }
}
