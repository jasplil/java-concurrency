package thread_safety;

import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers extends Thread {
    private fork left, right;

    public DiningPhilosophers(fork left, fork right, String name) {
        super(name);
        this.left = left;
        this.right = right;
    }

    public void run() {
        while (true) {
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
                    left.unlock();
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