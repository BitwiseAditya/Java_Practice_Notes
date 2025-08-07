//import java.util.*;

class Example implements Runnable {
    Thread t;
    boolean suspendThreadBool;

    Example(String s) {
        t = new Thread(this, s);
        suspendThreadBool = false;
        t.start();
        System.out.println("Starting " + Thread.currentThread().getName());
    }

    public void run() {
        try {
            int i = 0;
            for (; i < 500; i++) {
                System.out.println(t.getName() + " " + i + " ");
                Thread.sleep(500);
                synchronized (this) {
                    while (suspendThreadBool) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Exiting : " + Thread.currentThread().getName());
    }

    public synchronized void suspendThread() {
        suspendThreadBool = true;
    }

    public synchronized void resumeThread() {
        suspendThreadBool = false;
        notify();
    }
}

public class SuspendingResumingThreads {
    public static void main(String args[]) {
        Example obj1 = new Example("Thread 1");
        Example obj2 = new Example("Thread 2");
        try {
            Thread.sleep(4000);
            obj1.suspendThread();
            System.out.println("Suspended " + "Thread 1");
            Thread.sleep(4000);
            obj1.resumeThread();
            System.out.println("Resumed " + "Thread 1");
            Thread.sleep(4000);
            obj2.suspendThread();
            System.out.println("Suspended " + "Thread 2");
            Thread.sleep(4000);
            obj2.resumeThread();
            System.out.println("Resumed " + "Thread 2");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        try {
            obj1.t.join();
            obj2.t.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Exiting Main....");
    }
}
