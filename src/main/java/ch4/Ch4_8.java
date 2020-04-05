package ch4;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class has six methods that yield a String representation of the type represented
 * by the Class object. How do they differ when applied to arrays, generic types, inner
 * class, and primitive types?
 */
public class Ch4_8 {
    public static void printClassPrepresentations(Class<?> c) {
        System.out.println("Canonical name: " + c.getCanonicalName());
        System.out.println("Simple name: " + c.getSimpleName());
        System.out.println("Type name: " + c.getTypeName());
        System.out.println("Name: " + c.getName());
        System.out.println("toString: " + c.toString());
        System.out.println("toGenericString: " + c.toGenericString());
    }

    public static class Test {
    }

    public static void main(String[] args) {
        // no class literal for concrete parameterized types, so only List.class
        // https://stackoverflow.com/questions/2390662/java-how-do-i-get-a-class-literal-from-a-generic-type
        Class<?>[] classList = {String[].class, Test.class,
                double.class, Runnable.class, void.class, ArrayList.class};
        for (Class<?> c : classList) {
            printClassPrepresentations(c);
        }
    }
}
