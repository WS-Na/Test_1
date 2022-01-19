package loneDruid;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLocked_2 {
    public static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void log(String msg) {
        System.out.printf("%s%s%s%n", now(), Thread.currentThread().getName(), msg);
    }

    public static void main(String[] args) {
        Lock lll = new ReentrantLock();
        Condition condition = lll.newCondition();
        Thread t1 = new Thread() {
            public void run() {
                try {
                    log("线程启动");
                    log("试图占有对象:lock");
                    lll.lock();
                    log("占有对象：lock");
                    log("进行5秒的业务操作");
                    Thread.sleep(5000);
                    log("临时释放对象 lock， 并等待");
                    condition.await();
                    Thread.sleep(5000);
                    condition.signal();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    log("释放对象：lock");
                    lll.unlock();
                }
                log("线程结束");
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                try {
                    log("线程启动");
                    log("试图占有对象:lock");
                    lll.lock();
                    log("占有对象：lock");
                    log("进行5秒的业务操作");
                    Thread.sleep(5000);
                    condition.signal();
                    log("临时释放对象 lock， 并等待");
                    condition.await();
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    log("释放对象：lock");
                    lll.unlock();
                }
                log("线程结束");
            }
        };
        t1.setName("😊");
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.setName("💢");
        t2.start();

    }
}
