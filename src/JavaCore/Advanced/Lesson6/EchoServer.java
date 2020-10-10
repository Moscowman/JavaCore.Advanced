package JavaCore.Advanced.Lesson6;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    static ConnectionHandler c;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        final int PORT = 8189;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");

            socket = server.accept();
            c = new ConnectionHandler(socket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
