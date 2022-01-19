package loneDruid;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.DoubleToIntFunction;

public class Atomic {
    //使用i++ 和increment 分别用多线程加到100000
    static int number = 100000;
    static int value = 0;

    public static void main(String[] args) {
        Thread t1[] = new Thread[number];
        for (int i = 0; i < number; i++) {
            Thread tt = new Thread() {
                public void run() {
                    value++;

                }
            };
            tt.start();
            t1[i] = tt;

        }

        for (Thread tx :
                t1) {
            try {
                tx.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("++-------" + value);
        AtomicInteger superx = new AtomicInteger();
        Thread t2[] = new Thread[number];
        for (int i = 0; i < number; i++) {
            Thread tt = new Thread() {
                public void run() {
                    superx.incrementAndGet();
                }
            };
            tt.start();
            t2[i] = tt;

        }
        for (Thread tz :
                t2) {
            try {
                tz.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("increment"+superx);
    }

}
