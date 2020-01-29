package ch3;

import java.util.Arrays;
import java.util.Comparator;

public class Ch3_15 {
    public static class Employee {
        private double salary;
        private String name;

        public Employee(double salary, String name) {
            this.salary = salary;
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "salary=" + salary +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee(200, "Alice"),
                new Employee(100, "Bob"),
                new Employee(200, "Charlie"),
        };

        Arrays.sort(employees, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
        System.out.println(Arrays.toString(employees));

        Arrays.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
        System.out.println(Arrays.toString(employees));
    }
}
