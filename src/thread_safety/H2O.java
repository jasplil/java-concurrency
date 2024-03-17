package thread_safety;

/**
 * 1117. Building H2O
 */
class H2O {
    public static int hCount;

    public H2O() {
        this.hCount = 0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized(this) {
            while (hCount == 2) {
                wait(); // waits for o
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            hCount++;
            notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized(this) {
            while (hCount < 2) {
                wait(); // wait for 2 h joins
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            hCount = 0;
            notify();
        }
    }
}
