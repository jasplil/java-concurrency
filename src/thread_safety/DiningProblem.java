package thread_safety;

public class DiningProblem {
    public static void main(String[] args) {
        chopstick[] chopsticks = new chopstick[5];
        philosopher[] philosophers = new philosopher[5];

        for (int i = 0; i < 5; i++) {
            chopsticks[i] = new chopstick("chopstick " + i);
        }

        for (int i = 0; i < 5; i++) {
            philosophers[i] = new philosopher(chopsticks[i], chopsticks[(i + 1) % 5], "philosopher " + i);
            philosophers[i].start();
        }
    }
}

class philosopher extends Thread {
    private chopstick left, right;

    public philosopher(chopstick left, chopstick right, String name) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (left) {
                synchronized (right) {
                    System.out.println(Thread.currentThread().getName() + " is eating");
                }
            }
        }
    }
}

class chopstick {
    String name;

    public chopstick(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}