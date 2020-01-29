package ch3;

public class Ch3_9 {
    public static class Greeter implements Runnable {
        private int n;
        private String target;

        public Greeter(int n, String target) {
            this.n = n;
            this.target = target;
        }

        public void run() {
            for (int i = 0; i < n; i++) {
                System.out.println("Hello " + target);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Greeter(10, "Jason"));
        Thread t2 = new Thread(new Greeter(5, "Jordan"));
        t1.start();
        t2.start();
    }
}
