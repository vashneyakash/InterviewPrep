package javax.highlevel;

import java.util.concurrent.*;

public class ExecutorServices {
    private final static ExecutorService executorService = Executors.newFixedThreadPool(3);
    private final static ExecutorService executorService1 = Executors.newCachedThreadPool();
    private final static ExecutorService executorService2 = Executors.newSingleThreadExecutor();
    private final static ExecutorService executorService3 = Executors.newScheduledThreadPool(4);

    public static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException : " + e);
            }
        }
    }

    public static class Task1 implements Callable<Integer> {
        @Override
        public Integer call() {
            return 0;
        }
    }

    public static void main(String[] args) {
        executorService.shutdown();

        executorService.submit(new Task());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(new Task(), 1, 1 ,TimeUnit.DAYS);
    }
}
