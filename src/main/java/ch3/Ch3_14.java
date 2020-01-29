package ch3;

public class Ch3_14 {
    public static Runnable merge(Runnable[] runnables) {
        return () -> {
            for (Runnable r : runnables) {
                r.run();
            }
        };
    }

    public static void main(String[] args) {
        Runnable[] runnables = {
                () -> System.out.println("1"),
                () -> System.out.println("2"),
                () -> System.out.println("3"),
        };

        Runnable merged = merge(runnables);

        merged.run();
    }
}
