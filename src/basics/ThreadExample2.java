package basics;

public class ThreadExample2 {
    /**
     * Implementing Runnable interface
     */
    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread running");
            System.out.println("MyThread finished");
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
