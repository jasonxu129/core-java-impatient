package ch4;

public class Ch4_1 {
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
    }

    public static class LabeledPoint extends Point {
        private String label;
        public LabeledPoint(int x, int y, String label) {
            super(x, y);
            this.label = label;
        }
        public String getLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        Point p = new Point(2, 3);
        System.out.printf("Point x=%f, y=%f\n", p.getX(), p.getY());
        LabeledPoint l = new LabeledPoint(3,4,"best");
        System.out.printf("LabeledPoint x=%f, y=%f, label=%s\n", l.getX(), l.getY(), l.getLabel());
    }
}
