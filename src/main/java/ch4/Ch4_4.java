package ch4;

import javax.sound.midi.Receiver;

public class Ch4_4 {
    public static class Point {
        private double x, y;
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
        public void setX(double x) {
            this.x = x;
        }
        public void setY(double y) {
            this.y = y;
        }
        @Override
        public String toString() {
            return getClass().getName() + ", x=" + x + ", y=" + y;
        }
    }

    public static abstract class Shape {
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
        public abstract Point getCenter();
    }

    public static class Circle extends Shape {
        private double radius;
        public Circle(Point center, double radius) {
            super(center);
            this.radius = radius;
        }
        @Override
        public Point getCenter() {
            return getPoint();
        }
    }

    public static class Rectangle extends Shape {
        private double width, height;
        public Rectangle(Point topLeft, double width, double height) {
            super(topLeft);
            this.width = width;
            this.height = height;
        }
        @Override
        public Point getCenter() {
            Point topLeft = getPoint();
            Point center = new Point(topLeft.getX() + width/2, topLeft.getY() + height/2);
            return center;
        }
    }

    public static class Line extends Shape {
        Point to;
        public Line(Point from, Point to) {
            super(from);
            this.to = to;
        }
        @Override
        public Point getCenter() {
            Point from = getPoint();
            Point center = new Point((from.getX() + to.getX()) / 2, (from.getY() + to.getY()) /2 );
            return center;
        }
        @Override
        public void moveBy(double dx, double dy) {
            super.moveBy(dx, dy);
            to.setX(to.getX() + dx);
            to.setY(to.getY() + dy);
        }
    }

    public static void main(String[] args) {
        Circle c = new Circle(new Point(2,3), 10);
        System.out.println("Circle center: " + c.getCenter());
        Rectangle r = new Rectangle(new Point(3,4), 10, 20);
        System.out.println("Rectangle center: " + r.getCenter());
        Line l = new Line(new Point(2,3), new Point(6, 7));
        System.out.println("Line center: " + l.getCenter());
    }
}
