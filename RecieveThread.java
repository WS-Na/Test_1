package loneDruid;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class RecieveThread implements Runnable{

    private Socket s ;
    public RecieveThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            Scanner scanner =new Scanner(System.in);
            while (true) {
                System.out.println("recieve message");
                String msg = dis.readUTF();
                System.out.println(msg);
                System.out.println(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
