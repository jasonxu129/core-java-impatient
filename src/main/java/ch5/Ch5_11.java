package ch5;

public class Ch5_11 {
    public static long factorial(long n) {
        if (n < 2) {
            Exception ex = new Exception("exception object");
            ex.printStackTrace(System.out);
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        long res = factorial(6);
        System.out.println(res);
    }
}
