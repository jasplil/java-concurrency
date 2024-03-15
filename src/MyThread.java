import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
    private int ticket = 0;
    static Lock lock = new ReentrantLock();

    public void run() {
        while (true)  {
            lock.lock();

            try {
                if (ticket < 100) {
                    System.out.println(Thread.currentThread().getName() + " is selling ticket " + ticket++);
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("Window 1");
        t2.setName("Window 2");

        t1.start();
        t2.start();
    }
}
