
class ChildThread implements Runnable {
    Thread T;

    ChildThread() {
        T = new Thread(this, "Child Thread");
        System.out.println("Instantiated Child Thread. Starting ....");
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

public class ThreadBasics {
    public static void main(String[] args) {
        System.out.println("In Main Thread ......");
        new ChildThread();
        System.out.println("Instantiated Parent/Main Thread. Starting ....");
        System.out.println("Running Parent/Main thread .....");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Main Thread : " + i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println(" Main interrupted :" + e);
        }
        System.out.println("Exiting Main thread .....");
    }
}
