import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadExample3 {
    public class MyCallable implements Callable<String> {
        public String call() {
            System.out.println("MyCallable running");
            System.out.println("MyCallable finished");
            return "MyCallable result";
        }
    }

    public void main(String[] args) {
        Callable<String> callable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
    }
}
