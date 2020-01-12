package ch1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ch1_14 {
    public static void main(String[] args) {
        List<List<Integer>> square = new ArrayList<>();
        System.out.println("input square:");
        Scanner in = new Scanner(System.in);
        for (String line = in.nextLine(); !line.isEmpty(); line = in.nextLine()) {
            String[] tokens = line.split(" ");
            ArrayList<Integer> row = new ArrayList<>();
            for (String token : tokens) {
                row.add(Integer.parseInt(token));
            }
            square.add(row);
        }
        System.out.printf("Is magic square? : %b", isMagicSquare(square));
    }

    private static boolean isMagicSquare(List<List<Integer>> square) {
        if (square == null || square.size() == 0 || square.size() != square.get(0).size()) {
            return false;
        }
        int length = square.size();

        int sum = 0;
        for (int v : square.get(0)) {
            sum += v;
        }

        // test lines
        for (int row = 0; row < length; row++) {
            int rowSum = 0;
            for (int v : square.get(row)) {
                rowSum += v;
            }
            if (rowSum != sum) {
                return false;
            }
        }
        // test columns.
        for (int col = 0; col < length; col++) {
            int colSum = 0;
            for (int row = 0; row < length; row++) {
                colSum += square.get(row).get(col);
            }
            if (colSum != sum) {
                return false;
            }
        }
        // test diagonals
        int diagSumLR = 0;
        int diagSumRL = 0;
        for (int i = 0; i < length; i++) {
            diagSumLR += square.get(i).get(i);
            diagSumRL += square.get(i).get(length - i - 1);
        }
        if (diagSumLR != sum || diagSumLR != sum) {
            return false;
        }

        return true;
    }
}
