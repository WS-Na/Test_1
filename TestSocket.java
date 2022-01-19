package loneDruid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class TestSocket {
    public static void main(String[] args) throws  UnknownHostException{
        InetAddress host= Inet4Address.getLocalHost();
String ip = host.getHostAddress();
String ipname = host.getHostName();
String ipn = host.getCanonicalHostName();
        System.out.println(ipn);
        System.out.println(ip);
        System.out.println(ipname);
        Process p = null;
        try {
            p = Runtime.getRuntime().exec("ping " + "192.168.10.255");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line.length() != 0)
                sb.append(line + "\r\n");
        }
        System.out.println("本次指令返回的消息是：");
        System.out.println(sb.toString());
    }

}
