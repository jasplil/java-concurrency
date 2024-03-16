package basics; /**
 * Using exiositng thread-safe classes to manage state
 */

import java.util.concurrent.atomic.AtomicLong;

public class CountingFactorizer {
    private AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }

    public void service() {
        count.incrementAndGet();
        // do something
    }
}
