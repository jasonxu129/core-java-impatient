package ch4;

import java.lang.reflect.Field;

public class Ch4_9 {
    public static class UniversalToString {
        public static String toString(Object object) {
            StringBuilder builder = new StringBuilder();
            builder.append(object.getClass().getName() + "[");
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                try {
                    Object value = f.get(object);
                    builder.append(f.getName() + ":" + value + ",");
                } catch (IllegalAccessException e) {
                    // can't happen
                    builder.append(f.getName() + " unable to access");
                }
            }
            builder.append(']');
            return builder.toString();
        }
    }

    public static class Student {
        private int id;
        private int age;
        public String firstName;
        public String lastName;
        private double score;
        boolean hasScholarship;

        public Student(int id, int age, String firstName, String lastName, double score, boolean hasScholarship) {
            this.id = id;
            this.age = age;
            this.firstName = firstName;
            this.lastName = lastName;
            this.score = score;
            this.hasScholarship = hasScholarship;
        }

        @Override
        public String toString() {
            return UniversalToString.toString(this);
        }
    }


    public static void main(String[] args) {
        Student student = new Student(1234, 16, "John", "Smith", 88.9, true);
        System.out.println(student);
    }
}
