package ch5;

import java.util.Objects;

public class Ch5_12 {
    public static void testAssertion(Integer num) {
        // The assertion allows you to put in checks during testing and to have them automatically
        // removed in the production code.
        // In Java, assertions are intended for a debugging aid for validating internal assumptions.
        assert num != null : "passed null object";
        System.out.println(num);
    }

    public static class Person {
        String name;
        public Person(String name) {
            // This method is designed primarily for doing parameter validation in methods
            // and constructors.
            this.name = Objects.requireNonNull(name);
        }
    }

    // Edit VM option "-ea" or "-enableassertions".
    public static void main(String[] args) {
        Integer n = null;
        testAssertion(5);
        testAssertion(n);
    }
}
