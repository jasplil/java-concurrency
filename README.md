# java-concurrency
## Thread basics
![Basic](https://github.com/jasplil/java-concurrency/assets/39994190/702691b0-25c9-4a77-afec-574dea13fe03)
- Refer to ThreadExample.java, ThreadExample2.java, ThreadExample3.java
- join() method: wait for the thread to finish
- setDaemon() method: if a thread is a daemon thread, it will not prevent the JVM from exiting when the program finishes.

### Thread states
![Thread](https://media.geeksforgeeks.org/wp-content/uploads/20230620182419/Lifecycle-and-States-of-a-Thread-in-Java-768.png)
## Thread safety 
### Atomicity
- **Method 1** compound actions: sequences of operations that must be executed atomically in order to be thread-safe
- **Method 2** intrinsic locks (poor conurrency): synchronized keyword. Intrinsic locks are reentrant, which means at most one thread can hold the lock at any given time, and a thread can acquire the lock multiple times.
- **Method 3** Reentrancy: a thread can acquire the same lock multiple times. This is useful for encapsulation of critical sections.
