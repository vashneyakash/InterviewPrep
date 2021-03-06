package javax.highlevel;

import java.util.Random;
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

    public static Integer calPrime() {
        return new Random().nextInt(50);
    }

    public static void main(String[] args) {
        executorService.shutdown();
        Future<?> future1 = executorService.submit(new Task());
        Future<Integer> future2 = executorService.submit(new Task1());
        Future<Integer> future3 = executorService.submit(ExecutorServices::calPrime);
        executorService.execute(new Task());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Task(), 1, 1, TimeUnit.DAYS);
        scheduledExecutorService.scheduleAtFixedRate(new Task(), 1, 1, TimeUnit.DAYS);
        ScheduledFuture<Integer> scheduledFuture1 = scheduledExecutorService.schedule(new Task1(), 1, TimeUnit.DAYS);
    }
}
