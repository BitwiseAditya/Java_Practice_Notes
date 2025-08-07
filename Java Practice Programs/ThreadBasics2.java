
class ChildThread implements Runnable {
    Thread T;

    ChildThread(String s) {
        T = new Thread(this, s);
        System.out.println("Instantiated Child Thread - " + s + " . Starting ....");
        T.start();
    }

    public void run() {
        try {
            System.out.println("Running child thread .....");
            for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread : " + i);
                Thread.sleep(700);
            }
        } catch (InterruptedException e) {
            System.out.println("Exception caught : " + e);
        }
        System.out.println("Exiting child thread .....");
    }
}

public class ThreadBasics2 {
    public static void main(String[] args) {
        System.out.println("In Main Thread ......");
        ChildThread c1 = new ChildThread("thread 1");
        ChildThread c2 = new ChildThread("thread 2");
        ChildThread c3 = new ChildThread("thread 3");
        System.out.println("Is thread 1 alive : " + c1.T.isAlive());
        System.out.println("Is thread 2 alive : " + c2.T.isAlive());
        System.out.println("Is thread 3 alive : " + c3.T.isAlive());
        System.out.println("Waiting for the three threads to finish....");
        try {
            c1.T.join();
            c2.T.join();
            c3.T.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Wait Ended");
        System.out.println("Is thread 1 now alive : " + c1.T.isAlive());
        System.out.println("Is thread 2 now alive : " + c2.T.isAlive());
        System.out.println("Is thread 3 now alive : " + c3.T.isAlive());
        System.out.println("Main Thread exiting, byeee .......");
    }
}
