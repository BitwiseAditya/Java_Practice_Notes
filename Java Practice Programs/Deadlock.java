// Example to illustrate Deadlock among threads.
class A {
    public synchronized void f1(B obj) {
        String s = Thread.currentThread().getName();
        System.out.println(s + " accessing class A's synchronized method.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(s + " trying to access B's synchronized method.....");
        obj.view();
    }

    synchronized void view() {
        System.out.println("In A's view..");
    }
}

class B {
    public synchronized void f2(A obj) {
        String s = Thread.currentThread().getName();
        System.out.println(s + " accessing class B's synchronized method.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(s + " trying to access A's synchronized method.....");
        obj.view();
    }

    synchronized void view() {
        System.out.println("In B's view..");
    }
}

class Helper implements Runnable {
    A obj1;
    B obj2;

    Helper() {
        obj1 = new A();
        obj2 = new B();
        Thread.currentThread().setName("Thread No. 1");
        Thread T = new Thread(this, "Thread No. 2");
        T.start();
        obj1.f1(obj2);
        System.out.println("Running " + Thread.currentThread().getName());
    }

    public void run() {
        obj2.f2(obj1);
        System.out.println("Running " + Thread.currentThread().getName());
    }
}

class Deadlock {
    public static void main(String args[]) {
        new Helper();
    }
}
