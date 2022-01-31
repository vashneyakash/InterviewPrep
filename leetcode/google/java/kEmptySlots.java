package google.java;

import java.util.concurrent.atomic.AtomicInteger;

class kEmptySlots {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.compareAndSet(2, 5);
        System.out.println("Vlaue of atomicInteger : " + atomicInteger.get());
        atomicInteger.incrementAndGet();
    }
}