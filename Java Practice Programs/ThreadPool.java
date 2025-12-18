import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class UploadResult implements Runnable {
    private String taskName;

    public UploadResult(String name) {
        taskName = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) " + taskName);
        // Code for uploading result: Dummy implementation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " (End) " + taskName);
    }
}

class ThreadPool {
    public static void main(String[] args) {
        ExecutorService exServicePool = Executors.newFixedThreadPool(2); // Creating a thread Pool of size 2
        int noOfUploadTasks = 3; // Assuming we have 3 UploadResult task which needs to be processed
        for (int i = 1; i <= noOfUploadTasks; i++) {
            UploadResult uploadRunnable = new UploadResult("UploadResult:" + i);
            exServicePool.execute(uploadRunnable);
        }
        exServicePool.shutdown();
        while (!exServicePool.isTerminated()) {
        } // Checking if shutdown is complete
        System.out.println("Finished all threads");
    }
}
