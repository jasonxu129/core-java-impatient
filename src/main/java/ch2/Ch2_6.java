package ch2;

public class Ch2_6 {
    /**
     * A point represents a point in the plane.
     */
    private static class Point {
        private double x, y;
        Point() {
            x = 0;
            y = 0;
        }

        // Cmd + N to generate methods (constructor, setter and getter...)
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

        /**
         * Moves the point along given direction.
         * @param dx move distance along x direction.
         * @param dy move distance along y direction.
         */
        public void translate(double dx, double dy) {
            x += dx;
            y += dy;
        }

        /**
         * Scale both coordinates with a given factor.
         * @param s scaling factor
         */
        public void scale(double s) {
            x *= s;
            y *= s;
        }
        public String toString() {
            return String.format("Point (%2.2f, %2.2f)", x, y);
        }
    }

    public static void main(String[] args) {
        Point p = new Point(3,4);
        p.translate(1,3);
        p.scale(0.5);
        System.out.println(p);
    }
}
