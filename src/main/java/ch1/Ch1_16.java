package ch1;

public class Ch1_16 {
    public static void main(String[] args) {
        double res1 = average(1.0, 2.0, 3.4, 5.5);
        double res2 = averageAtLeastOne(1.0, 2.0, 3.0, 4.0);
        System.out.printf("Average is %f , %f" , res1, res2);
    }

    // Declaring a "varargs" parameter with ... after the type.
    // The parameter is actually an array of type double. When the method is called, an
    // array is created and filled with the arguments. In the method body, you use it as
    // you would any other array.
    public static double average(double... values) {
        double sum = 0;
        for (double v : values) {
            sum += v;
        }
        return values.length == 0 ? 0 : sum / values.length;
    }

    public static double averageAtLeastOne(double first, double... rest) {
        double sum = first;
        for (double v: rest) {
            sum += v;
        }
        return sum / (1 + rest.length);
    }
}
