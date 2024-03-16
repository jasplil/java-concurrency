# Java Concurrency 
## Thread basics
![Basic](https://github.com/jasplil/java-concurrency/assets/39994190/702691b0-25c9-4a77-afec-574dea13fe03)
- Refer to basics.ThreadExample.java, basics.ThreadExample2.java, basics.ThreadExample3.java
- join() method: wait for the thread to finish
- setDaemon() method: if a thread is a daemon thread, it will not prevent the JVM from exiting when the program finishes.

### Thread states
![Thread](https://media.geeksforgeeks.org/wp-content/uploads/20230620182419/Lifecycle-and-States-of-a-Thread-in-Java-768.png)
## Sharing Objects
### Thread safety
Race condition: when two or more threads access a shared resource and at least one of the threads tries to modify it.
![Safety](https://github.com/jasplil/java-concurrency/assets/39994190/919d2f90-f485-4cc9-9784-4c562c7a190f)

**How to prevent race conditions**:

synchonized method
```
synchronized(Object) // Thread 1, Thread 2 (blocked)
{
    // Critical section
}
```
**Are these thread safe?**
- local variables: yes
- instance variables: no
- String, Integer, Vector, Hashtable, StringBuffer, juc: yes
