package basics;

public class DeadlockExp {
    Object lock1 = new Object();
    Object lock2 = new Object();

    Thread t1 = new Thread(() -> {
        synchronized (lock1) {
            System.out.println("Thread 1: Holding lock 1...");
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
            }
            System.out.println("Thread 1: Waiting for lock 2...");
            synchronized (lock2) {
                System.out.println("Thread 1: Holding lock 1 & 2...");
            }
        }
    }, "t1");

    Thread t2 = new Thread(() -> {
        synchronized (lock2) {
            System.out.println("Thread 2: Holding lock 2...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            System.out.println("Thread 2: Waiting for lock 1...");
            synchronized (lock1) {
                System.out.println("Thread 2: Holding lock 1 & 2...");
            }
        }
    }, "t2");

    public static void main(String[] args) {
        DeadlockExp deadlockExp = new DeadlockExp();
        deadlockExp.t1.start();
        deadlockExp.t2.start();
    }
}
