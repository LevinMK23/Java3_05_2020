package lesson6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Example2 {

    private final static Logger log = LoggerFactory.getLogger(Example2.class);

    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.connect();
        client.sendMessage("message", () -> {
            System.out.println("Send OK");
            return "message";
        });
        String message = client.readMessage();
        System.out.println(message);
        client.close(() -> {
            System.out.println("Socket closed!");
            return "message";
        });
    }
}
