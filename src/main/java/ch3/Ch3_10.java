package ch3;

public class Ch3_10 {
    public static void runTogether(Runnable... tasks) {
        for (Runnable task : tasks) {
            Thread t = new Thread(task);
            t.start();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        for (Runnable task : tasks) {
            task.run();
        }
    }

    public static void main(String[] args) {
        Runnable t1 = () -> { for (int i = 0; i < 2000; i++) {
            System.out.println("Hello");
        }};

        Runnable t2 = () -> { for (int i = 0; i < 200; i++) {
            System.out.println("Hi there");
        }};

        runTogether(t1, t2);

        runInOrder(t1, t2);
    }
}
