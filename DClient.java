package loneDruid;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class DClient {
    public static void main(String[] args) {
        String mag = "Dota2 figting ";
        try {
            Socket s = new Socket("127.0.0.1",6789);
            System.out.println(s);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            System.out.println("输入文本");
            Scanner scanner = new Scanner(System.in);
            dos.writeUTF(scanner.next());
            scanner.close();
            dos.close();
            os.close();
            s.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}

