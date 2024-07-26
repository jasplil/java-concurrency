package thread_safety;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

public class DiningPhilosophers extends Thread {
    public static void main(String[] args) {
        fork[] forks = new fork[5];
        philosophers[] philosophers = new philosophers[5];

        for (int i = 0; i < 5; i++) {
            forks[i] = new fork("fork " + i);
        }

        for (int i = 0; i < 5; i++) {
            philosophers[i] = new philosophers(forks[i], forks[(i + 1) % 5], "philosopher " + i);
            philosophers[i].start();
        }
    }
}

class philosophers extends Thread {
    private fork left, right;

    public philosophers(fork left, fork right, String name) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            // If you can't get right fork, release left fork
            if (left.tryLock()) {
                try {
                    if (right.tryLock()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " is eating");
                        } finally {
                            right.unlock();
                        }
                    }
                } finally {
                    left.unlock(); // release left fork
                }
            }
        }
    }
}

class fork extends ReentrantLock {
    String name;

    public fork(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}