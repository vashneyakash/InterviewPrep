package javax.highlevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServices {
    private final static ExecutorService executorService = Executors.newFixedThreadPool(3);

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

    public static void main(String[] args) {
        executorService.shutdown();
    }
}
