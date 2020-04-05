package ch4;

import java.lang.reflect.Method;

public class Ch4_12 {
    public static class Calculator {
        public static int add(int a, int b) {
            return a + b;
        }
    }

    public static void main(String[] args) {
        Method f;
        try {
            f = Calculator.class.getMethod("add", int.class, int.class);
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                f.invoke(null, 10, 10);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Reflection call 1000 times total execution time: " + (endTime-startTime) + "ms");
        } catch (Exception e) {
            System.out.println("Can't find method" + e);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Calculator.add(10,10);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Regular call 1000 times total execution time: " + (endTime-startTime) + "ms");
    }
}
