package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket srv = new ServerSocket(8189);
        Socket socket =srv.accept();
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        while (socket.isConnected()) {
            String message = in.readUTF();
            if (message.equals("q")) {
                break;
            }
            out.writeUTF(message);
            out.flush();
        }
    }
}
