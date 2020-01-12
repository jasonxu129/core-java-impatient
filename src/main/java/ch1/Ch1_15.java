package ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ch1_15 {
    public static void main(String[] args) {
        System.out.println("Input n:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> triangle = getPascalTriangle(n);
        System.out.println(triangle);
    }

    private static ArrayList<ArrayList<Integer>> getPascalTriangle(int n) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>(Arrays.asList(1));
        triangle.add(row);

        for (int i = 1; i < n; i++) {
            ArrayList<Integer> prev = triangle.get(i-1);
            ArrayList<Integer> next = new ArrayList<>();
            next.add(1);
            for (int j = 1; j < prev.size(); j++) {
                next.add(prev.get(j-1) + prev.get(j));
            }
            next.add(1);
            triangle.add(next);
        }
        return triangle;
    }
}
