package loneDruid;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public interface CSIO {
    public static void dataIn(int port) {
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("正在用" + port + "端口监听");
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            DataInputStream ois = new DataInputStream(is);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            while (true) {
                System.out.println("收到信息:");
                System.out.println(ois.readUTF());
                System.out.println("发送信息❤️:");
                Scanner sc = new Scanner(System.in);
                dos.writeUTF(sc.next());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void dataOut(int port) {
        try {
            Socket s = new Socket("127.0.0.1", port);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while(true) {
                System.out.println("发送文字");
                Scanner sc = new Scanner(System.in);
                dos.writeUTF(sc.next());
                System.out.println("收到信息💻");
                System.out.println(dis.readUTF());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
