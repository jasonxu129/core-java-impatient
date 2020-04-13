package ch6;

import java.util.ArrayList;

public class Ch6_3 {
    public static class Entry<K, V> {
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
        @Override
        public String toString() {
            return "Key: " + key + " Value: " + value;
        }
    }

    public static class Table<K, V> {
        private ArrayList<Entry<K, V>> elements;

        public Table() {
            elements = new ArrayList<>();
        }

        public V get(K key) {
            for (Entry<K, V> entry : elements) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
            return null;
        }

        public void put(K key, V value) {
            for (Entry<K, V> entry : elements) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return;
                }
            }
            elements.add(new Entry<>(key, value));
        }

        public void remove(K key) {
            for (Entry<K, V> entry : elements) {
                if (entry.getKey().equals(key)) {
                    elements.remove(entry);
                    return;
                }
            }
            /*
            int i;
            for (i = 0; i < elements.size(); i++) {
                if (elements.get(i).getKey().equals(key)) {
                    break;
                }
            }
            if (i < elements.size()) {
                elements.remove(i);
            }
            */
        }
    }

    public static void main(String[] args) {
        Table<String, Integer> table = new Table<>();
        table.put("Hello", 1);
        table.put("World", 2);
        table.put("Java", 3);
        System.out.println("Find value for 'World': " + table.get("World"));
        table.remove("World");
        System.out.println("Find value for 'World': " + table.get("World"));
        System.out.println("Find value for 'Java': "  + table.get("Java"));
    }
}
