package JavaCore.Advanced.Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConnectionHandler {
    DataInputStream in;
    DataOutputStream out;
    Socket socket;
    Scanner sc;

    public ConnectionHandler(Socket socket) {
        try {
            this.socket = socket;
            sc = new Scanner(System.in);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connected " + socket.getRemoteSocketAddress());
            AtomicBoolean endFlag = new AtomicBoolean(false);

            Thread inHandler = new Thread(() -> {
                try {
                    while (true) {
                        while (true) {
                            if (endFlag.get()) {
                                return;
                            }
                            if (in.available() > 0) {
                                break;
                            }
                        }
                        String str = in.readUTF();
                        System.out.println("Received: " + str);
                        if (str.equals("/end")) {
                            endFlag.set(true);
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Thread outHandler = new Thread(() -> {
                while (true) {
                    try {
                        if (endFlag.get()) {
                            return;
                        }
                        String message = sc.nextLine();
                        out.writeUTF(message);
                        if (message.equals("/end")) {
                            endFlag.set(true);
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            inHandler.start();
            outHandler.start();
            inHandler.join();
            outHandler.join();

            try {
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException |
                InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
