package ch2;

public class Ch2_5 {
    public static void main(String[] args) {
        Point p = new Point(3,4).translate(1, 3).scale(0.5);
        System.out.println(p);
    }

    /**
     * Point class describes a point in the plane.
     */
    private static class Point {
        /**
         * Member variables represent coordinates.
         */
        private final double x, y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(double x, double y) {
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
         * A function moves the Point along give direction.
         * @param dx value for move along x direction
         * @param dy value for move along y direction
         * @return new Point
         */
        public Point translate(double dx, double dy) {
            return new Point(this.x + dx, this.y + dy);
        }

        /**
         * Scale both coordinates by a given factor.
         * @param s scaling factor
         * @return new Point after scaling.
         */
        public Point scale(double s) {
            return new Point(x * s, y * s);
        }

        public String toString() {
            return String.format("Point (%f, %f)", x, y);
        }
    }
}
