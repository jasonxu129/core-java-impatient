package ch6;
import java.util.Arrays;

public class Ch6_2 {
    public static class StackE<E> {
        // Initialization of array of parameterized type is not allowed in Java.
        private E[] elements;
        private int pos;

        @SuppressWarnings("unchecked")
        public StackE(int capacity) {
            this.elements = (E[])new Object[capacity];
            this.pos = 0;
        }

        public boolean isEmpty() {
            return pos == 0;
        }

        public void push(E elem) {
            if (pos == elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 2);
            }
            elements[pos++] = elem;
        }

        public E pop() {
            if (pos == 0) {
                throw new IllegalStateException("Stack is empty");
            }
            E e = elements[--pos];
            elements[pos] = null;  // Remove reference to the object.
            return e;
        }
    }

    // Solution using array of Object:
    // https://howtodoinjava.com/data-structure/java-stack-implementation-array/
    public static class StackO<E> {
        private Object[] elements;
        private int pos;
        public StackO(int capacity) {
            elements = new Object[capacity];
            pos = 0;
        }

        public boolean isEmpty() {
            return pos == 0;
        }

        public void push(E elem) {
            if (elements.length == pos) {
                elements = Arrays.copyOf(elements, 2 * elements.length);
            }
            elements[pos++] = elem;
        }

        @SuppressWarnings("unchecked")
        public E pop() {
            if (pos == 0) {
                throw new IllegalStateException("Stack is empty");
            }
            E e = (E) elements[--pos];
            elements[pos] = null;
            return e;
        }
    }

    public static void main(String[] args) {
        StackE<String> stack = new StackE<>(10);
        stack.push("hello");
        stack.push("world");
        stack.push("!");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        StackO<Integer> stack2 = new StackO<>(10);
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }
    }
}
