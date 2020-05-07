package ch2;

public class Ch2_4 {
    public static void main(String[] args) {
        IntHolder a = new IntHolder(3);
        IntHolder b = new IntHolder(6);
        System.out.println("Value of IntHolder a & b: " + a.value + " " + b.value);
        swap(a, b);
        System.out.println("Value of IntHolder a & b: " + a.value + " " + b.value);

        int ia = 5;
        int ib = 10;
        System.out.printf("Value of int a & b: %d, %d\n", ia, ib);
        cantSwap(ia, ib);
        System.out.printf("Value of int a & b: %d, %d\n", ia, ib);
    }

    public static class IntHolder {
        public IntHolder(int value) {
            this.value = value;
        }

        int value;
    }

    public static void swap(IntHolder a, IntHolder b) {
        int tmp = a.value;
        a.value = b.value;
        b.value = tmp;
    }

    public static void cantSwap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
}
