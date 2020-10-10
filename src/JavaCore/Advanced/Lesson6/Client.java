package JavaCore.Advanced.Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static final String IP_ADDRESS = "localhost";
    static final int PORT = 8189;
    static Socket socket;
    static DataInputStream in;
    static DataOutputStream out;
    static Scanner sc = new Scanner(System.in);
    static ConnectionHandler c;

    public static void main(String[] args) {

        try {
            socket = new Socket(IP_ADDRESS, PORT);
            c = new ConnectionHandler(socket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
