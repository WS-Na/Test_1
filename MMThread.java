package loneDruid;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MMThread {
    static Lock l1 = new ReentrantLock();
    static Lock l2 = new ReentrantLock();
    static int a1 = 0;
    static int a2 = 0;
    static int a3 = 0;
    static Condition condition = l1.newCondition();

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            public void run() {
                try {
                    l1.lock();
                    a1 = 11;
                    Thread.sleep(1000);
                    condition.await(2, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    l1.unlock();
                }
                try {
                    l1.lock();
                    {
                        l1.lock();
                        a3 = 13;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            condition.await(2, TimeUnit.SECONDS);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            l1.unlock();
                        }
                    }
                    a2 = 12;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        condition.await(2, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    l1.unlock();
                }
                System.out.printf("t1中将数字改为%d,%d,%d%n",a1,a2,a3);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                try {
                    l1.lock();
                    a2 = 21;
                    Thread.sleep(1000);
                    condition.await(2, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    l1.unlock();
                }
                try {
                    l1.lock();
                    {
                        l1.lock();
                        a1 = 23;
                        Thread.sleep(1000);
                        try {
                            condition.await(2, TimeUnit.SECONDS);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            l1.unlock();
                        }
                    }
                    a3 = 22;
                    Thread.sleep(1000);
                    try {
                        condition.await(2, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    l1.unlock();
                }
                System.out.printf("t2中将数字改为%d,%d,%d%n",a1,a2,a3);
            }
        };
        Thread t3 = new Thread() {
            public void run() {
                try {
                    l1.lock();
                    a3 = 31;
                    Thread.sleep(1000);
                    condition.await(2, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    l1.unlock();
                }
                try {
                    l1.lock();
                    {
                        l1.lock();
                        a2 = 33;
                        Thread.sleep(1000);
                        try {
                            condition.await(2, TimeUnit.SECONDS);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            l1.unlock();
                        }
                    }
                    a1 = 32;
                    Thread.sleep(1000);
                    try {
                        condition.await(2, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    l1.unlock();
                }
                System.out.printf("t3中将数字改为%d,%d,%d%n",a1,a2,a3);
            }

        };
        t1.start();
        t2.start();
        t3.start();
    }
}
