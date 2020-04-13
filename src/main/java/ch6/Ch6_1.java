package ch6;

import java.util.ArrayList;

public class Ch6_1 {
    public static class Stack<E> {
        private ArrayList<E> list;

        public Stack(int capacity) {
            list = new ArrayList<>(capacity);
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void push(E element) {
            list.add(element);
        }

        public E pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(10);
        stack.push("hello");
        stack.push("world");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
