package thread_safety;

public class BasicSyn {
    static int count = 0;

    static class Room {
        private int count = 0;
        public void enter() {
            synchronized (this) {
                count++;
            }
        }
        public void leave() {
            synchronized (this) {
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                room.enter();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                room.leave();
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // correct answer should be 0
        System.out.println(room.getCount());
    }
}
