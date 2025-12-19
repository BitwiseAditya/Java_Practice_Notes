import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class UploadResult implements Callable<Boolean> {
    private String taskName;

    public UploadResult(String name) {
        taskName = name;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " (Start) " + taskName);
        // Code for uploading result: Dummy implementation
        Boolean retValue = null;
        try {
            Thread.sleep(2000);
            // code to Upload result
            // Set retValue to true
            retValue = Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // Set retValue to false
            retValue = Boolean.FALSE;
        }
        System.out.println(Thread.currentThread().getName() + " (End) " + taskName);
        return retValue;
    }
}

class CalllableandFuture {
    public static void main(String[] args) {
        ExecutorService exService = Executors.newSingleThreadExecutor();
        UploadResult uploadCallable = new UploadResult("Batch 1");
        Future<Boolean> future = exService.submit(uploadCallable);
        try {
            System.out.println("Upload completed: " + future.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        exService.shutdown();
    }
}
