package ch6;

// javap - Disassembles one or more class files.
// The output depends on the options used. When no options are used, then the javap command prints
// the package, protected and public fields, and methods of the classes passed to it.

// javap -cp build/libs/core-java-impatient-1.0-SNAPSHOT.jar ch6.Ch6_17.Employee
//Compiled from "Ch6_17.java"
//public class ch6.Ch6_17$Employee implements java.lang.Comparable<ch6.Ch6_17$Employee> {
//  public ch6.Ch6_17$Employee();
//  public int compareTo(ch6.Ch6_17$Employee);
//  public int compareTo(java.lang.Object);
//}
public class Ch6_17 {
    public static class Employee implements Comparable<Employee> {
        private String name;
        private int salary;
        public int compareTo(Employee t) {
            return this.salary - t.salary;
        }
    }
}
