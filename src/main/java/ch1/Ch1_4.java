package ch1;

public class Ch1_4 {
    public static void main(String[] args) {
        System.out.printf("Smallest positive double value: %g\n", Math.nextUp(0.0));
        System.out.printf("largest positive double value: %g\n", Math.nextUp(Double.POSITIVE_INFINITY));
    }
}
