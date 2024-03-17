package thread_safety;

public class GuardedExp {
    private Object guardedObject;

    public Object getGuardedObject() throws InterruptedException {
        synchronized (this) {
            while (guardedObject == null) {
                this.wait();
            }
            return guardedObject;
        }
    }

    // This method is called by another thread to create the guarded object
    public void complete(Object obj) {
        synchronized (this) {
            guardedObject = obj;
            this.notifyAll();
        }
    }
}
