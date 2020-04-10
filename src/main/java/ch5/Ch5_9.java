package ch5;

import java.util.concurrent.locks.ReentrantLock;

public class Ch5_9 {
    public static AutoCloseableReentrantLock lock() {
        AutoCloseableReentrantLock rlock = new AutoCloseableReentrantLock();
        rlock.lock();
        return rlock;
    }

    public static class AutoCloseableReentrantLock extends ReentrantLock implements AutoCloseable {
        @Override
        public void close() {
            try {
                this.unlock();
            } catch (IllegalMonitorStateException ex) {
                System.err.println("RLock unlock exception: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        try (AutoCloseableReentrantLock l = lock()) {
            System.out.println("Hello Reentrant lock in try-with-resources statement!");
        }
    }
}
