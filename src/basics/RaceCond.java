package basics;

public class RaceCond {
    private static int counter = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> incrementCounter());
        Thread thread2 = new Thread(() -> incrementCounter());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + counter);
    }

    /**
     * Both threads read counter as 1000.
     * Both increment it to 1001.
     * Both write 1001 back to counter.
     */
    private static void incrementCounter() {
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
    }
}
