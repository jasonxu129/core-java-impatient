package ch1;

public class Ch1_5 {
    public static void main(String[] args) {
        System.out.printf("Max integer %d\n", Integer.MAX_VALUE);
        double d = Math.pow(10, 12);
        // ^ is not exponential operator, it's xor
        System.out.printf("Our double value: %g\n", d);
        int casted = (int) d;
        System.out.printf("Casted integer: %d", casted);
    }
}
