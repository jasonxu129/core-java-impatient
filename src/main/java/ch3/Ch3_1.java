package ch3;

public class Ch3_1 {
    public interface Measurable {
        double getMeasure();
    }

    public static class Employee implements Measurable {
        private double salary;
        public Employee(double salary) {
            this.salary = salary;
        }

        public double getMeasure() {
            return salary;
        }
    }

    public static double average(Measurable[] objects) {
        int size = objects.length;
        double total = 0;
        for (Measurable m : objects) {
            total += m.getMeasure();
        }
        return size == 0 ? 0 : total / size;
    }

    public static void main(String[] args) {
        Employee[] employees = {new Employee(500), new Employee(900), new Employee(700)};
        double ave_salary = average(employees);
        System.out.printf("Average salary is %2.2f", ave_salary);
    }
}
