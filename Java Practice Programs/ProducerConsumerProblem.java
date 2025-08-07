//import java.util.*;

class Q {
    int num;
    boolean flag;

    Q() {
        num = 0;
        flag = false;
    }

    public synchronized void put(int num) {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        flag = true;
        this.num = num;
        System.out.println("Produced : " + this.num);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        notify();
    }

    public synchronized void get() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        flag = false;
        System.out.println("Consumed : " + this.num);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        notify();
    }
}

class Producer implements Runnable {
    Thread T;
    Q q;

    Producer(Q obj) {
        q = obj;
        T = new Thread(this, "Producer");
        T.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.put(++i);
        }
    }
}

class Consumer implements Runnable {
    Thread T;
    Q q;

    Consumer(Q obj) {
        q = obj;
        T = new Thread(this, "Consumer");
        T.start();
    }

    public void run() {
        while (true) {
            q.get();
        }
    }
}

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Q obj = new Q();
        Producer p = new Producer(obj);
        Consumer c = new Consumer(obj);
    }
}
