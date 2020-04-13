package ch6;

public class ArrayTypeTest {
    public static class Employee {
    }
    public static class Boss extends Employee {
    }

    public static void main(String[] args) {
        Employee[] employees = new Boss[100];

        try {
            employees[0] = new Employee();
        } catch (ArrayStoreException ex) {
            System.err.println("Failed to store Employee in Boss array: " + ex);
        }
    }
}
