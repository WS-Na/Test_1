package loneDruid;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class Trylocked {
    public static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void log(String msg) {
        System.out.printf("%s%s%s%n", now(), Thread.currentThread().getName(), msg);
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread() {
            public void run() {
                boolean locked = false;
                try {
                    log("线程启动");
                    log("试图占用对象:lock");
                    locked = lock.tryLock();
                    if(locked) {
                        log("占用log");
                        log("占用5s中进行操作");
                        Thread.sleep(5000);

                    }else{
                        log("线程已被占用");
                    }
                }
                catch (InterruptedException interruptedException){
                    interruptedException.printStackTrace();
                }finally{
                    if(locked) {
                        log("释放lock");
                        lock.unlock();
                    }
                }
                log("线程结束");
            }
        };
        t1.setName("😊");
        t1.start();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        Thread t2 = new Thread() {
            public void run() {
                boolean locked = false;
                try {
                    log("线程启动");
                    log("试图占用对象:lock");
                    locked = lock.tryLock();
                    if(locked) {
                        log("占用log");
                        log("占用5s中进行操作");
                        Thread.sleep(5000);

                    }else{
                        log("线程已被占用");
                    }
                }
                catch (InterruptedException interruptedException){
                    interruptedException.printStackTrace();
                }finally{
                    if(locked) {
                        log("释放lock");
                        lock.unlock();
                    }
                }
                log("线程结束");
            }
        };
        t2.setName("📈");
        t2.start();
    }
}