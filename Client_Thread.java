package loneDruid;

import java.io.IOException;
import java.net.Socket;

public class Client_Thread {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",8888);
            SendThread sendThread = new SendThread(s);
            RecieveThread recieveThread = new RecieveThread(s);
            new Thread(sendThread).start();
            new Thread(recieveThread).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
