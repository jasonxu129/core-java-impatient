package ch4;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Ch4_10 {
    public static void printAllMethods(Class<?> cl) {
        while (cl != null) {
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(
                        Modifier.toString(m.getModifiers()) + " " +
                                m.getReturnType().getCanonicalName() + " " +
                                m.getName() + " " +
                                Arrays.toString(m.getParameterTypes()));
            }
            cl = cl.getSuperclass();
        }
    }

    public static void main(String[] args) {
        Class<?> c = int[].class;
        printAllMethods(c);
    }
}
