package ch4;

public class Ch4_5 {
    public static class Point implements Cloneable {
        private double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        @Override
        public Point clone() {
            return new Point(x, y);
        }
        @Override
        public String toString() {
            return this.getClass().getName() + "[" + x + "," + y + "]";
        }
    }

    public static abstract class Shape implements Cloneable {
        private Point p;
        public Shape(Point p) {
            this.p = p;
        }
        public Point getPoint() {
            return p;
        }
        public void moveBy(double dx, double dy) {
            p.setX(p.getX() + dx);
            p.setY(p.getY() + dy);
        }

        @Override
        public Shape clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException("Shape clone not supported");
        }

        @Override
        public String toString() {
            return p.toString();
        }

        public abstract Point getCenter();
    }

    // implements Cloneable is optional since Shape has done it.
    public static class Circle extends Shape implements Cloneable {
        private final double radius;
        public Circle(Point center, double radius) {
            super(center);
            this.radius = radius;
        }
        @Override
        public Point getCenter() {
            return getPoint();
        }

        @Override
        public Circle clone() {
            return new Circle(getPoint().clone(), radius);
        }

        @Override
        public String toString() {
            return super.toString() + "[radius=" + radius + "]";
        }
    }

    public static void main(String[] args) {
        Point point = new Point(2,3);
        Point clonePoint = point.clone();
        clonePoint.setX(10);
        System.out.println("Orginal:" + point + " clone:" + clonePoint);

        Circle circle = new Circle(point, 20);
        Circle cloneCircle = circle.clone();
        System.out.println("circle:" + circle + " clone: " + cloneCircle);

        cloneCircle.getCenter().setX(100);
        System.out.println("circle:" + circle + " clone: " + cloneCircle);
    }
}
