package lesson4;

import java.util.concurrent.*;

public class ExecutorsTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);

        Future<String> future = service.submit(() -> {
            System.out.println("executed!");
            return "OK";
        });
        System.out.println(future.get());
        Future<?> future1 = service.submit(()->{
            System.out.println("Runnable executed");
            //throw new RuntimeException("LOL");
        });
        //System.out.println(future1.get());
        System.out.println(1);
        System.out.println(3);
        System.out.println(4);
        service.shutdown();
    }
}
