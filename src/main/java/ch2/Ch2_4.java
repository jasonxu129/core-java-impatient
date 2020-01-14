package ch2;

import org.omg.CORBA.IntHolder;

public class Ch2_4 {
    public static void main(String[] args) {
        IntHolder a = new IntHolder(3);
        IntHolder b = new IntHolder(6);
        System.out.println("Value of IntHolder a & b: " + a.value + " " + b.value);
        swap(a, b);
        System.out.println("Value of IntHolder a & b: " + a.value + " " + b.value);
    }

    public static void swap(IntHolder a, IntHolder b) {
        int tmp = a.value;
        a.value = b.value;
        b.value = tmp;
    }
}
