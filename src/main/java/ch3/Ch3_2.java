package ch3;

public class Ch3_2 {
    public interface Measurable {
        double getMeasure();
    }

    public static class Employee implements Measurable {
        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name  = name;
            this.salary = salary;
        }

        @Override
        public double getMeasure() {
            return salary;
        }

        public String getName() {
            return name;
        }
    }

    public static Measurable largest(Measurable[] objects) {
        if (objects.length == 0) {
            return null;
        }

        Measurable largest = objects[0];
        for (int i = 1; i < objects.length; i++) {
            if (largest.getMeasure() < objects[i].getMeasure()) {
                largest = objects[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        Employee[] employees = {new Employee("Bob", 200), new Employee("Alice", 100), new Employee("Tom", 300)};
        Measurable obj = largest(employees);
        Employee highest = (Employee)obj;
        System.out.printf("Employee %s has highest salary %2.2f", highest.getName(), highest.getMeasure());
    }
}
