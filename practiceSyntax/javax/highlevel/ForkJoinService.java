package javax.highlevel;

import java.util.concurrent.*;

public class ForkJoinService extends RecursiveTask<Integer> {

    final int n;
    public ForkJoinService(int n) {
        this.n = n;
    }

    @Override
    public Integer compute() {
        if (n <= 1) return n;

        ForkJoinService f1 = new ForkJoinService(n -1);
        ForkJoinService f2 = new ForkJoinService(n -2);
        f1.fork();
        f2.fork();
        int x = f1.join() + f2.join();
        System.out.println(n + " : " + x);
        return x;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> result = forkJoinPool.submit(new ForkJoinService(10));
        System.out.println("Result of fib 10 : " + result.join());
    }
}
