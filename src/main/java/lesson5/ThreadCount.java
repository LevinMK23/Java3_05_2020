package lesson5;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadCount {

    ConcurrentLinkedDeque<AtomicLong> deque;

    public static void main(String[] args) {
        AtomicLong al = new AtomicLong(0);

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            System.out.println(Thread.activeCount());
        }
    }
}
