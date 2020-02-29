package ch4;

import java.util.Objects;

public class Ch4_2 {
    public static class Point {
        private double x;
        private double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public double getX() {
            return x;
        }
        public double getY() {
            return y;
        }

        @Override
        public String toString() {
            return this.getClass().getName() + "[x=" + x + ",y=" + y + "]";
        }
        @Override
        public boolean equals(Object otherObject) {
            if (this == otherObject) return true;
            if (otherObject == null) return false;
            if (this.getClass() != otherObject.getClass()) return false;
            Point p = (Point) otherObject;
            return x == p.getX() && y == p.getY();
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static class LabeledPoint extends Point {
        private String label;
        public LabeledPoint(double x, double y, String label) {
            super(x, y);
            this.label = label;
        }
        public String getLabel() {
            return label;
        }
        @Override
        public String toString() {
            return super.toString() + "[label=" + label + "]";
        }
        @Override
        public boolean equals(Object otherObject) {
            if (!super.equals(otherObject)) {
                return false;
            }
            LabeledPoint l = (LabeledPoint) otherObject;
            return Objects.equals(label, l.label);
        }
        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), label);
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(2, 3);
        Point p3 = new Point(2, 4);
        System.out.println("p1: " + p1 + ", hashcode: " + p1.hashCode());
        System.out.println("p2: " + p2 + ", hashcode: " + p2.hashCode());
        System.out.println("p2: " + p3 + ", hashcode: " + p3.hashCode());
        System.out.println("p1 == p2: " + p1.equals(p2));
        System.out.println("p1 == p3: " + p1.equals(p3));

        LabeledPoint l1 = new LabeledPoint(2, 3, "good");
        LabeledPoint l2 = new LabeledPoint(2, 3, "good");
        System.out.println("l1: " + l1 + ", hashcode: " + l1.hashCode());
        System.out.println("l1 == l2: " + l1.equals(l2));
    }
}
