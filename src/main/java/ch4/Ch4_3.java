package ch4;

public class Ch4_3 {
    public static class Point {
        protected double  x;
        protected double  y;
        public Point(double x, double  y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class LabeledPoint extends Point {
        private String label;
        public LabeledPoint(double x, double  y, String label) {
            super(x,y);
            this.label = label;
        }
        @Override
        public String toString() {
            return this.getClass().getName() + "[" + x + ", y=" + y + ", label=" + label + "]";
        }
    }

    public static void main(String[] args) {
        Point p = new Point(3,4);
        LabeledPoint l = new LabeledPoint(2,3,"sky");
        System.out.println("LabeledPoint: " + l);
    }
}
