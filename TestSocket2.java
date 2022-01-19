package loneDruid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestSocket2 {
    public static void main(String[] args) throws UnknownHostException {
        List<String> ips = Collections.synchronizedList(new ArrayList<String>());
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,15,60, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
        AtomicInteger number = new AtomicInteger();
        for(int i = 0;i<255;i++) {
            String testip ="192.168.10"+(i+1);
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    boolean testResult = isReachable(testip);
                    if(testResult) {
                        ips.add(testip);
                    }
                    synchronized (number) {
                        System.out.println("已完成"+number.incrementAndGet()+"个ip测试");
                    }
                }
            });
        }
        threadPool.shutdown();
        try {
            if(threadPool.awaitTermination(180,TimeUnit.SECONDS)) {
                System.out.println("可以连同以下ip");
                for (String theip :
                        ips) {

                    System.out.println(theip);
                }
                System.out.println("总共连同IP数为"+ips.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean isReachable(String ip) {
        try {
            boolean reachable = false;

            Process p = Runtime.getRuntime().exec("ping -n 1" + ip);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.length() != 0)
                    sb.append(line + "\r\n");
            }

            //当有TTL出现的时候，就表示连通了
            reachable = sb.toString().contains("TTL");
            br.close();
            return reachable;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}