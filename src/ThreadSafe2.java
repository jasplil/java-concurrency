public class ThreadSafe2 {
    public class MyRunnable implements Runnable {
        private int ticket = 0;

        public void run() {
            while (true)  {
                synchronized(this) {
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
        ThreadSafe2 ts = new ThreadSafe2();
        MyRunnable myRunnable = ts.new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        t1.setName("Window 1");
        t2.setName("Window 2");

        t1.start();
        t2.start();
    }
}
