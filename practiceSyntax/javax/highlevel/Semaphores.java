package javax.highlevel;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Semaphores {

    public static Semaphore semaphore = new Semaphore(3);

    public static class Task implements Runnable {
        private final Integer taskId;
        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Starting task " + Thread.currentThread().getId());
            try {
                semaphore.acquire();
                semaphore.tryAcquire();
                semaphore.tryAcquire(1, TimeUnit.DAYS);
//                semaphore.drainPermits()
                System.out.println("Processed task " + taskId + " : threadId : " + Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
            System.out.println("Ending task " + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(1, 100).forEach(i -> executorService.submit(new Task(i)));
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
    }
}
