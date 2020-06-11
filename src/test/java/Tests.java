import lesson6.ArrayHelper;
import lesson6.Client;
import lesson6.Server;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

//@RunWith(Parameterized.class)
public class Tests {

    //    @Parameterized.Parameters
//    public static Integer[][] generate() {
//        return new Integer[][]
//                {{1, 2, 3},
//                {2, 2, 4}};
//    }

    //static Server srv;

//    static {
//        CountDownLatch cl = new CountDownLatch(1);
//        new Thread(() -> {
//
//            try {
//                srv = new Server();
//                System.out.println("SERVER STARTED");
//                cl.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//    }

    @Test
    public void clientTest() {
        try {
            Client client = new Client();
            Thread.sleep(2000);
            System.out.println("BEFORE");
            client.connect();
            client.sendMessage("message1", () -> "message");
            String message = client.readMessage();
            Assert.assertEquals("message1", message);
            System.out.println(message);
            client.close(() -> "null");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void foo() {
        ArrayHelper helper = new ArrayHelper();
        //Assert.assertEquals(a + b, helper.getParam());
    }

    @Test(expected = ArithmeticException.class)
    public void errorTest() {
        System.out.println(1 / 0);
    }

    @Test(timeout = 100)
    public void timeTest() {
        int a = 7;
        for (int i = 0; i < 1000; i++) {
            a = a * 2 + a;
        }
    }
}
