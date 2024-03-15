public class ThreadSafe {
    public static class MyThread extends Thread {
        static int ticket = 0; // 0-99
        static String name = "ticket";
        static Object lock = new Object();

        public void run() {
            while (true) {
                synchronized (lock) {
                    if (ticket < 100) {
                        System.out.println(Thread.currentThread().getName() + " is selling ticket " + ticket++);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.setName("Window 1");
        t2.setName("Window 2");
        t3.setName("Window 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
