package ch9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Ch9_15 {
    /*
    // Point Class used to serialize object to file
    public static class Point implements Serializable {
        private static final long serialVersionUID = 1L;
        private double x;
        private double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return String.format("Point{x: %4.2f, y: %4.2f}", x, y);
        }
    }
    */

    public static class Point implements Serializable {
        private static final long serialVersionUID = 1L;
        private double[] coords;
        public Point(double x, double y) {
            coords = new double[] {x, y};
        }
        public String toString() {
            return String.format("Point(x: %4.2f, y: %4.2f)", coords[0], coords[1]);
        }

        // Use readObject method to read field x and y from serialized object.
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            ObjectInputStream.GetField fields = in.readFields();
            double x = fields.get("x", 0.0);
            double y = fields.get("y", 0.0);
            coords = new double[]{x, y};
        }
    }


    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(2.2,5.2),
                new Point(3.3, 6.6),
                new Point(101, 99.0)};

        Path path = Paths.get("points-ex15.out");
        /*
        try (ObjectOutputStream writer = new ObjectOutputStream(Files.newOutputStream(path))) {
            writer.writeObject(points);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         */

        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
            Point[] readPoints = (Point[])in.readObject();
            System.out.println(readPoints);
            System.out.println(Arrays.toString(readPoints));
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
