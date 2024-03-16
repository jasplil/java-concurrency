import java.util.*;

public class ExcerciseTransfer {
    class TicketWindow {
        private int count;

        public TicketWindow(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public int sell(int amount) {
            if (count >= amount) {
                count -= amount;
                return amount;
            } else {
                return 0;
            }
        }
    }

    public void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow(10000);
        List<Integer> sold = new Vector<>();
        List<Thread> threadList = new ArrayList<>();

       for (int i = 0; i < 2000; i++) {
           Thread thread = new Thread(() -> {
               int count = ticketWindow.sell(100);
               sold.add(count);
           });

           threadList.add(thread);
           thread.start();
       }

       // Calculate the total number of tickets sold and the remaining number of tickets
       System.out.println(ticketWindow.getCount());
       System.out.println(sold.stream().mapToInt(i -> i).sum());
    }
}
