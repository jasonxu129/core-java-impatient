package ch9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Ch9_14 {
    public static class Point implements Serializable {
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

    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(1,3),
                new Point(2.2, 5.5),
                new Point(10, 12.5)};


        Path path = Paths.get("points.out");
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
                out.writeObject(points);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
                Point[] readPoints = (Point[])in.readObject();
                System.out.println(Arrays.toString(readPoints));
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
