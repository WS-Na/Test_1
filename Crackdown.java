package loneDruid;

import java.util.List;
import java.util.LinkedList;

public class Crackdown{
    static LinkedList<String> list = new LinkedList<>();
static String pass = "";

    public static void main(String[] args) throws InterruptedException {
        //
        // randomString(3);
        String password = randomString(3);
        Thread thread1 = new Thread() {
            public void run() {
                while (!pass.equals(password)) {
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pass =crackPassword(password);
                    System.out.println("找到了密码是"+pass);
                }
            }
        };
        Thread thread = new Thread() {
            public void run() {
                while (true) {
                    if (list == null) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
        for(;list.size()>0;)
                    System.out.println(list.poll());
                }
            }
        };
        thread1.start();
//        thread1.join();
        thread.setDaemon(true);
        thread.start();
        System.out.println("-----------" + password);
//        System.out.println(list);
        //System.out.println(list.poll());
    }
    //守护线程打印密码库

    //  穷举密码
    public static String crackPassword(String str) {
        String pass ="";
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char[] chars = new char[3];
        outLoop:
        for (int i = 0; i < pool.length(); i++) {
            for (int j = 0; j < pool.length(); j++) {
                for (int n = 0; n < pool.length(); n++) {
                    chars[0] = pool.charAt(i);
                    chars[1] = pool.charAt(j);
                    chars[2] = pool.charAt(n);
                    String temp = new String(chars);
                    list.offer(temp);
                    //  System.out.println(temp);
                    if (temp.equals(str)) {
//                        System.out.println("找到了密码是" + temp);
                        pass = temp;
                        break outLoop;
                    }
                }
            }
        }
        return pass;
    }

    //生成3位数随机密码
    public static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char[] chars = new char[length];

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * pool.length());
            chars[i] = pool.charAt(index);
        }
        return String.valueOf(chars);
    }
}