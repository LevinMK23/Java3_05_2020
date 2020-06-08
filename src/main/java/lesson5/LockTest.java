package lesson5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    static volatile int cnt = 0;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    cnt++;
                    System.out.println("thread 1 mute cnt, cnt = " + cnt);
                    if (cnt == 10) {
                        cnt = 0;
                        lock.unlock();
                        new Thread(() -> {
                            System.out.println("start hard calc 1");
                            int k = 3;
                            for (int i = 0; i < 10000; i++) {
                                k = (k * i + k) / (k * k - 2 * i) + k;
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("finish hard calc 1");
                        }).start();


                    } else {
                        lock.unlock();
                    }
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    cnt++;
                    System.out.println("thread 2 mute cnt, cnt = " + cnt);
                    if (cnt == 10) {
                        cnt = 0;
                        lock.unlock();

                        new Thread(() -> {
                            System.out.println("start hard calc 2");
                            int k = 3;
                            for (int i = 0; i < 10000; i++) {
                                k = (k * i + k) / (k * k - 2 * i) + k;
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("finish hard calc 2");
                        }).start();

                    } else {
                        lock.unlock();
                    }
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(10000);
        System.out.println(new Thread().getName());
    }
}
