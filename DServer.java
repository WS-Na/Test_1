package loneDruid;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

public class DServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6789) ;
            System.out.println(ss);
            System.out.println( "监听端口中");
            InputStream is = ss.accept().getInputStream();
            DataInputStream dis = new DataInputStream(is);
            String msg = dis.readUTF();
            System.out.println(msg);
            dis.close();
            is.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
