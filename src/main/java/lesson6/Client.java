package lesson6;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    public void connect() throws IOException {
        socket = new Socket("localhost", 8189);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
//        while (true) {
//            String message = in.readUTF();
//            System.out.println(message);
//        }
    }

    public String sendMessage(String message, Callback callback) throws IOException {
        out.writeUTF(message);
        out.flush();
        return callback.postProcess();
    }

    public String readMessage() throws IOException {
        String message = in.readUTF();
        return message;
    }

    public String close(Callback callback) throws IOException {
        out.writeUTF("q");
        out.flush();
        in.close();
        out.close();
        socket.close();
        return callback.postProcess();
    }
}
