import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

class UploadResultWithLock implements Runnable {
    private ReentrantLock lock;
    private int resultCount;

    public UploadResultWithLock(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) - Results uploaded: " + resultCount);
        // Code for uploading result: Dummy implementation
        try {
            lock.lock();
            Thread.sleep(2000);
            resultCount++;
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + " (End) - Results Uploaded: " + resultCount);
    }
}

class Lock {
    public static void main(String[] args) {
        ExecutorService exServicePool = Executors.newFixedThreadPool(2); // Creating a thread Pool of size 2
        int noOfUploadsTask = 3; // Assuming we have 3 UploadResult tasks which need to be processed
        ReentrantLock lock = new ReentrantLock(); // The lock to be used
        UploadResultWithLock uploadRunnable = new UploadResultWithLock(lock);
        for (int i = 1; i <= noOfUploadsTask; i++) {
            exServicePool.execute(uploadRunnable);
        }
        exServicePool.shutdown();
        while (!exServicePool.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
