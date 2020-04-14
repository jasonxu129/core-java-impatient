package ch6;

import java.util.ArrayList;

public class Ch6_4 {
    public static class Table<K, V> {
        // Create Entry as inner class, not static nested class with 'static'.
        // It's also possible to make Entry generic with Entry<K, V>.
        public class Entry {
            private K key;
            private V value;
            public Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
            public K getKey() {
                return key;
            }
            public V getValue() {
                return value;
            }
            public void setKey(K key) {
                this.key = key;
            }
            public void setValue(V value) {
                this.value = value;
            }
        }

        private ArrayList<Entry> elements;

        public Table() {
            elements = new ArrayList<>();
        }

        public V get(K key) {
            for (Entry entry : elements) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
            return null;
        }

        public void put(K key, V value) {
            for (Entry entry : elements) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return;
                }
            }
            elements.add(new Entry(key, value));
        }

        public void remove(K key) {
            for (Entry entry : elements) {
                if (entry.getKey().equals(key)) {
                    elements.remove(entry);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Table<Integer, String> table = new Table<>();
        table.put(1, "Jason");
        table.put(2, "Max");
        table.put(3, "Henry");
        System.out.println(table.get(1));
        System.out.println(table.get(2));
        table.put(2, "Ben");
        System.out.println(table.get(2));
        table.remove(2);
        System.out.println(table.get(2));
    }
}
