package loneDruid;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Thread {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            Socket s = ss.accept();
            SendThread sendThread = new SendThread(s);
            RecieveThread recieveThread = new RecieveThread(s);
            new Thread(sendThread).start();
            new Thread(recieveThread).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
