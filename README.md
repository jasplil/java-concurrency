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

synchronized method
```
synchronized(Object) // Thread 1, Thread 2 (blocked)
{
    // Critical section
}
```
**Are these thread safe?**
- local variables: yes
- instance variables: no
- String, Integer, Vector, Hashtable, StringBuffer, juc (java.until.concurrency): yes
### Monitor 
**Ordinary objects**
![OOp](https://github.com/jasplil/java-concurrency/assets/39994190/75d7c44e-43c1-4410-9678-7b459c7f7d69)
**Mark word**
![Mark word](https://github.com/jasplil/java-concurrency/assets/39994190/9b9a3472-ba87-4f74-a9d0-d12067f9ef26)
**Monitor**
![Monitor](https://github.com/jasplil/java-concurrency/assets/39994190/2de1f28f-1d0f-41e6-baae-676ab1a8b20d)
When a new thread enters a synchronized block, it acquires the lock and the monitor is associated with the thread. When the thread exits the block, the lock is released and the monitor is disassociated with the thread.

EntryList: a list of threads that are waiting to acquire the lock

After a thread releases the lock, it notifies the next thread in the EntryList to acquire the lock.

### wait() and notify()
![waitandnotify](https://github.com/jasplil/java-concurrency/assets/39994190/9219d856-4ef3-4779-8bc1-3fa14b764671)
```
synchronized(Object)
{
    while(condition)
    {
        Object.wait();
    }
    // Critical section
    Object.notify();
}
```
### wait() vs sleep()
- wait() is a method of Object class, sleep() is a method of Thread class
- wait() releases the lock, sleep() doesn't
### Guarded suspension
One thread is waiting for a condition to be true, and another thread is responsible for making that condition true.
![Guarded](https://github.com/jasplil/java-concurrency/assets/39994190/995aeea8-02d4-4933-87d9-34245e22a4c4)
### Message queue
![Message](https://github.com/jasplil/java-concurrency/assets/39994190/c32a8e2d-0b53-4bdd-a518-ffd647af75c7)
### Deadlock - Dining Philosophers
LeetCode 1226. The Dining Philosophers
### ReentrantLock
- It can be interrupted, unlike synchronized method
- Can be used as a fair lock
- Can be used to try to acquire a lock