//import java.util.*;
class ToBeCalled {
    public synchronized void call(String msg) {
        System.out.print("[ ");
        System.out.print(msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.print(" ]");
        System.out.println();
    }
}

class Caller implements Runnable {
    Thread T;
    ToBeCalled obj;
    String s;

    Caller(ToBeCalled ob, String s) {
        obj = ob;
        this.s = s;
        T = new Thread(this, "Thread 1");
        T.start();
    }

    public void run() {
        obj.call(s);
    }
}

public class SynchronizationByMethod {
    public static void main(String[] args) {
        ToBeCalled obj = new ToBeCalled();
        Caller obj1 = new Caller(obj, "Hello");
        Caller obj2 = new Caller(obj, "synchronized");
        Caller obj3 = new Caller(obj, "world");
        try {
            obj1.T.join();
            obj2.T.join();
            obj3.T.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Bye.");
    }
}
