package lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        Semaphore smp = new Semaphore(1);
        CyclicBarrier br = new CyclicBarrier(3);
        CountDownLatch cl = new CountDownLatch(3);

        new Thread(() -> {
            System.out.println("before s 1");
            try {
                smp.acquire();
                System.out.println("after s 1");
                smp.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            System.out.println("before s 2");
            try {
                smp.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after s 2");
        }).start();
    }
}
