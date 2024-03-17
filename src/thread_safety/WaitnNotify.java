package thread_safety;

public class WaitnNotify {
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();

        // main thread holds the lock
        synchronized (lock) // main thread can be executed after t1 and t2 are waiting
        {
            lock.notifyAll(); // notify all threads waiting for lock
        }
    }
}
