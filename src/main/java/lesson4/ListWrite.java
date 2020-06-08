package lesson4;

import java.util.ArrayList;

public class ListWrite {

    static ArrayList<Integer> list = new ArrayList<>();
    final static Object monitor = new Object();
    static int cnt = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            if (cnt == 0) {
                synchronized (monitor) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i + 1 + " added to list");
                        list.add(i + 1);
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    cnt++;
                    monitor.notifyAll();
                }
            }
        }).start();

        new Thread(() -> {
            if (cnt == 0) {
                System.out.println("!1!");
//                synchronized (monitor) {
//                    try {
//                        System.out.println("!2!");
//                        monitor.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
                synchronized (monitor) {
                    for (Integer el : list) {
                        System.out.print(el + " ");
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println();
            } else {
                synchronized (monitor) {
                    for (Integer el : list) {
                        System.out.print(el + " ");
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println();
            }
        }).start();
    }
}
