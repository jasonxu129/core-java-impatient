package ch1;

public class Ch1_9 {
    public static void main(String[] args) {
        String a = "World";
        System.out.printf("comparision with a is %b\n", "World" == a);

        String b = new String("W") + "orld";
        System.out.printf("comparision with b is %b\n", "World" == b);
    }
}
